TYPE=VIEWquery=select `performance_schema`.`global_status`.`VARIABLE_NAME` AS `variable_name`,`performance_schema`.`global_status`.`VARIABLE_VALUE` AS `variable_value` from `performance_schema`.`global_status` where ((`performance_schema`.`global_status`.`VARIABLE_NAME` like \'perf%lost\') and (`performance_schema`.`global_status`.`VARIABLE_VALUE` > 0))md5=a4602a3a66e4c59a9e72166d18821c07updatable=1algorithm=2definer_user=mysql.sysdefiner_host=localhostsuid=0with_check_option=0timestamp=2018-10-12 17:09:33create-version=1source=SELECT variable_name, variable_value FROM performance_schema.global_status WHERE variable_name LIKE \'perf%lost\' AND variable_value > 0client_cs_name=utf8connection_cl_name=utf8_general_ciview_body_utf8=select `performance_schema`.`global_status`.`VARIABLE_NAME` AS `variable_name`,`performance_schema`.`global_status`.`VARIABLE_VALUE` AS `variable_value` from `performance_schema`.`global_status` where ((`performance_schema`.`global_status`.`VARIABLE_NAME` like \'perf%lost\') and (`performance_schema`.`global_status`.`VARIABLE_VALUE` > 0))