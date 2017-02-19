package utils;

import com.google.gson.*;
import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.JsonNode;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;
import deserialize.PeopleDeserializer;
import deserialize.PlanetsDeserializer;
import models.Arrays.People;
import models.Arrays.Planets;
import models.Planet;

/**
 * Created by rootid on 19.02.2017.
 */
public class BildModels {

    public String requestJsonString(String url) throws UnirestException{
        HttpResponse<JsonNode> jsonResponse = Unirest.get(url)
                .asJson();
        System.out.print("body: ");
        System.out.println(jsonResponse.getBody());
        return jsonResponse.getBody().toString();
    }
    public boolean itLastPage(String jsonString){
        JsonObject jsonObjectParse = getJsonObjectParse(jsonString);
        if (jsonObjectParse.get("next").isJsonNull()){
            return true;
        }
        return false;
    }
    public String getNextPageLink(String jsonString){
        JsonObject jsonObjectParse = getJsonObjectParse(jsonString);
        return jsonObjectParse.get("next").getAsString();
    }
    public JsonObject getJsonObjectParse(String jsonString){
        JsonElement jsonElementParse = new JsonParser().parse(jsonString);
        return jsonElementParse.getAsJsonObject();
    }




    public People bildPeople() throws UnirestException{
        String url = "http://swapi.co/api/people/";
        String next = "First Start";
        People people = new People();

        while (next != "") {
            String responseJsonString = requestJsonString(url);

            if (itLastPage(responseJsonString)){
                next = "";
            }
            else {
                next = getNextPageLink(responseJsonString);
                url = next;
            }

            Gson gson = new GsonBuilder()
                    .registerTypeAdapter(People.class, new PeopleDeserializer())
                    .create();
            people = gson.fromJson(responseJsonString, People.class);
        }
        return people;
    }

    public Planets bildPlanets() throws UnirestException{
        Planets planets = new Planets();
        String next = "First Start";
        String url = "http://swapi.co/api/planets/";

        while (next != ""){
            String responseJsonString = requestJsonString(url);
            if (itLastPage(responseJsonString)){
                next = "";
            }
            else {
                next = getNextPageLink(responseJsonString);
                url = next;
            }

            Gson gson = new GsonBuilder()
                    .registerTypeAdapter(Planets.class, new PlanetsDeserializer())
                    .create();
            planets = gson.fromJson(responseJsonString, Planets.class);
        }
        return planets;
    }

}
