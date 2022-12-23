package org.quasar.route.graphhopper;

import com.graphhopper.reader.dem.SRTMProvider;

import java.util.Random;

public class TesteEle {

    static double LOW_LATI = 38.70553896015595;
    static double LOW_LONG = -9.14171437947861;
    static double MAX_LATI = 38.720038592448624;
    static double MAX_LONG = -9.1228316287680190;
    static Random rd = new Random();

    public static double randomLati(){
        return rd.nextFloat((float) (MAX_LATI - LOW_LATI)) + LOW_LATI;
    }

    public static double randomLongi(){
        return rd.nextFloat((float) (MAX_LONG - LOW_LONG)) + LOW_LONG;
    }

    public static void main(String[] args) {
        SRTMProvider provider = new SRTMProvider();

        long startTime = System.nanoTime();

        for (Integer i = 0; i <= 100000; i++){
            System.out.println(provider.getEle(randomLati(), randomLongi()));
        }

        long endTime = System.nanoTime();

        System.out.println("Duração: " +(endTime - startTime)/1000000 + " ms");
    }
}
