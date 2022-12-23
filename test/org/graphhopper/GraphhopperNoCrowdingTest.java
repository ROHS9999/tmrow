package org.graphhopper;

import com.graphhopper.util.shapes.GHPoint;
import org.junit.jupiter.api.Test;
import org.quasar.route.basicParametrization.PointOfInterest;
import org.quasar.route.basicParametrization.TimeInterval;
import org.quasar.route.graphhopper.GraphhopperNoCrowding;
import org.quasar.route.request.RouteRequest;

import java.sql.Timestamp;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class GraphhopperNoCrowdingTest {
    //Creation of the RouteRequest
    GHPoint origin = new GHPoint(38.714466, -9.140692); // user location or local departure for the tour
    GHPoint destination = new GHPoint(38.710516, -9.136196); // user ending local
    Timestamp startTime = Timestamp.valueOf("2020-10-03 14:00:00.0");
    Timestamp endTime = Timestamp.valueOf("2020-10-03 19:00:00.0");
    TimeInterval availableTime = new TimeInterval(startTime, endTime); // user available time for the route (start and end time for the route)
    int effortLevel = 1; // the maximum level of physical effort that the user is able to do
    int budget = 100; // the budget that the user have to visit POIs
    LinkedList<Integer> selectedPoints = new LinkedList<Integer>(Arrays.asList(1,2)); // user selected POIs to visit (the APP send just the IDs)
    List<Integer> selectedCategories = Arrays.asList(1,2); // user preferred categories of POIs
    boolean checkWeather = false; // users states if they want suggestions or not
    RouteRequest routeRequest = new RouteRequest(origin, destination, startTime, availableTime.timeDifferenceInHours(), effortLevel,
            budget, selectedPoints, selectedCategories, checkWeather);

    //Creation of the GraphhoperNoCrowding
    GraphhopperNoCrowding ghNoCrowding = new GraphhopperNoCrowding(routeRequest);

    //Creation of POI's
    PointOfInterest poi1 = new PointOfInterest(1, "Castelo de São Jorge", 38.7139092, -9.1334762, 45, 9, 18, 1, 10, 10,
            70);
    PointOfInterest poi2 = new PointOfInterest(1, "Sé de Lisboa", 38.7098768, -9.1325884, 79, 9, 18, 7, 5, 4,
            70);
    PointOfInterest poi3 = new PointOfInterest(1, "Praça do Comércio", 38.7076507, -9.1365164, 62, 0, 2359, 2, 0, 20,
            70);

    @Test
    void copyDataFromDatabase() {
        //DB
    }

    @Test
    void getSelectedPOIs() {
        //DB
    }

    @Test
    void getAllScenarios() {
        LinkedList<PointOfInterest> selectedPoints = new LinkedList<PointOfInterest>(Arrays.asList(poi1, poi2, poi3));
        System.out.println(ghNoCrowding.getAllScenarios(selectedPoints));
    }

    @Test
    void calculateTimeBetweenPOIsInScenarios() {
    }

    @Test
    void selectGHPoint() {
    }

    @Test
    void dividedRequest() {
    }

    @Test
    void compareAlternativeRoutes() {
    }

    @Test
    void chooseBestDistance() {
    }

    @Test
    void distFrom() {
    }

    @Test
    void pathInfo() {
    }

    @Test
    void evaluateBudget() {
    }

    @Test
    void evaluateSustainability() {
    }

    @Test
    void closestNode() {
    }

    @Test
    void closestEdge() {
    }

    @Test
    void getGraphStorage() {
    }

    @Test
    void getGraphhopper() {
    }

    @Test
    void getDatabasePOIs() {
    }

    @Test
    void createRouteForResponse() {
    }

    @Test
    void dataForRouteResponse() {
    }

    @Test
    void distances() {
    }

    @Test
    void getRouteLevelOfCrowding() {
    }
}