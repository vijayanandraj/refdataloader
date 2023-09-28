package com.vj.refdataloader.service;

import lombok.extern.slf4j.Slf4j;
import org.jobrunr.jobs.annotations.Job;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class HorizonInsightsJob {

    @Autowired
    @Qualifier("oracleJdbcTemplate")
    private JdbcTemplate jdbcTemplate;

    @Job(name = "This job loads the SPK information from Horizon Insights to AIT_SDM_Data table", retries = 2)
    public void executeSPKJob(String variable) {
        log.info("Execute SPK Job");
    }

}
