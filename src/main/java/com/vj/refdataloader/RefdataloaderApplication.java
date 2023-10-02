package com.vj.refdataloader;

import com.vj.refdataloader.service.MDHJob;
import com.vj.refdataloader.service.SampleJobService;
import org.jobrunr.jobs.JobDetails;
import org.jobrunr.jobs.JobId;
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
    private JobScheduler rjobScheduler;

    @Autowired
    private MDHJob mdhJob;

    public static void main(String[] args) {
        SpringApplication.run(RefdataloaderApplication.class, args);
    }


//    @PostConstruct
//    public void scheduleRecurrently() {
//        //mdhJob.executeInfraDetailsJob();
//        //rjobScheduler.<SampleJobService>scheduleRecurrently(Cron.every30seconds(), x -> x.executeSampleJob("a recurring job"));
//
//        rjobScheduler.<Void>scheduleRecurrently(Cron.every30seconds(), () -> mdhJob.executeInfraDetailsJob());
//
//        //rjobScheduler.<Void>scheduleRecurrently(Cron.every30seconds(), () -> mdhJob.executeInfraDetailsJob());
//
//        //jobScheduler.scheduleRecurrently(CronExpression.create("0 0 0 ? * SAT"), () -> someJobMethod(), );
//
//    }

}
