package org.quasar.route.response;

import com.graphhopper.util.shapes.GHPoint;
import org.junit.jupiter.api.Test;
import org.quasar.route.basicParametrization.TimeInterval;
import org.quasar.route.request.RouteRequest;

import java.sql.Timestamp;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ConvertRouteResponseTest {
    //Creation on RouteRequest
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

    @Test
    void convertToJson() {
        //Create ConvertRouteResponde
        //ConvertRouteResponse convertRouteResponse = new ConvertRouteResponse(routeRequest);
    }
}