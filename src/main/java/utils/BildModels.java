package utils;

import com.google.gson.*;
import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.JsonNode;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;
import deserialize.PeopleDeserializer;
import models.Arrays.People;

/**
 * Created by rootid on 19.02.2017.
 */
public class BildModels {


    public People bildPeople() throws UnirestException {
        String url = "http://swapi.co/api/people/";
        String next = "First Start";
        People people = new People();

        while (next != "") {
            HttpResponse<JsonNode> jsonResponse = Unirest.get(url)
                    .asJson();
            System.out.print("body: ");
            System.out.println(jsonResponse.getBody());
            String responseJsonString = jsonResponse.getBody().toString();

            JsonElement jsonElementParse = new JsonParser().parse(responseJsonString);
            JsonObject jsonObjectParse = jsonElementParse.getAsJsonObject();


            if (jsonObjectParse.get("next").isJsonNull()){
                next = "";
            }
            else {
                next = jsonObjectParse.get("next").getAsString();
                url = next;
            }


            Gson gson = new GsonBuilder()
                    .registerTypeAdapter(People.class, new PeopleDeserializer())
                    .create();
            people = gson.fromJson(responseJsonString, People.class);
        }
        return people;
    }

}
