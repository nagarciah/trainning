package com.sinbugs.k8s.api;

import java.io.File;
import java.io.IOException;
import java.net.InetAddress;
import java.net.URISyntaxException;
import java.net.UnknownHostException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.validation.constraints.NotNull;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.sinbugs.k8s.model.BackendResponse;
import com.sinbugs.k8s.model.FrontendResponse;
import com.sinbugs.k8s.model.Goal;
import com.sinbugs.k8s.service.GoalsBackend;

/**
 * API que ofrece las funcionalidades para gestionar las metas
 * 
 * @author nelson
 *
 */
@RestController
@RequestMapping("/api/goal")
public class GoalsFrontendController {
    
    private Logger log = LoggerFactory.getLogger(getClass());

    @Autowired
    private GoalsBackend goalsBackend;
    
    @Value("${goals.filesDir:/tmp}")
    private String filesDir;
    
    @GetMapping("/")
    public FrontendResponse getAll() throws UnknownHostException{
        BackendResponse backendResponse = goalsBackend.getAll();
        return new FrontendResponse(backendResponse.getGoals(), info(), backendResponse.getHostInfo());
    }
    
    @PostMapping("/")
    public Goal addNew(@RequestBody Goal newGoal){
        return goalsBackend.add(newGoal);
    }
    
    @GetMapping("/image/{filename}")
    public @ResponseBody ResponseEntity<Resource> download(@NotNull @PathVariable String filename, HttpServletRequest request) throws IOException, URISyntaxException {
        
        File doc = new File(filesDir, filename + ".png");
        log.info("Descargando archivo: '{}' desde la ruta '{}'", filename, doc.getAbsolutePath());

        if(!doc.exists()){
            return ResponseEntity.notFound().build();
        }

        Path path = Paths.get(doc.getAbsolutePath());
        ByteArrayResource resource = new ByteArrayResource(Files.readAllBytes(path));

        StringBuilder sb = new StringBuilder();
        sb.append("filename='").append(doc.getName()).append("'");

        HttpHeaders headers = new HttpHeaders();
        headers.add("Content-Disposition", sb.toString());

        return ResponseEntity.ok()
                .headers(headers)
                .contentLength(doc.length())
                .contentType(MediaType.parseMediaType("image/png"))
                .body(resource);
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
