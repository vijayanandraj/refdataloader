package com.vj.refdataloader.service;

import org.jobrunr.server.JobActivator;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

@Component
public class SpringJobActivator implements JobActivator {

    private final ApplicationContext context;

    public SpringJobActivator(ApplicationContext context) {
        this.context = context;
    }

    @Override
    public <T> T activateJob(Class<T> type) {
        return context.getBean(type);
    }
}
