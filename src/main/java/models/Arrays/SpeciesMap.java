package models.Arrays;

import models.Species;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by vgorokhov on 20.02.2017.
 */
public class SpeciesMap {
    private Map<String, Species> speciesMap = new HashMap<String, Species>();

    public void addSpecies(String url, Species species){
        speciesMap.put(url, species);
    }
    public Species getSpesies(String url){
        return speciesMap.get(url);
    }

    public Map<String, Species> getSpeciesMap() {
        return speciesMap;
    }
}
