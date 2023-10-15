package com.naveen.commandlist.tasks;

import java.util.Map;

public class AuthorizationTask implements Task{

    @Override
    public boolean handleTask(Map<String, Object> context) {
        return true;
    }
}
