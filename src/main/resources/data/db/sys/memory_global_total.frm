TYPE=VIEWquery=select `sys`.`format_bytes`(sum(`performance_schema`.`memory_summary_global_by_event_name`.`CURRENT_NUMBER_OF_BYTES_USED`)) AS `total_allocated` from `performance_schema`.`memory_summary_global_by_event_name`md5=8082fddb38d6165c0d33b88815ddf3d8updatable=0algorithm=1definer_user=mysql.sysdefiner_host=localhostsuid=0with_check_option=0timestamp=2018-10-12 17:09:33create-version=1source=SELECT sys.format_bytes(SUM(CURRENT_NUMBER_OF_BYTES_USED)) total_allocated FROM performance_schema.memory_summary_global_by_event_nameclient_cs_name=utf8connection_cl_name=utf8_general_ciview_body_utf8=select `sys`.`format_bytes`(sum(`performance_schema`.`memory_summary_global_by_event_name`.`CURRENT_NUMBER_OF_BYTES_USED`)) AS `total_allocated` from `performance_schema`.`memory_summary_global_by_event_name`
