package models.Arrays;

import models.Starship;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by rootid on 24.02.2017.
 */
public class StarshipsMap {
    private Map<String, Starship> starshipMap = new HashMap<String, Starship>();

    public Map<String, Starship> getStarshipMap() {
        return starshipMap;
    }
    public void addStarships(String url, Starship starship){
        starshipMap.put(url, starship);
    }
    public Starship getStarship(String url){
        return starshipMap.get(url);
    }
    public void addAllStarships(StarshipsMap starshipsMap){
        this.starshipMap.putAll(starshipsMap.getStarshipMap());
    }
}
