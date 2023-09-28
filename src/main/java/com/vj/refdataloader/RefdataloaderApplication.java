package com.vj.refdataloader;

import com.vj.refdataloader.service.SampleJobService;
import org.jobrunr.jobs.JobDetails;
import org.jobrunr.scheduling.cron.CronExpression;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.jobrunr.scheduling.JobScheduler;
import org.jobrunr.scheduling.cron.Cron;

import javax.annotation.PostConstruct;


@SpringBootApplication
public class RefdataloaderApplication {

    @Autowired
    private JobScheduler jobScheduler;

    public static void main(String[] args) {
        SpringApplication.run(RefdataloaderApplication.class, args);
    }


    @PostConstruct
    public void scheduleRecurrently() {
        jobScheduler.<SampleJobService>scheduleRecurrently(Cron.every30seconds(), x -> x.executeSampleJob("a recurring job"));

        //jobScheduler.scheduleRecurrently(CronExpression.create("0 0 0 ? * SAT"), () -> someJobMethod(), );

    }

}
