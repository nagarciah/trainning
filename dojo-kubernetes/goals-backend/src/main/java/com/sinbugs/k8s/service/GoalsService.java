package com.sinbugs.k8s.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.sinbugs.k8s.model.Goal;

/**
 * Permite ejecutar acciones y procesos con las metas
 * 
 * @author nelson
 *
 */
@Service
public class GoalsService {

    private Logger log = LoggerFactory.getLogger(getClass());
    
    private List<Goal> goals = new ArrayList<>();
    private Random idGenerator = new Random(System.currentTimeMillis());

    /**
     * Agrega una nueva meta al "repositorio" de metas
     * 
     * @param newGoal
     * @return
     */
    public Goal add(Goal newGoal) {
        newGoal.setId(idGenerator.nextLong());
        this.goals.add(newGoal);
        
        log.info("Meta agregada en el backend: {}", newGoal);
        
        return newGoal;
    }

    /**
     * Retorna todas las metas que existan en el repositorio
     * 
     * @return Un {@link List} con todas las metas
     */
    public List<Goal> getAll() {
        log.info("Consultando metas en el backend...");
        
        return goals;
    }
}
