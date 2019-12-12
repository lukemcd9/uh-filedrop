package edu.hawaii.its.filedrop.service;

import java.util.HashMap;
import java.util.Map;

public class ProcessVariableHolder {

    private Map<String, Object> processVariables = new HashMap<>();

    // Constructor
    public ProcessVariableHolder() {
        this(null);
    }

    // Constructor
    public ProcessVariableHolder(Map<String, Object> variables) {
        if (variables != null) {
            processVariables.putAll(variables);
        }
    }

    public Map<String, Object> getMap() {
        return processVariables;
    }

    public boolean containsKey(String key) {
        return processVariables.containsKey(key);
    }

    public boolean containsValue(Object object) {
        return processVariables.containsValue(object);
    }

    public void add(String key, Object object) {
        processVariables.put(key, object);
    }

    public void add(Map<String, Object> variables) {
        processVariables.putAll(variables);
    }

    public Object get(String key) {
        return processVariables.get(key);
    }

    public int size() {
        return processVariables.size();
    }

    @Override
    public String toString() {
        return "ProcessVariableHolder [processVariables=" + processVariables + "]";
    }
}
