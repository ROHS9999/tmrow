package org.request;

import static org.junit.Assert.*;
import static org.junit.Assert.assertEquals;

import java.sql.Timestamp;
import java.util.*;

import org.junit.Test;
import org.quasar.route.basicParametrization.TimeInterval;
import org.quasar.route.request.RouteRequest;

import com.graphhopper.util.shapes.GHPoint;

/**
 * 
 * @author Rúben Beirão
 * @author Fernando Brito e Abreu
 */
public class RouteRequestTest {
	
	String IMEI = "865885043764230"; // user single identification
	
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
	ArrayList<Double> usefulWeatherData; // the weather data (probability of precipitation) for the next 10 hours
	Calendar calendar = Calendar.getInstance(); // register the moment of the request

//	public RouteRequest(GHPoint origin, GHPoint destination, Timestamp departureDate, int visitationTime, int effortLevel,
//		int budget, LinkedList<Integer> selectedPoints, List<Integer> selectedCategories, boolean checkWeather) 	

//	RouteRequest routeRequest = new RouteRequest(IMEI, origin, destination, availableTime, effortLevel,
//			budget, selectedPoints, selectedCategories, checkWeather);

	RouteRequest routeRequest = new RouteRequest(origin, destination, startTime, availableTime.timeDifferenceInHours(), effortLevel,
		budget, selectedPoints, selectedCategories, checkWeather);

	@Test
	public void testGetIMEI() {
		String IMEI = "865885043764230";
		assertEquals(IMEI, routeRequest.getIMEI());
	}

	@Test
	public void testSetIMEI() {
		routeRequest.setIMEI("409441609320896");
		assertEquals("409441609320896", routeRequest.getIMEI());
	}
	
	@Test
	public void testGetOrigin() {
		GHPoint origin = new GHPoint(38.714466, -9.140692);
		assertEquals(origin, routeRequest.getOrigin());
	}

	@Test
	public void testSetOrigin() {
		routeRequest.setOrigin(new GHPoint(38.7139092, -9.1334762));
		assertEquals(new GHPoint(38.7139092, -9.1334762), routeRequest.getOrigin());
	}
	
	@Test
	public void testGetDestination() {
		GHPoint destination = new GHPoint(38.710516, -9.136196);
		assertEquals(destination, routeRequest.getDestination());
	}

	@Test
	public void testSetDestination() {
		routeRequest.setDestination(new GHPoint(38.714041, -9.138340));
		assertEquals(new GHPoint(38.714041, -9.138340), routeRequest.getDestination());
	}
	
	@Test
	public void testGetAvailableTime() {
		TimeInterval availableTime = new TimeInterval(startTime, endTime);
		assertEquals(availableTime, routeRequest.getAvailableTime());
	}

	@Test
	public void testSetAvailableTime() {
		routeRequest.setAvailableTime(new TimeInterval(startTime, endTime));
		assertEquals(new TimeInterval(startTime, endTime), routeRequest.getAvailableTime());
	}
	
	@Test
	public void testGetEffortLevel() {
		int effortLevel = 1;
		assertEquals(effortLevel, routeRequest.getEffortLevel());
	}

	@Test
	public void testSetEffortLevel() {
		routeRequest.setEffortLevel(2);
		assertEquals(2, routeRequest.getEffortLevel());
	}
	
	@Test
	public void testGetBudget() {
		int budget = 100;
		assertEquals(budget, routeRequest.getBudget());
	}

	@Test
	public void testSetBudget() {
		routeRequest.setBudget(50);
		assertEquals(50, routeRequest.getBudget());
	}
	
	@Test
	public void testGetSelectedPoints() {
		assertEquals(selectedPoints, routeRequest.getSelectedPoints());
	}

	@Test
	public void testSetSelectedPoints() {
		LinkedList<Integer> selectedPOIs = new LinkedList<>();
		selectedPOIs.add(1); // Castelo S. Jorge
		selectedPOIs.add(30); // Museu Arqueol�gico do Carmo
		routeRequest.setSelectedPoints(selectedPOIs);
		assertEquals(selectedPOIs, routeRequest.getSelectedPoints());
	}

	@Test
	public void testGetSelectedCategories() {
		assertEquals(selectedCategories, routeRequest.getSelectedCategories());
	}

	@Test
	public void testGetCalendar() {
		calendar.setTime(startTime);
		assertEquals(calendar, routeRequest.getCalendar());
	}

	@Test
	public void testIsCheckWeather() {
		assertFalse(routeRequest.isCheckWeather());
	}

	@Test
	public void testSetCheckWeather() {
		routeRequest.setCheckWeather(true);
		assertTrue(routeRequest.isCheckWeather());
	}
	
	@Test
	public void testGetUsefulWeatherData() {
		fail("Not yet implemented");
	}

}
