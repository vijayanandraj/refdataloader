package com.vj.refdataloader.service;

import lombok.extern.slf4j.Slf4j;
import org.jobrunr.scheduling.JobScheduler;
import org.jobrunr.scheduling.cron.Cron;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class JobSchedulerRunner implements ApplicationRunner {

    @Autowired
    private JobScheduler rjobScheduler;

    @Autowired
    private MDHJob mdhJob;


    @Override
    public void run(ApplicationArguments args) throws Exception {
        log.info("In ApplicationRunner run method");
        rjobScheduler.<Void>scheduleRecurrently(Cron.every30seconds(), () -> mdhJob.executeInfraDetailsJob());
    }
}
