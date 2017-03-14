package utils;

import com.google.gson.*;
import com.mashape.unirest.http.exceptions.UnirestException;
import models.*;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * Created by vgorokhov on 02.03.2017.
 */
public class Singleton implements ClientInterface {

    private String swapiURL = "http://swapi.co/api/";




    public <T> List<T> getOnePage(String responseJsonString, T t)  {

        ArrayList<T> listItems = new ArrayList<T>();
        Gson gson = new Gson();

        JsonParser jsonParser = new JsonParser();
        JsonObject o = (JsonObject) jsonParser.parse(responseJsonString);
        JsonArray jArray = o.getAsJsonArray("results");

        for (int i = 0; i < jArray.size(); i++) {
            T item = (T) gson.fromJson(jArray.get(i), t.getClass());
            listItems.add(item);
        }
        return listItems;
    }






    public People getHumanByName(String name){
        ArrayList<People> people = getAllPeople();
        for (int i = 0; i < people.size(); i++) {
            if (people.get(i).getName().equalsIgnoreCase(name)){
                return people.get(i);
            }
        }
        return null;
    }

    public Optional<People> getHumanByID(int id){

        String url = this.swapiURL + "people/" + Integer.toString(id) + "/";
        BildModels bildModels = new BildModels();

        try {
            String responseJsonString;
            responseJsonString = bildModels.requestJsonString(url);
            Gson gson = new Gson();
            People people = gson.fromJson(responseJsonString, People.class);

            return Optional.of(people);
        } catch (UnirestException e) {
            e.printStackTrace();
            return Optional.empty();
        }
    }

    public ArrayList<People> getAllPeople()  {

        String url = this.swapiURL + "people/";

        ArrayList<People> people = new ArrayList<People>();
        People human = new People();
        BildModels bildModels = new BildModels();

        String responseJsonString = null;
        try {
            responseJsonString = bildModels.requestJsonString(url);
        } catch (UnirestException e) {
            e.printStackTrace();
        }

        boolean FirstStart = true;
        while ((!bildModels.itLastPage(responseJsonString)) || FirstStart){
            FirstStart = false;
            if (!bildModels.itLastPage(responseJsonString)) url = bildModels.getNextPageLink(responseJsonString);
            people.addAll(getOnePage(responseJsonString, human));
            try {
                responseJsonString = bildModels.requestJsonString(url);
            } catch (UnirestException e) {
                e.printStackTrace();
            }

        }
        return people;
    }







    public Planet getPlanetByName(String name)  {
        ArrayList<Planet> planets = getAllPlanets();
        for (int i = 0; i < planets.size(); i++) {
            if (planets.get(i).getName().equalsIgnoreCase(name)){
                return planets.get(i);
            }
        }
        return null;
    }

    public Planet getPlanetByID(int id)  {
        String url = this.swapiURL + "planets/" + Integer.toString(id) + "/";
        BildModels bildModels = new BildModels();

        String responseJsonString = null;
        try {
            responseJsonString = bildModels.requestJsonString(url);
        } catch (UnirestException e) {
            e.printStackTrace();
        }

        Gson gson = new Gson();

        return gson.fromJson(responseJsonString, Planet.class);
    }

    public ArrayList<Planet> getAllPlanets()  {
        String url = this.swapiURL + "planets/";

        ArrayList<Planet> planets = new ArrayList<Planet>();
        Planet planet = new Planet();
        BildModels bildModels = new BildModels();

        String responseJsonString = null;
        try {
            responseJsonString = bildModels.requestJsonString(url);
        } catch (UnirestException e) {
            e.printStackTrace();
        }

        boolean FirstStart = true;
        while ((!bildModels.itLastPage(responseJsonString)) || FirstStart){
            FirstStart = false;
            if (!bildModels.itLastPage(responseJsonString)) url = bildModels.getNextPageLink(responseJsonString);
            planets.addAll(getOnePage(responseJsonString, planet));
            try {
                responseJsonString = bildModels.requestJsonString(url);
            } catch (UnirestException e) {
                e.printStackTrace();
            }
        }
        return planets;
    }





    public Film getFilmByTitle(String title)  {
        ArrayList<Film> films = getAllFilms();
        for (int i = 0; i < films.size(); i++) {
            if (films.get(i).getTitle().equalsIgnoreCase(title)){
                return films.get(i);
            }
        }
        return null;
    }

    public Film getFilmByID(int id)  {
        String url = this.swapiURL + "films/" + Integer.toString(id) + "/";
        BildModels bildModels = new BildModels();

        String responseJsonString = null;
        try {
            responseJsonString = bildModels.requestJsonString(url);
        } catch (UnirestException e) {
            e.printStackTrace();
        }

        Gson gson = new Gson();

        return gson.fromJson(responseJsonString, Film.class);

    }

    public ArrayList<Film> getAllFilms()  {
        String url = this.swapiURL + "films/";

        ArrayList<Film> films = new ArrayList<Film>();
        Film film = new Film();
        BildModels bildModels = new BildModels();

        String responseJsonString = null;
        try {
            responseJsonString = bildModels.requestJsonString(url);
        } catch (UnirestException e) {
            e.printStackTrace();
        }

        boolean FirstStart = true;
        while ((!bildModels.itLastPage(responseJsonString)) || FirstStart){
            FirstStart = false;
            if (!bildModels.itLastPage(responseJsonString)) url = bildModels.getNextPageLink(responseJsonString);
            films.addAll(getOnePage(responseJsonString, film));
            try {
                responseJsonString = bildModels.requestJsonString(url);
            } catch (UnirestException e) {
                e.printStackTrace();
            }
        }
        return films;
    }





    public Species getSpeciesByName(String name)  {
        ArrayList<Species> species = getAllSpecies();
        for (int i = 0; i < species.size(); i++) {
            if (species.get(i).getName().equalsIgnoreCase(name)){
                return species.get(i);
            }
        }
        return null;
    }

    public Species getSpeciesByID(int id)  {
        String url = this.swapiURL + "species/" + Integer.toString(id) + "/";
        BildModels bildModels = new BildModels();

        String responseJsonString = null;
        try {
            responseJsonString = bildModels.requestJsonString(url);
        } catch (UnirestException e) {
            e.printStackTrace();
        }

        Gson gson = new Gson();

        return gson.fromJson(responseJsonString, Species.class);
    }

    public ArrayList<Species> getAllSpecies()  {
        String url = this.swapiURL + "species/";

        ArrayList<Species> species = new ArrayList<Species>();
        Species oneSpecies = new Species();
        BildModels bildModels = new BildModels();

        String responseJsonString = null;
        try {
            responseJsonString = bildModels.requestJsonString(url);
        } catch (UnirestException e) {
            e.printStackTrace();
        }

        boolean FirstStart = true;
        while ((!bildModels.itLastPage(responseJsonString)) || FirstStart){
            FirstStart = false;
            if (!bildModels.itLastPage(responseJsonString)) url = bildModels.getNextPageLink(responseJsonString);
            species.addAll(getOnePage(responseJsonString, oneSpecies));
            try {
                responseJsonString = bildModels.requestJsonString(url);
            } catch (UnirestException e) {
                e.printStackTrace();
            }
        }
        return species;
    }





    public Vehicle getVehicleByName(String name)  {
        ArrayList<Vehicle> vehicles = getAllVehicles();
        for (int i = 0; i < vehicles.size(); i++) {
            if (vehicles.get(i).getName().equalsIgnoreCase(name)){
                return vehicles.get(i);
            }
        }
        return null;
    }

    public Vehicle getVehicleByID(int id)  {
        String url = this.swapiURL + "vehicles/" + Integer.toString(id) + "/";
        BildModels bildModels = new BildModels();

        String responseJsonString = null;
        try {
            responseJsonString = bildModels.requestJsonString(url);
        } catch (UnirestException e) {
            e.printStackTrace();
        }

        Gson gson = new Gson();

        return gson.fromJson(responseJsonString, Vehicle.class);
    }

    public ArrayList<Vehicle> getAllVehicles()  {
        String url = this.swapiURL + "vehicles/";

        ArrayList<Vehicle> vehicles = new ArrayList<Vehicle>();
        Vehicle oneVehicle = new Vehicle();
        BildModels bildModels = new BildModels();


        String responseJsonString = null;
        try {
            responseJsonString = bildModels.requestJsonString(url);
        } catch (UnirestException e) {
            e.printStackTrace();
        }


        boolean FirstStart = true;
        while ((!bildModels.itLastPage(responseJsonString)) || FirstStart){
            FirstStart = false;
            if (!bildModels.itLastPage(responseJsonString)) url = bildModels.getNextPageLink(responseJsonString);
            vehicles.addAll(getOnePage(responseJsonString, oneVehicle));
            try {
                responseJsonString = bildModels.requestJsonString(url);
            } catch (UnirestException e) {
                e.printStackTrace();
            }
        }

        return vehicles;
    }





    public Starship getStarshipByName(String name)  {
        ArrayList<Starship> starships = getAllStarships();
        for (int i = 0; i < starships.size(); i++) {
            if (starships.get(i).getName().equalsIgnoreCase(name)){
                return starships.get(i);
            }
        }
        return null;
    }

    public Starship getStarshipByID(int id)  {
        String url = this.swapiURL + "starships/" + Integer.toString(id) + "/";
        BildModels bildModels = new BildModels();

        String responseJsonString = null;
        try {
            responseJsonString = bildModels.requestJsonString(url);
        } catch (UnirestException e) {
            e.printStackTrace();
        }

        Gson gson = new Gson();

        return gson.fromJson(responseJsonString, Starship.class);
    }

    public ArrayList<Starship> getAllStarships()  {
        String url = this.swapiURL + "starships/";

        ArrayList<Starship> starships = new ArrayList<Starship>();
        Starship oneStarship = new Starship();
        BildModels bildModels = new BildModels();

        String responseJsonString = null;
        try {
            responseJsonString = bildModels.requestJsonString(url);
        } catch (UnirestException e) {
            e.printStackTrace();
        }

        boolean FirstStart = true;
        while ((!bildModels.itLastPage(responseJsonString)) || FirstStart){
            FirstStart = false;
            if (!bildModels.itLastPage(responseJsonString)) url = bildModels.getNextPageLink(responseJsonString);
            starships.addAll(getOnePage(responseJsonString, oneStarship));
            try {
                responseJsonString = bildModels.requestJsonString(url);
            } catch (UnirestException e) {
                e.printStackTrace();
            }
        }
        return starships;
    }
}
