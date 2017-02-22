package deserialize;

import com.google.gson.*;
import models.Arrays.Films;
import models.Film;

import java.lang.reflect.Type;

/**
 * Created by rootid on 19.02.2017.
 */
public class FilmsDeserializer implements JsonDeserializer<Films> {

    public Films deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context){
        Films films = new Films();

        JsonObject jsonObject = json.getAsJsonObject();
        JsonArray jsonArray = jsonObject.getAsJsonArray("results");

        for (int i = 0; i < jsonArray.size(); i++) {
            Film film = context.deserialize(jsonArray.get(i), Film.class);
            String url = film.getUrl();
            films.addFilm(url, film);
        }
        return films;
    }
}
//github commit
