package org.quasar.route.basicParametrization;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.sql.Timestamp;

import static org.junit.jupiter.api.Assertions.*;

class TimedPointOfInterestTest {
    PointOfInterest pointOfInterest = new PointOfInterest(101, "Sé", 38.710044211620755,
            -9.13269653889031, 30, 930, 1900,
            2, 0, 10, 40);
    TimedPointOfInterest timedPointOfInterest = new TimedPointOfInterest(pointOfInterest, Timestamp.valueOf("2022-05-09 17:00:00"));

    @Test
    void getPoi() {
        Assertions.assertEquals(pointOfInterest, timedPointOfInterest.getPoi());
    }

    @Test
    void setPoi() {
        PointOfInterest pointOfInterest2 = new PointOfInterest(102, "Sé de Lisboa", 38.810044211620755,
                -9.23269653889031, 30, 930, 1900,
                2, 0, 10, 40);
        timedPointOfInterest.setPoi(pointOfInterest2);
        Assertions.assertEquals(pointOfInterest2, timedPointOfInterest.getPoi());
    }

    @Test
    void getVisitTimestamp() {
        Assertions.assertEquals(Timestamp.valueOf("2022-05-09 17:00:00"), timedPointOfInterest.getVisitTimestamp());
    }

    @Test
    void setVisitTimestamp() {
        timedPointOfInterest.setVisitTimestamp(Timestamp.valueOf("2022-05-09 18:00:00"));
        Assertions.assertEquals(Timestamp.valueOf("2022-05-09 18:00:00"), timedPointOfInterest.getVisitTimestamp());
    }
}