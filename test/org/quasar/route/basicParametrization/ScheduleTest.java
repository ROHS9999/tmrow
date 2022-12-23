package org.quasar.route.basicParametrization;

import org.junit.Assert;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class ScheduleTest {
    ArrayList<Schedule.Days> days = new ArrayList<Schedule.Days>();
    Schedule scheduleTest = new Schedule(1000, 1800, days, 20 );

    @Test
    void getOpenHour() {
        Assert.assertEquals(1000, scheduleTest.getOpenHour(), 0);
    }

    @Test
    void setOpenHour() {
        scheduleTest.setOpenHour(1100);
        Assert.assertEquals(1100, scheduleTest.getOpenHour(), 0);
    }

    @Test
    void getCloseHour() {
        Assert.assertEquals(1800, scheduleTest.getCloseHour(), 0);
    }

    @Test
    void setCloseHour() {
        scheduleTest.setCloseHour(1900);
        Assert.assertEquals(1900, scheduleTest.getCloseHour(), 0);
    }

    @Test
    void getDay() {
        days.add(Schedule.Days.Monday);
        Schedule scheduleTest = new Schedule(1000, 1800, days, 20 );
        Assert.assertEquals(days, scheduleTest.getDay());
    }

    @Test
    void setDay() {
        days.add(Schedule.Days.Monday);
        Schedule scheduleTest = new Schedule(1000, 1800, days, 20 );
        ArrayList<Schedule.Days> newDays = new ArrayList<Schedule.Days>();
        newDays.add(Schedule.Days.Tuesday);
        scheduleTest.setDay(newDays);
        Assert.assertEquals(newDays, scheduleTest.getDay());
    }

    @Test
    void getPrice() {
        Assert.assertEquals(20, scheduleTest.getPrice(), 0);
    }

    @Test
    void setPrice() {
        scheduleTest.setPrice(30);
        Assert.assertEquals(30, scheduleTest.getPrice(), 0);
    }
}