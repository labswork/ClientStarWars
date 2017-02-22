package deserialize;

import com.google.gson.*;
import models.Arrays.People;
import models.Human;

import java.lang.reflect.Type;
import java.util.Map;

/**
 * Created by rootid on 18.02.2017.
 */
public class PeopleDeserializer implements JsonDeserializer<People> {
//    @Override
    public People deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) throws JsonParseException{
        People people = new People();

        JsonObject jsonObject = json.getAsJsonObject();
        JsonArray jsonArray = jsonObject.getAsJsonArray("results");

        for (int i = 0; i < jsonArray.size(); i++) {

            Human human = context.deserialize(jsonArray.get(i), Human.class);
            String url = human.getUrl();
            people.addPeople(url, human);
        }
        return people;

    }
}
//github commit
