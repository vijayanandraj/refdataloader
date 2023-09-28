package com.vj.refdataloader.service;


import lombok.extern.slf4j.Slf4j;
import org.jobrunr.jobs.annotations.Job;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class MDHJob {

    @Autowired
    @Qualifier("mysqlJdbcTemplate")
    private JdbcTemplate jdbcTemplate;

    @Job(name = "This job loads the Infra information from MDH to MAT Tables", retries = 2)
    public void executeInfraDetailsJob(String variable) {
        log.info("Execute SPK Job");
    }

}
