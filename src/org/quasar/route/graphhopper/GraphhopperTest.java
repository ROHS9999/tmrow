package org.quasar.route.graphhopper;

import com.graphhopper.GHRequest;
import com.graphhopper.GHResponse;
import com.graphhopper.GraphHopper;
import com.graphhopper.ResponsePath;
import com.graphhopper.config.CHProfile;
import com.graphhopper.config.Profile;

public class GraphhopperTest {
    private static final String ALGORITHM = "alternative_route";
    private static final String VEHICLE = "foot";
    private static final String WEIGHTING = "short_fastest";

    private static final String OSM_FILE = "C:\\Users\\danif\\Desktop\\Pasta\\Faculdade\\Mestrado\\Tese\\PreventCrowding-server-master\\resources\\CentralLisbon.osm.pbf";
    private static final String GRAPHHOPPER_DIR = "src/main/resources/graphhopperv2";


    public static void main(String[] args) {
        GraphHopper hopper = new GraphHopper().
                setGraphHopperLocation(GRAPHHOPPER_DIR).
                setOSMFile(OSM_FILE).
                setProfiles(new Profile("profile").setVehicle(VEHICLE).setWeighting(WEIGHTING)).
                setStoreOnFlush(true);
        hopper.getCHPreparationHandler()
                .setCHProfiles(new CHProfile("profile"));
        hopper.setElevation(true);
        hopper.importOrLoad();
        GHRequest req = new GHRequest(38.7144118, -9.1408772, 38.7115605, -9.1367243)
                .setAlgorithm(ALGORITHM)
                .setProfile("profile");
        GHResponse rsp = hopper.route(req);
        System.out.println(rsp.getHints().getLong("visited_nodes.sum", 0));

        ResponsePath res = rsp.getBest();
        System.out.println(res.getPoints());
    }
}
