package com.naveen.commandlist.config;

import com.naveen.commandlist.tasks.*;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import java.util.ArrayList;
import java.util.List;

@Configuration
public class FlowsConfiguration {

    @Profile("flow1")
    @Bean
    public List<Task> flow1Tasks(ApplicationContext context) {
        List<Task> list = new ArrayList<>();
        list.add(context.getBean(AuthorizationTask.class));
        list.add(context.getBean(ValidationTask.class));
        list.add(context.getBean(Flow1SpecificTask.class));
        return list;
    }

    @Profile("flow2")
    @Bean
    public List<Task> flow2Tasks(ApplicationContext context) {
        List<Task> list = new ArrayList<>();
        list.add(context.getBean(AuthorizationTask.class));
        list.add(context.getBean(ValidationTask.class));
        list.add(context.getBean(Flow2SpecificTask.class));
        return list;
    }

}
