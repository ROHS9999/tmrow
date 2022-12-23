package org.quasar.route.basicParametrization;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PointOfInterestTest {
    PointOfInterest pointOfInterest = new PointOfInterest(101, "Sé", 38.710044211620755,
            -9.13269653889031, 30, 930, 1900,
            2, 0, 10, 40);

    @Test
    void getGHPoint() {

        //Assertions.assertEquals(pointOfInterest.getGHPoint());
    }

    @Test
    void getPointID() {
        Assertions.assertEquals(101, pointOfInterest.getPointID());
    }

    @Test
    void setPointID() {
        pointOfInterest.setPointID(102);
        Assertions.assertEquals(102, pointOfInterest.getPointID());
    }

    @Test
    void getName() {
        Assertions.assertEquals("Sé", pointOfInterest.getName());
    }

    @Test
    void setName() {
        pointOfInterest.setName("Sé de Lisboa");
        Assertions.assertEquals("Sé de Lisboa", pointOfInterest.getName());
    }

    @Test
    void getCategoryID() {
        Assertions.assertEquals(2, pointOfInterest.getCategoryID());
    }

    @Test
    void setCategoryID() {
        pointOfInterest.setCategoryID(3);
        Assertions.assertEquals(3, pointOfInterest.getCategoryID());
    }

    @Test
    void setVisitTime() {
        pointOfInterest.setVisitTime(50);
        Assertions.assertEquals(50, pointOfInterest.getVisitTime());
    }

    @Test
    void getLatitude() {
        Assertions.assertEquals(38.710044211620755, pointOfInterest.getLatitude(), 0);
    }

    @Test
    void getLongitude() {
        Assertions.assertEquals(-9.13269653889031, pointOfInterest.getLongitude(), 0);
    }

    @Test
    void setLatitude() {
        pointOfInterest.setLatitude(38.832142948929273);
        Assertions.assertEquals(38.832142948929273, pointOfInterest.getLatitude(), 0);
    }

    @Test
    void setLongitude() {
        pointOfInterest.setLongitude(-9.20492173281823);
        Assertions.assertEquals(-9.20492173281823, pointOfInterest.getLongitude(), 0);
    }

    @Test
    void setCategory() {
        pointOfInterest.setCategory(3);
        Assertions.assertEquals(3, pointOfInterest.getCategoryID());
    }

    @Test
    void setSustainability() {
        pointOfInterest.setSustainability(35);
        Assertions.assertEquals(35, pointOfInterest.getSustainability());
    }

    @Test
    void getOpenHour() {
        Assertions.assertEquals(930, pointOfInterest.getOpenHour());
    }

    @Test
    void setOpenHour() {
        pointOfInterest.setOpenHour(1000);
        Assertions.assertEquals(1000, pointOfInterest.getOpenHour());
    }

    @Test
    void getCloseHour() {
        Assertions.assertEquals(1900, pointOfInterest.getCloseHour());
    }

    @Test
    void setCloseHour() {
        pointOfInterest.setCloseHour(2000);
        Assertions.assertEquals(2000, pointOfInterest.getCloseHour());
    }

    @Test
    void getCrowding() {
        Assertions.assertEquals(10, pointOfInterest.getCrowding());
    }

    @Test
    void setCrowding() {
        pointOfInterest.setCrowding(15);
        Assertions.assertEquals(15, pointOfInterest.getCrowding());
    }

    @Test
    void getSustainability() {
        Assertions.assertEquals(30, pointOfInterest.getSustainability());
    }

    @Test
    void getVisitTime() {
        Assertions.assertEquals(40, pointOfInterest.getVisitTime());
    }

    @Test
    void getPrice() {
        Assertions.assertEquals(0, pointOfInterest.getPrice());
    }

    @Test
    void setPrice() {
        pointOfInterest.setPrice(5);
        Assertions.assertEquals(5, pointOfInterest.getPrice());
    }
}