package utils;

import com.google.gson.*;
import com.mashape.unirest.http.exceptions.UnirestException;
import deserialize.PeopleDeserializer;
import models.*;

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

        String responseJsonString = new String();
        responseJsonString = bildModels.requestJsonString(url);

        Gson gson = new Gson();

        return gson.fromJson(responseJsonString, Human.class);

    }

    public ArrayList<Human> getAllPeople() throws UnirestException {
        String url = this.swapiURL + "people/";
//        String url = "http://swapi.co/api/people/";
        BildModels bildModels = new BildModels();

        String responseJsonString = bildModels.requestJsonString(url);

        Gson gson = new GsonBuilder()
                .registerTypeAdapter(ArrayList.class, new PeopleDeserializer())
                .create();
        return gson.fromJson(responseJsonString, ArrayList.class);


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
