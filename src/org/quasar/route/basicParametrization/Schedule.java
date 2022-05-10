package org.quasar.route.basicParametrization;

import java.util.ArrayList;

/**
 * Represents the opening schedule (and admission cost) of a Point Of Interest
 * 
 * @author Rúben Beirão
 * @author Fernando Brito e Abreu
 *
 */
public class Schedule {

    private double openHour;
    private double closeHour;
    private ArrayList<Days> day;
    private double price;

    enum Days {
	Monday, Tuesday, Wednesday, Thursday, Friday, Saturday, Sunday
    }

    public Schedule(double openHour, double closeHour, ArrayList<Days> day, double price) {
	this.openHour = openHour;
	this.closeHour = closeHour;
	this.day = day;
	this.price = price;
    }

    public double getOpenHour() {
	return openHour;
    }

    public void setOpenHour(double openHour) {
	this.openHour = openHour;
    }

    public double getCloseHour() {
	return closeHour;
    }

    public void setCloseHour(double closeHour) {
	this.closeHour = closeHour;
    }

    public ArrayList<Days> getDay() {
	return day;
    }

    public void setDay(ArrayList<Days> day) {
	this.day = day;
    }

    public double getPrice() {
	return price;
    }

    public void setPrice(double price) {
	this.price = price;
    }
}
