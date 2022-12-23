package org.quasar.route.basicParametrization;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.sql.Timestamp;

import static org.junit.jupiter.api.Assertions.*;

class TimeIntervalTest {

    Timestamp startTime = Timestamp.valueOf("2022-05-09 17:00:00");
    Timestamp endTime = Timestamp.valueOf("2022-05-09 18:00:00");
    TimeInterval timeInterval = new TimeInterval(startTime,endTime);

    @Test
    void timeDifferenceInHours() {
        Assertions.assertEquals(1, timeInterval.timeDifferenceInHours());
    }

    @Test
    void timeDifferenceInMinutes() {
        Assertions.assertEquals(60, timeInterval.timeDifferenceInMinutes());
    }

    @Test
    void compareTwoTimeStamps() {
        Assertions.assertEquals(-1, timeInterval.compareTwoTimeStamps(startTime, endTime));
        Assertions.assertEquals(1, timeInterval.compareTwoTimeStamps(endTime, startTime));
        Assertions.assertEquals(0, timeInterval.compareTwoTimeStamps(startTime, startTime));
    }

    @Test
    void getStartTime() {
        Assertions.assertEquals(startTime, timeInterval.getStartTime());
    }

    @Test
    void setStartTime() {
        timeInterval.setStartTime(Timestamp.valueOf("2022-05-09 17:30:00"));
        Assertions.assertEquals(Timestamp.valueOf("2022-05-09 17:30:00"), timeInterval.getStartTime());
    }

    @Test
    void getEndTime() {
        Assertions.assertEquals(endTime, timeInterval.getEndTime());
    }

    @Test
    void setEndTime() {
        timeInterval.setEndTime(Timestamp.valueOf("2022-05-09 18:30:00"));
        Assertions.assertEquals(Timestamp.valueOf("2022-05-09 18:30:00"), timeInterval.getEndTime());
    }
}