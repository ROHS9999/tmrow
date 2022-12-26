package org.quasar.route.graphhopper;

import com.influxdb.client.InfluxDBClient;
import com.influxdb.client.InfluxDBClientFactory;
import com.influxdb.client.QueryApi;
import com.influxdb.query.FluxRecord;
import com.influxdb.query.FluxTable;

import javax.management.Query;
import java.util.ArrayList;
import java.util.List;

/**
 * MongoConnection is a class that allows to connect to InfluxDB database and
 * extract the data provided about the crowding levels
 *
 * @author Daniel Brás
 * @author Fernando Brito e Abreu
 *
 */
public class InfluxConnection {

    private InfluxDBClient influxClient;
    private QueryApi queryApi;
    private final String url = "http://194.210.120.12:8086";
    private final String token = "fOvi_ZCQznho-EriiE1_d5kwhy6FtVKGjBhxg0UttXcyqHft7xR6J2Q056X2XJT1IwFwcbxUFRrIwQylHQ0hVw==";
    private final String org = "ISCTE";
    private final String bucket = "VodafoneLxData";

    public InfluxConnection(){
        influxClient = InfluxDBClientFactory.create(url, token.toCharArray(), org, bucket);
        queryApi = influxClient.getQueryApi();
    }

    public InfluxDBClient getInfluxClient(){
        return influxClient;
    }

    public int queryCrowdingFromGrid(long departureTime, int grid){

        int maxCrowding = 0;

        //System.out.println(departureTime);
        String flux = "from(bucket: \"VodafoneLxData\")\n" +
                "  |> range(start: " + departureTime + ", stop: 1652967900)\n" +
                "  |> filter(fn: (r) => r[\"_measurement\"] == \"" + grid + "\")\n" +
                "  |> filter(fn: (r) => r[\"_field\"] == \"C1\")";

        List<FluxTable> tables = queryApi.query(flux, "ISCTE");

        for (FluxTable fluxTable : tables) {
            List<FluxRecord> records = fluxTable.getRecords();
            for (FluxRecord fluxRecord : records) {
                double crowdingDouble = (double) fluxRecord.getValueByKey("_value");
                int crowding = (int) crowdingDouble;
                //System.out.println(crowding);

                if (crowding > maxCrowding)
                    maxCrowding = crowding;
            }
        }
        //System.out.println(flux);
        //System.out.println(maxCrowding);

        return maxCrowding;
    }

    public static void main(String[] args) {
        InfluxConnection influx = new InfluxConnection();
        influx.queryCrowdingFromGrid(1652967000, 513);
    }
}
