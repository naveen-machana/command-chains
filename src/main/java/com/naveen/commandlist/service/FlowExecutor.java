package com.naveen.commandlist.service;

import com.naveen.commandlist.tasks.Task;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class FlowExecutor {

    @Autowired
    List<Task> tasksForFlow;

    public Object executeSomeOperation(Object input) {
        Map<String, Object> inputMap = new HashMap<>();
        inputMap.put("input-object", input);

        for (Task task : tasksForFlow) {
            boolean shouldContinue = task.handleTask(inputMap);
            if (!shouldContinue) {
                return inputMap.get("return-value");
            }
        }
        return inputMap.get("return-value");
    }
}
