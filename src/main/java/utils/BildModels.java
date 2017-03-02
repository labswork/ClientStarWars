package utils;

import com.google.gson.*;
import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.JsonNode;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;
import deserialize.*;
import models.Arrays.*;
import models.Film;
import models.Planet;

/**
 * Created by rootid on 19.02.2017.
 */
public class BildModels {
    private People people = new People();
    private Planets planets = new Planets();
    private Films films = new Films();
    private SpeciesMap speciesMap = new SpeciesMap();
    private VehiclesMap vehiclesMap = new VehiclesMap();
    private StarshipsMap starshipsMap = new StarshipsMap();







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
            this.people.addAllPeople(people);
        }
        return this.people;
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
            this.planets.addAllPlanets(planets);
        }
        return this.planets;
    }

    public Films bildFilms() throws UnirestException{
        Films films = new Films();
        String next = "First Start";
        String url = "http://swapi.co/api/films/";

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
                    .registerTypeAdapter(Films.class, new FilmsDeserializer())
                    .create();
            films = gson.fromJson(responseJsonString, Films.class);
            this.films.addAllFilms(films);
        }
        return this.films;
    }

    public SpeciesMap bildSpeciesMap() throws UnirestException{
        SpeciesMap speciesMap = new SpeciesMap();
        String next = "First Start";
        String url = "http://swapi.co/api/species/";

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
                    .registerTypeAdapter(SpeciesMap.class, new SpeciesDeserializer())
                    .create();
            speciesMap = gson.fromJson(responseJsonString, SpeciesMap.class);
            this.speciesMap.addAllSpecies(speciesMap);
        }
        return this.speciesMap;
    }

    public VehiclesMap bildVehiclesMap() throws UnirestException{
        VehiclesMap vehiclesMap = new VehiclesMap();
        String next = "First Start";
        String url = "http://swapi.co/api/vehicles/";

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
                    .registerTypeAdapter(VehiclesMap.class, new VehiclesDeserializer())
                    .create();
            vehiclesMap = gson.fromJson(responseJsonString, VehiclesMap.class);
            this.vehiclesMap.addAllVehicles(vehiclesMap);
        }
        return this.vehiclesMap;
    }

    public StarshipsMap bildStarshipsMap() throws UnirestException{
        StarshipsMap starshipsMap = new StarshipsMap();
        String next = "First Start";
        String url = "http://swapi.co/api/starships/";

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
                    .registerTypeAdapter(StarshipsMap.class, new StarshipsDeserializer())
                    .create();
            starshipsMap = gson.fromJson(responseJsonString, StarshipsMap.class);
            this.starshipsMap.addAllStarships(starshipsMap);
        }
        return this.starshipsMap;
    }

}
