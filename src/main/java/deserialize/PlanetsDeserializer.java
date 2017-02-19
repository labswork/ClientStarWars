package deserialize;

import com.google.gson.*;
import models.Arrays.Planets;
import models.Planet;

import java.lang.reflect.Type;

/**
 * Created by rootid on 19.02.2017.
 */
public class PlanetsDeserializer implements JsonDeserializer<Planet> {
    @Override
    public Planets deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) throws JsonParseException {
        Planets planets = new Planets();

        JsonObject jsonObject = json.getAsJsonObject();
        JsonArray jsonArray = jsonObject.getAsJsonArray("results");

        for (int i = 0; i < jsonArray.size(); i++) {
            Planet planet = context.deserialize(jsonArray.get(i), Planet.class);
            String url = planet.getUrl();
            planets.addPlanet(url, planet);
        }
        return planets;
    }
}
