package com.naveen.commandlist.tasks;

import java.util.Map;

public interface Task {

    boolean handleTask(Map<String, Object> context);
}
