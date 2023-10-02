package com.vj.refdataloader.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
@Slf4j
public class MDHJob {

    private final JdbcTemplate jdbcTemplate;


    @Autowired
    public MDHJob(@Qualifier("sqlServerJdbcTemplate") JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public void executeInfraDetailsJob() {
        log.info("Execute SPK Job");
        //log.info("Value of JDBC Template : {}", jdbcTemplate);
        List<Map<String,Object>> output = jdbcTemplate.queryForList("SELECT * FROM TestTable");
        log.info(String.valueOf(output));
    }

}
