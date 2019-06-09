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

package gara.strategies.config;

import gara.core.config.StrategyPropertiesConfig;
import gara.model.strategy.ExchangeProperty;
import gara.model.strategy.SecurityProperty;
import gara.ui.config.WebSecurityConfig;
import org.springframework.boot.autoconfigure.ImportAutoConfiguration;
import org.springframework.stereotype.Component;

/**
 * Basic example of how to use properties and extend them
 * <p>
 * If is need it to customize SecurityProperty or ExchangeProperty would be
 * need it just to create a new class and extend form them
 *
 * <code>
 *   public class CustomSecurityProperty extends SecurityProperty {}
 * </code>
 *
 * @author ruben.fanjul
 * @version 0.1
 */

@Component
@ImportAutoConfiguration(classes = WebSecurityConfig.class)
public class StrategyProperties extends StrategyPropertiesConfig<SecurityProperty, ExchangeProperty<SecurityProperty>> {
}
