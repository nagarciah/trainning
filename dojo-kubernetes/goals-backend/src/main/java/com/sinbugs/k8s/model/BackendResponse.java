package com.sinbugs.k8s.model;

import java.util.List;
import java.util.Map;

public class BackendResponse {
    List<Goal> goals;
    Map<String, String> hostInfo;

    public BackendResponse() {
    }

    public BackendResponse(List<Goal> goals, Map<String, String> hostinfo) {
        super();
        this.goals = goals;
        this.hostInfo = hostinfo;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("MyGoalsResponse [goals=");
        builder.append(goals);
        builder.append(", hostinfo=");
        builder.append(hostInfo);
        builder.append("]");
        return builder.toString();
    }

    public List<Goal> getGoals() {
        return goals;
    }

    public void setGoals(List<Goal> goals) {
        this.goals = goals;
    }

    public Map<String, String> getHostInfo() {
        return hostInfo;
    }

    public void setHostInfo(Map<String, String> hostinfo) {
        this.hostInfo = hostinfo;
    }

}
