package com.sinbugs.k8s.api;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.sinbugs.k8s.model.Goal;
import com.sinbugs.k8s.model.BackendResponse;
import com.sinbugs.k8s.service.GoalsService;

/**
 * API que ofrece las funcionalidades para gestionar las metas
 * 
 * @author nelson
 *
 */
@RestController
public class GoalsBackendController {

    @Autowired
    GoalsService goalsService;
    
    @GetMapping("/")
    public BackendResponse getAll() throws UnknownHostException{
        return new BackendResponse(this.goalsService.getAll(), info());
    }
    
    @PostMapping("/")
    public Goal addNew(@RequestBody Goal newGoal){
        return this.goalsService.add(newGoal);
    }
    
    private Map<String, String> info() throws UnknownHostException {
        Map<String, String> data = new HashMap<>();
        InetAddress ip = InetAddress.getLocalHost();
        data.put("ip", ip.getHostAddress());
        data.put("hostname", ip.getHostName());
        data.put("canonicalHostname", ip.getCanonicalHostName());

        return data;
    }
}
