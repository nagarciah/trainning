package com.sinbugs.k8s.service;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;

import org.assertj.core.data.Offset;
import org.junit.Before;
import org.junit.Test;

import com.sinbugs.k8s.model.Goal;

public class GoalsServiceTest {

    private GoalsService goalsService;

    @Before
    public void initTest() {
        this.goalsService = new GoalsService();
    }

    @Test
    public void testAdd() {
        Goal goal = addNewGoal();

        assertThat(goal.getId())
            .isNotNull()
            .isNotCloseTo(0L, Offset.offset(Long.parseLong("0")));
    }

    @Test
    public void testGetAll() {
        Goal newGoal = addNewGoal();
        List<Goal> goals = goalsService.getAll();
        
        assertThat(goals)
            .hasSize(1)
            .hasOnlyElementsOfType(Goal.class)
            .contains(newGoal);
    }


    private Goal addNewGoal() {
        Date dueDate = new GregorianCalendar(2018, 0, 31).getTime();
        Goal goal = new Goal("Aprender Kubernetes con Java",
                "Voy a aprender las bases de Kubernetes y como usarlo para implementar sistemas escritos usando Java",
                dueDate);

        return goalsService.add(goal);
    }
}
