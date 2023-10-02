package com.vj.refdataloader.config;


import com.vj.refdataloader.service.SpringJobActivator;
import org.jobrunr.configuration.JobRunr;
import org.jobrunr.scheduling.JobScheduler;
import org.jobrunr.server.JobActivator;
import org.jobrunr.storage.StorageProvider;
import org.jobrunr.storage.sql.mariadb.MariaDbStorageProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

@Configuration
public class JobRunrConfig {


    @Autowired
    @Qualifier("dataSource")
    private DataSource dataSource;


    @Autowired
    private SpringJobActivator springJobActivator;


    @Bean(name = "rjobScheduler")
    public JobScheduler rjobScheduler(ApplicationContext applicationContext){
        StorageProvider storageProvider = new MariaDbStorageProvider(dataSource);
        JobScheduler jobScheduler = JobRunr.configure().useStorageProvider(storageProvider).
                useJobActivator(springJobActivator).
                useBackgroundJobServer().
                useDashboard(8000).initialize().getJobScheduler();
        return jobScheduler;
    }
}
