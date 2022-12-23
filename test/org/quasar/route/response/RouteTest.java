package org.quasar.route.response;

import com.graphhopper.util.shapes.GHPoint;
import com.graphhopper.util.shapes.GHPoint3D;
import org.junit.jupiter.api.Test;
import org.quasar.route.basicParametrization.PointOfInterest;
import org.quasar.route.basicParametrization.TimedPointOfInterest;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;

import static org.junit.jupiter.api.Assertions.*;

class RouteTest {

    PointOfInterest pointOfInterest1 = new PointOfInterest(101, "Sé de Lisboa", 38.7100442,
            -9.1326965, 30, 930, 1900,
            2, 0, 10, 40);
    TimedPointOfInterest timedPointOfInterest1 = new TimedPointOfInterest(pointOfInterest1, Timestamp.valueOf("2022-05-09 17:00:00"));
    PointOfInterest pointOfInterest2 = new PointOfInterest(50, "Castelo de São Jorge", 38.7139092,
            -9.1334762, 30, 930, 1900,
            2, 5, 10, 40);
    TimedPointOfInterest timedPointOfInterest2 = new TimedPointOfInterest(pointOfInterest2, Timestamp.valueOf("2022-05-09 18:00:00"));

    GHPoint3D gh3D1 = new GHPoint3D(38.7100442,-9.1326965, 45);
    GHPoint3D gh3D2 = new GHPoint3D(38.7139092,-9.1334762, 96);
    ArrayList<GHPoint3D> line = new ArrayList<GHPoint3D>(Arrays.asList(gh3D1, gh3D2));

    LinkedList<TimedPointOfInterest> pois = new LinkedList<TimedPointOfInterest>(Arrays.asList(timedPointOfInterest1,timedPointOfInterest2));

    GHPoint ghPoint1 = new GHPoint(38.7100442,-9.1326965);
    GHPoint ghPoint2 = new GHPoint(38.7139092,-9.1334762);

    Route route = new Route(pois, line, 1, 1000.0, 30, 5, ghPoint1, ghPoint2,
            Timestamp.valueOf("2022-05-09 16:00:00"), Timestamp.valueOf("2022-05-09 17:00:00"), 100);

    @Test
    void getPois() {
        assertEquals(pois, route.getPois());
    }

    @Test
    void setPois() {
        PointOfInterest pointOfInterest3 = new PointOfInterest(50, "Praça do Comércio", 38.7139092,
                -9.1334762, 30, 930, 1900,
                2, 5, 10, 40);
        TimedPointOfInterest timedPointOfInterest3 = new TimedPointOfInterest(pointOfInterest3, Timestamp.valueOf("2022-05-09 18:00:00"));
        pois.add(timedPointOfInterest3);
        route.setPois(pois);
        assertEquals(pois, route.getPois());
    }

    @Test
    void getLine() {
        System.out.println(route.getLine());
        assertEquals(line, route.getLine());
    }

    @Test
    void setLine() {
        GHPoint3D gh3D3 = new GHPoint3D(38.7076507, -9.1365164, 2);
        line.add(gh3D3);
        route.setLine(line);
        assertEquals(line, route.getLine());
    }

    @Test
    void getTime() {
        assertEquals(1, route.getTime());
    }

    @Test
    void setTime() {
        route.setTime(2);
        assertEquals(2, route.getTime());
    }

    @Test
    void getDistance() {
        assertEquals(1000.0, route.getDistance());
    }

    @Test
    void setDistance() {
        route.setDistance(2000.0);
        assertEquals(2000.0, route.getDistance());
    }

    @Test
    void getSustainability() {
        assertEquals(30, route.getSustainability());
    }

    @Test
    void setSustainability() {
        route.setSustainability(40);
        assertEquals(40, route.getSustainability());
    }

    @Test
    void getPrice() {
        assertEquals(5, route.getPrice());
    }

    @Test
    void setPrice() {
        route.setPrice(10);
        assertEquals(10, route.getPrice());
    }

    @Test
    void getOrigin() {
        assertEquals(ghPoint1, route.getOrigin());
    }

    @Test
    void getDestination() {
        assertEquals(ghPoint2, route.getDestination());
    }

    @Test
    void getStartTime() {
        assertEquals(Timestamp.valueOf("2022-05-09 16:00:00"), route.getStartTime());
    }

    @Test
    void getEndTime() {
        assertEquals(Timestamp.valueOf("2022-05-09 17:00:00"), route.getEndTime());
    }

    @Test
    void getCalories() {
        assertEquals(100, route.getCalories());
    }
}