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

class RouteResponseTest {

    PointOfInterest poi = new PointOfInterest(1, "Castelo", 38.8736, -9.3463653, 50, 9, 18, 3, 5, 7, 70);
    PointOfInterest poi2 = new PointOfInterest(1, "Pra�a", 38.3567, -9.456799, 80, 9, 18, 3, 5, 7, 70);

    TimedPointOfInterest timedpoi1 = new TimedPointOfInterest(poi, Timestamp.valueOf("2020-10-03 14:50:10.0"));
    TimedPointOfInterest timedpoi2 = new TimedPointOfInterest(poi2, Timestamp.valueOf("2020-10-03 17:08:10.0"));
    LinkedList<TimedPointOfInterest> timedPOIs = new LinkedList<TimedPointOfInterest>(Arrays.asList(timedpoi1, timedpoi2));

    GHPoint3D point1 = new GHPoint3D(38.9887765, -9.23434546, 31.0);
    GHPoint3D point2 = new GHPoint3D(38.3455475, -9.87676599, 31.0);
    GHPoint3D point3 = new GHPoint3D(38.8756757, -9.45678900, 31.0);
    ArrayList<GHPoint3D> line = new ArrayList<GHPoint3D>(Arrays.asList(point1, point2, point3));

    int time = 8000;
    double distance = 3000; // distance in meters
    double sustainability = 55.5;
    int price = 30;;
    GHPoint origin = new GHPoint(38.714466, -9.140692);
    GHPoint destination = new GHPoint(38.714466, -9.140692);
    Timestamp startTime = Timestamp.valueOf("2020-10-03 14:30:10.0");
    int calories = 989;
    Timestamp endTime = Timestamp.valueOf("2020-10-03 19:10:10.0");

//		String IMEI = "865885043764230";

    Route route = new Route(timedPOIs, line, time, distance, (int) sustainability, price, origin, destination,
            startTime, endTime, calories);

    int statusCode = 200;

    String codeJustification = "Success";

    RouteResponse routeResponse = new RouteResponse(route, statusCode, codeJustification);

    @Test
    void getStatusCode() {
        assertEquals(statusCode, routeResponse.getStatusCode());
    }

    @Test
    void setStatusCode() {
        routeResponse.setStatusCode(500);
        assertEquals(500, routeResponse.getStatusCode());
    }

    @Test
    void getCodeJustification() {
        assertEquals("Success", routeResponse.getCodeJustification());
    }

    @Test
    void setCodeJustification() {
        routeResponse.setCodeJustification("Error");
        assertEquals("Error", routeResponse.getCodeJustification());
    }

    @Test
    void setRoute() {
        Route route2 = new Route(timedPOIs, line, time, distance, (int) sustainability, price, origin, destination,
                startTime, endTime, 100);
        routeResponse.setRoute(route2);
        assertEquals(route2, routeResponse.getRoute());
    }

    @Test
    void getRoute() {
        assertEquals(route, routeResponse.getRoute());
    }

    @Test
    void convertToJson() {
        routeResponse.convertToJson(routeResponse);
    }

    @Test
    void testToString() {
        assertEquals("RouteResponse [route=org.quasar.route.response.Route@7ff95560, statusCode=200, codeJustification=Success]",
                routeResponse.toString());
    }
}