package com.naveen.commandlist.tasks;

import org.springframework.stereotype.Component;

import java.util.Map;

@Component
public class ValidationTask implements Task{

    @Override
    public boolean handleTask(Map<String, Object> context) {
        return true;
    }
}
