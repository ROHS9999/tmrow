package org.quasar.route.request;

import java.sql.Timestamp;
import java.util.LinkedList;

import org.json.JSONArray;
import org.json.JSONObject;

import com.graphhopper.util.shapes.GHPoint;

/**
 * This class parses a RouteRequest in JSON format into a RouteRequest object
 * 
 * @author Rúben Beirão
 * @author Fernando Brito e Abreu
 */

public class ConvertRouteRequest {

    private RouteRequest routeRequest;

    /**
     * Creates a RouteRequest object from a JSON representation of that route
     * request
     * 
     * @param jsonRouteRequest A String representing the JSON format of user route
     *                         request
     */
    public ConvertRouteRequest(String jsonRouteRequest) {
	parseRouteRequest(jsonRouteRequest);
    }

    private void parseRouteRequest(String jsonRouteRequest) {
	JSONObject obj = new JSONObject(jsonRouteRequest);
//		String IMEI = obj.getString("IMEI");
//		System.out.println("IMEI is: " + IMEI);

	JSONObject originInJson = obj.getJSONObject("origin");
	double originLatitude = originInJson.getDouble("latitude");
	double originLongitude = originInJson.getDouble("longitude");
	GHPoint origin = new GHPoint(originLatitude, originLongitude);
	System.out.println("Origin latitude is: " + origin.getLat());
	System.out.println("Origin longitude is: " + origin.getLon());

	JSONObject destinationInJson = obj.getJSONObject("destination");
	double destinationLatitude = destinationInJson.getDouble("latitude");
	double destinationLongitude = destinationInJson.getDouble("longitude");
	GHPoint destination = new GHPoint(destinationLatitude, destinationLongitude);
	System.out.println("Destination latitude is: " + destination.getLat());
	System.out.println("Destination longitude is: " + destination.getLon());

	Long departureDateInJson = obj.getLong("departureDate");
	Timestamp departureDate = new Timestamp(departureDateInJson);
	System.out.println("Departure date is " + departureDate);

	int visitationTime = obj.getInt("visitationTime");
	System.out.println("Visitation time is " + visitationTime);

//		JSONObject availableTimeInJson = obj.getJSONObject("availableTime");
//		Long startTime = availableTimeInJson.getLong("startTime");
//		Timestamp start = new Timestamp(startTime);
//		Long endTime = availableTimeInJson.getLong("endTime");
//		Timestamp end = new Timestamp(endTime);
//		TimeInterval availableTime = new TimeInterval(start, end);
//		System.out.println("AvailableTime start time is: " + availableTime.getStartTime().getTime());
//		System.out.println("AvailableTime end time is: " + availableTime.getEndTime().getTime());

	int effortLevel = obj.getInt("effortLevel");
	System.out.println("Effort level is " + effortLevel);

	int budget = obj.getInt("budget");
	System.out.println("Budget is " + budget);

	LinkedList<Integer> selectedPoints = new LinkedList<Integer>();
	JSONArray arrayOfPois = obj.getJSONArray("selectedPoints");

	if (arrayOfPois != null) {
	    for (int i = 0; i < arrayOfPois.length(); i++) {
		selectedPoints.add(arrayOfPois.getInt(i));
		System.out.println("The point " + arrayOfPois.getInt(i) + " was added");
	    }
	}

	LinkedList<String> selectedCategories = new LinkedList<String>();
	JSONArray arrayOfCategories = obj.getJSONArray("selectedCategories");

	if (arrayOfCategories != null) {
	    for (int i = 0; i < arrayOfCategories.length(); i++) {
			System.out.println(arrayOfCategories);
			selectedCategories.add(arrayOfCategories.getString(i));
			System.out.println("The category " + arrayOfCategories.getString(i) + " was added");

	    }
	}

	boolean checkWeather = obj.getBoolean("checkWeather");
	System.out.println("Check Weather is " + checkWeather);

	routeRequest = new RouteRequest(origin, destination, departureDate, visitationTime, effortLevel, budget,
		selectedPoints, selectedCategories, checkWeather);
    }

    /**
     * Gets the Route Request that is created
     * 
     * @return A Route Request object from the JSON representation
     */
    public RouteRequest getRouteRequest() {
	return routeRequest;
    }

}
