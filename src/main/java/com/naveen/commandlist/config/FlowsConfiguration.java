package com.naveen.commandlist.config;

import com.naveen.commandlist.tasks.*;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Configuration
public class FlowsConfiguration {

    @Bean
    public List<Task> flow1Tasks(ApplicationContext context) {
        List<Task> list = new ArrayList<>();
        list.add(context.getBean(AuthorizationTask.class));
        list.add(context.getBean(ValidationTask.class));
        list.add(context.getBean(Flow1SpecificTask.class));
        return list;
    }

    @Bean
    public List<Task> flow2Tasks(ApplicationContext context) {
        List<Task> list = new ArrayList<>();
        list.add(context.getBean(AuthorizationTask.class));
        list.add(context.getBean(ValidationTask.class));
        list.add(context.getBean(Flow2SpecificTask.class));
        return list;
    }

    @Bean
    public Map<String, List<Task>> tasksByFlowType(ApplicationContext context) {
        Map<String, List<Task>> tasksByFlowType = new HashMap<>();
        tasksByFlowType.put("FLOW1", this.flow1Tasks(context));
        tasksByFlowType.put("FLOW2", this.flow2Tasks(context));
        return tasksByFlowType;
    }
}
