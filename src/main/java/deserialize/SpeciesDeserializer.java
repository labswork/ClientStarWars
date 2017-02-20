package deserialize;

import com.google.gson.*;
import models.Arrays.SpeciesMap;
import models.Species;
import java.lang.reflect.Type;

/**
 * Created by vgorokhov on 20.02.2017.
 */
public class SpeciesDeserializer implements JsonDeserializer<SpeciesMap> {
    public SpeciesMap deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context){
        SpeciesMap speciesMap = new SpeciesMap();
        JsonObject jsonObject = json.getAsJsonObject();
        JsonArray jsonArray = jsonObject.getAsJsonArray("results");

        for (int i = 0; i < jsonArray.size(); i++) {
            Species species = context.deserialize(jsonArray.get(i), Species.class);
            String url = species.getUrl();
            speciesMap.addSpecies(url, species);
        }
        return speciesMap;
    }
}
