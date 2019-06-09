/*
 * Copyright &copy; 2018 by GaraQuant
 * All rights reserved. No part of this publication may be reproduced,
 * distributed, or transmitted in any form or by any means, including photocopying,
 * recording, or other electronic or mechanical methods, without the prior written
 * permission of the publisher, except in the case of brief quotations embodied
 * in critical reviews and certain other noncommercial uses permitted by copyright law.
 * For permission requests, write to the publisher, addressed &ldquo;Attention: Permissions Coordinator&rdquo;
 * at the address below.
 * <p>
 * GaraQuant
 * Sonnenpark 20A, 8808 Pf&auml;ffikon
 */
package gara.strategies;

import gara.core.exchange.Exchange;
import gara.core.repository.SecurityRepository;
import gara.core.service.AbstractStrategyService;
import gara.core.service.ExchangeService;
import gara.core.service.LookBackService;
import gara.core.service.OrderService;
import gara.model.db.Security;
import gara.model.market.Bar;
import gara.model.market.Tick;
import gara.strategies.config.StrategyProperties;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

/**
 * Basic strategy example.
 * <p>
 * 21.09.18 <a href="mailto:contact@gara-quant.com">GaraQuant</a>
 *
 * @author ruben.fanjul
 * @version 0.1
 */
@Component
public class ExampleStrategy extends AbstractStrategyService {

  /**
   * log.
   */
  private static final Logger LOGGER = LoggerFactory.getLogger(ExampleStrategy.class);

  /**
   * ExchangeService.
   */
  private ExchangeService exchangeService;

  /**
   * StrategyProperties.
   */
  private StrategyProperties strategyProperties;

  /**
   * OrderService.
   */
  private OrderService orderService;

  /**
   * SecurityRepository
   */
  private SecurityRepository securityRepository;

  /**
   * Constructor.
   *
   * @param exchangeService    {@link gara.core.service.ExchangeService}
   * @param orderService       {@link gara.core.service.OrderService}
   * @param strategyProperties {@link StrategyProperties}
   */
  @Autowired
  public ExampleStrategy(
      final ExchangeService exchangeService,
      final OrderService orderService,
      final StrategyProperties strategyProperties,
      final SecurityRepository securityRepository) {
    this.exchangeService = exchangeService;
    this.orderService = orderService;
    this.strategyProperties = strategyProperties;
    this.securityRepository = securityRepository;
  }

  /**
   * We should initialize here all the necessary for the strategy since, gara.core will load this
   * class, al the DI would be null if we use the class's constructor.
   */
  @PostConstruct
  public void init() {
    LOGGER.info("ExampleStrategy::PostConstruct");

    strategyProperties.getExchanges().forEach(exchangeProperty -> {
      try {

        Exchange exchange = this.exchangeService.factory(exchangeProperty.getExchangeEnum());

        this.orderService.setExchange(exchange);

        exchange.getAccount();

        exchange.persistAllSecurities();

        exchangeProperty
            .getSecurities()
            .iterator()
            .forEachRemaining(securityProperty -> {
                  Security security = this
                      .securityRepository
                      .findBySymbolIgnoreCaseAndExchange(securityProperty.getSymbol(), exchange.getExchangeEnum());
                  exchange.subscribe(security);

                  exchangeProperty
                      .getPeriods()
                      .forEach(durationEnum ->
                          exchange.subscribeWithBars(security.getSymbol(), durationEnum)
                      );
                }
            );

      } catch (Exception e) {
        LOGGER.error("Error => ", e);
      }
    });

  }

  /**
   * {@inheritDoc}
   * <p>
   * Executed every time that there is a tick coming from the exchange.
   */
  public void onTick(final Tick tick) {
    LOGGER.info("ExampleStrategy::onTick {}", tick);
  }

  /**
   * {@inheritDoc}
   * <p>
   * Executed every time that a new bar is generated.
   */
  @Override
  public void onBar(final Bar bar) {
    LOGGER.info("ExampleStrategy::onBar {}", bar);
  }
}
