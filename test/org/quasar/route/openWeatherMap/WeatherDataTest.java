package org.quasar.route.openWeatherMap;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;

class WeatherDataTest {

    WeatherData weatherData = new WeatherData(25.1, 2.0, "2022-05-09 17:00:00");

    @Test
    void getTemperature() {
        Assertions.assertEquals(25.1, weatherData.getTemperature(), 0);
    }

    @Test
    void getPrecipitation() {
        Assertions.assertEquals(2.0, weatherData.getPrecipitation(), 0);
    }

    @Test
    void getDate() {
        Assertions.assertEquals("2022-05-09 17:00:00", weatherData.getDate());
    }

    @Test
    void convertStringToDate() throws ParseException {
        Date date = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse("2022-05-09 17:00:00");
        Assertions.assertTrue(Math.abs(date.getTime() - weatherData.convertStringToDate("2022-05-09 17:00:00").getTime()) < 1000);
    }

    @Test
    void testToString() {
        Assertions.assertEquals("WeatherData [temperature=25.1, precipitation=2.0, date=2022-05-09 17:00:00]", weatherData.toString());
    }
}