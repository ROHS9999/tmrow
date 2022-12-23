package org.quasar.route.basicParametrization;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class EffortTest {
    Effort effort = new Effort(759, 547.096, 85, 59.9);

    @Test
    void getMET() {
        Assertions.assertEquals(1.9617849575921904, effort.getMET());
    }

    @Test
    void calorieEstimation() {
        Assertions.assertEquals(20.356028333333338, effort.calorieEstimation());
    }
}