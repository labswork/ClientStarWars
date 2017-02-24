package deserialize;

import com.google.gson.*;
import models.Arrays.StarshipsMap;
import models.Starship;

import java.lang.reflect.Type;

/**
 * Created by rootid on 24.02.2017.
 */
public class StarshipsDeserializer implements JsonDeserializer<StarshipsMap> {
    public StarshipsMap deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context){
        StarshipsMap starshipsMap = new StarshipsMap();
        JsonObject jsonObject = json.getAsJsonObject();
        JsonArray jsonArray = jsonObject.getAsJsonArray("results");

        for (int i = 0; i < jsonArray.size(); i++) {
            Starship starship = context.deserialize(jsonArray.get(i), Starship.class);
            String url = starship.getUrl();
            starshipsMap.addStarships(url, starship);
        }
        return starshipsMap;
    }
}
