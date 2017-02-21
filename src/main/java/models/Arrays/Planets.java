package models.Arrays;

import models.Planet;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by rootid on 19.02.2017.
 */
public class Planets {
    private Map<String, Planet> planetMap = new HashMap<String, Planet>();

    public void addPlanet(String url, Planet planet){
        planetMap.put(url, planet);
    }
    public Planet getPlanet(String url) {
        return planetMap.get(url);
    }

    public Map<String, Planet> getPlanetMap() {
        return planetMap;
    }
    public void addAllPlanets(Planets planets){
        planetMap.putAll(planets.getPlanetMap());
    }
}
