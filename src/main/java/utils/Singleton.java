package utils;

import com.google.gson.*;
import com.mashape.unirest.http.exceptions.UnirestException;
import models.*;

import java.lang.reflect.Type;
import java.util.ArrayList;

/**
 * Created by vgorokhov on 02.03.2017.
 */
public class Singleton implements ClientInterface {

    private String swapiURL = "http://swapi.co/api/";


    public Human getHumanByName(String name) throws UnirestException {
        return null;
    }

    public Human getHumanByID(int id) throws UnirestException {
//        String url = this.swapiURL + "people/" + Integer.toString(id) + "/";
        String url = "http://swapi.co/api/people/1/";
        BildModels bildModels = new BildModels();

        String responseJsonString = bildModels.requestJsonString(url);

        Gson gson = new Gson();

        return gson.fromJson(responseJsonString, Human.class);

    }

    public ArrayList<Human> getAllPeople() throws UnirestException {

        String url = this.swapiURL + "people/";

        ArrayList<Human> people = new ArrayList<Human>();
        BildModels bildModels = new BildModels();
        Gson gson = new Gson();

        String next = url;
        String responseJsonString = bildModels.requestJsonString(url);

        while (bildModels.itLastPage(responseJsonString) == false){
            Human human = new Human();
            next = bildModels.getNextPageLink(responseJsonString);
            people.addAll(getOnePage(responseJsonString, Human.class, human));
            responseJsonString = bildModels.requestJsonString(next);

        }

//        JsonParser jsonParser = new JsonParser();
//        JsonObject o = (JsonObject) jsonParser.parse(responseJsonString);
//        JsonArray jArray = o.getAsJsonArray("results");
//
//        for (int i = 0; i < jArray.size(); i++) {
//            Human human = gson.fromJson(jArray.get(i), Human.class);
//            people.add(human);
//
//        }
        return people;
    }

    public ArrayList getOnePage(String responseJsonString, Type typeOfT, Object item ) throws UnirestException {
        ArrayList listItems = new ArrayList();
        Gson gson = new Gson();

        JsonParser jsonParser = new JsonParser();
        JsonObject o = (JsonObject) jsonParser.parse(responseJsonString);
        JsonArray jArray = o.getAsJsonArray("results");

        for (int i = 0; i < jArray.size(); i++) {
            item = gson.fromJson(jArray.get(i), typeOfT);
            listItems.add(item);

        }
        return listItems;
    }





    public Planet getPlanetByName(String name) throws UnirestException {
        return null;
    }

    public Planet getPlanetByID(int id) throws UnirestException {
        return null;
    }

    public ArrayList<Planet> getAllPlanets() throws UnirestException {
        return null;
    }

    public Film getFilmByName(String title) throws UnirestException {
        return null;
    }

    public Film getFilmByID(int id) throws UnirestException {
        return null;
    }

    public ArrayList<Film> getAllFilms() throws UnirestException {
        return null;
    }

    public Species getSpeciesByName(String name) throws UnirestException {
        return null;
    }

    public Species getSpeciesByID(int id) throws UnirestException {
        return null;
    }

    public ArrayList<Species> getAllSpecies() throws UnirestException {
        return null;
    }

    public Vehicle getVehicleByName(String name) throws UnirestException {
        return null;
    }

    public Vehicle getVehicleByID(int id) throws UnirestException {
        return null;
    }

    public ArrayList<Vehicle> getAllVehicles() throws UnirestException {
        return null;
    }

    public Starship getStarshipByName(String name) throws UnirestException {
        return null;
    }

    public Starship getStarshipByID(int id) throws UnirestException {
        return null;
    }

    public ArrayList<Starship> getAllStarships() throws UnirestException {
        return null;
    }
}
