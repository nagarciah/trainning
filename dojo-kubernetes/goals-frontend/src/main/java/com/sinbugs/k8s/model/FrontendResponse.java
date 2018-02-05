package com.sinbugs.k8s.model;

import java.util.List;
import java.util.Map;

public class FrontendResponse {
    List<Goal> goals;
    Map<String, String> frontendInfo;
    Map<String, String> backendInfo;

    public FrontendResponse() {
    }

    public FrontendResponse(List<Goal> goals, Map<String, String> frontendInfo, Map<String, String> backendInfo) {
        super();
        this.goals = goals;
        this.frontendInfo = frontendInfo;
        this.backendInfo = backendInfo;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("FrontendResponse [goals=");
        builder.append(goals);
        builder.append(", frontendInfo=");
        builder.append(frontendInfo);
        builder.append(", backendInfo=");
        builder.append(backendInfo);
        builder.append("]");
        return builder.toString();
    }

    public List<Goal> getGoals() {
        return goals;
    }

    public void setGoals(List<Goal> goals) {
        this.goals = goals;
    }

    public Map<String, String> getFrontendInfo() {
        return frontendInfo;
    }

    public void setFrontendInfo(Map<String, String> frontendInfo) {
        this.frontendInfo = frontendInfo;
    }

    public Map<String, String> getBackendInfo() {
        return backendInfo;
    }

    public void setBackendInfo(Map<String, String> backendInfo) {
        this.backendInfo = backendInfo;
    }

}
