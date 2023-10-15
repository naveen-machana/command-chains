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
    Map<String, List<Task>> tasksByFlowType;

    @Value("flow.type")
    private String flowType;

    public Object executeSomeOperation(Object input) {
        Map<String, Object> inputMap = new HashMap<>();
        inputMap.put("inputObject", input);

        List<Task> tasks = tasksByFlowType.get(flowType);
        for (Task task : tasks) {
            boolean shouldContinue = task.handleTask(inputMap);
            if (!shouldContinue) {
                return inputMap.get("return");
            }
        }
        return inputMap.get("return");
    }
}
