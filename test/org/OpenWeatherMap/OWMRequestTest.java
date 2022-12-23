package org.OpenWeatherMap;

import static org.junit.Assert.*;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.quasar.route.openWeatherMap.OWMRequest;

/**
 * 
 * @author Rúben Beirão
 * @author Fernando Brito e Abreu
 */
public class OWMRequestTest {

    OWMRequest owm;

    @Test
    public void testOWMRequest() {
        Assertions.assertTimeoutPreemptively(Duration.ofMillis(2000), () -> new OWMRequest("38.714466", "-9.140692"));
    }

    @Test
    public void testGetWeatherData() {
        OWMRequest owm = new OWMRequest("38.714466", "-9.140692");
        System.out.println(owm.getWeatherData());
    }

    @Test
    public void testGetUsefulPrecipitation() {
        OWMRequest owm = new OWMRequest("38.714466", "-9.140692");
        Calendar now = Calendar.getInstance();
        ArrayList<Double> precipitationArray = owm.getUsefulPrecipitation(now, 2);
        Assertions.assertTrue(precipitationArray.size() == 1);
        ArrayList<Double> precipitationArray2 = owm.getUsefulPrecipitation(now, 5);
        Assertions.assertTrue(precipitationArray2.size() == 2);
        ArrayList<Double> precipitationArray3 = owm.getUsefulPrecipitation(now, 8);
        Assertions.assertTrue(precipitationArray3.size() == 3);
    }

}
