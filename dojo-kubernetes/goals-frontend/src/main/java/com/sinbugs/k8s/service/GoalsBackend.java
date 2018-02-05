package com.sinbugs.k8s.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.sinbugs.k8s.model.Goal;
import com.sinbugs.k8s.model.BackendResponse;
import com.sinbugs.k8s.model.FrontendResponse;

@Service
public class GoalsBackend {

    private RestTemplate restTemplate = new RestTemplate();
    private String backendUrl;

    @Autowired
    public GoalsBackend(@Value("${goals.backendUrl}") String backendUrl) {
        super();
        this.backendUrl = backendUrl;
    }

    public BackendResponse getAll() {
        BackendResponse goals = restTemplate.getForObject(backendUrl, BackendResponse.class);
        return goals;
    }

    public Goal add(Goal newGoal) {
        return restTemplate.postForObject(backendUrl, newGoal, Goal.class);
    }

}
