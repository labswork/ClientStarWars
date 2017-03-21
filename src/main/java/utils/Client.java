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
public class Client implements ClientInterface {

    private String swapiURL = "http://swapi.co/api/";


    private <T> List<T> getOnePage(String responseJsonString, Type t)  {

        List<T> listItems = new ArrayList<>();
        Gson gson = new Gson();

        JsonParser jsonParser = new JsonParser();
        JsonObject o = (JsonObject) jsonParser.parse(responseJsonString);
        JsonArray jArray = o.getAsJsonArray("results");

        for (int i = 0; i < jArray.size(); i++) {
            T item = (T) gson.fromJson(jArray.get(i), t);
            listItems.add(item);
        }
        return listItems;
    }

    private <T> List<T> getAllPage(String url, Type t){
        boolean FirstStart = true;
        List<T> list = new ArrayList<T>();

        String responseJsonString = null;
        try {
            responseJsonString = BuildModels.requestJsonString(url);
        } catch (UnirestException e) {
            e.printStackTrace();
        }

        while ((!BuildModels.itLastPage(responseJsonString)) || FirstStart){
            FirstStart = false;
            if (!BuildModels.itLastPage(responseJsonString))  url = BuildModels.getNextPageLink(responseJsonString);
            list.addAll(getOnePage(responseJsonString, t));
            try {
                responseJsonString = BuildModels.requestJsonString(url);
            } catch (UnirestException e) {
                e.printStackTrace();
            }
        }
        return list;
    }

    private <T> Optional<T> getByUrl(String url, Type t){
        T item = null;
        try {
            String responseJsonString = BuildModels.requestJsonString(url);
            Gson gson = new Gson();
             item = gson.fromJson(responseJsonString, t);
        } catch (UnirestException e) {
            e.printStackTrace();
        }
        return Optional.ofNullable(item);
    }

    public Optional<People> getPeopleByName(String name){
        List<People> people = getAllPeople();
        return people.stream().filter((people1 -> people1.getName().equalsIgnoreCase(name))).findFirst();
    }

    public Optional<People> getPeopleByID(int id){
        String url = this.swapiURL + "people/" + Integer.toString(id) + "/";
        return this.getByUrl(url, People.class);
    }

    public List<People> getAllPeople()  {
        String url = this.swapiURL + "people/";
        return this.getAllPage(url, People.class);
    }

    public Optional<Planet> getPlanetByName(String name)  {
        List<Planet> planets = getAllPlanets();
        return planets.stream().filter(planet -> planet.getName().equalsIgnoreCase(name)).findFirst();
    }

    public Optional<Planet> getPlanetByID(int id)  {
        String url = this.swapiURL + "planets/" + Integer.toString(id) + "/";
        return this.getByUrl(url, Planet.class);
    }

    public List<Planet> getAllPlanets()  {
        String url = this.swapiURL + "planets/";
        return this.getAllPage(url, Planet.class);
    }

    public Optional<Film> getFilmByTitle(String title)  {
        List<Film> films = getAllFilms();
        return films.stream().filter(film -> film.getTitle().equalsIgnoreCase(title)).findFirst();
    }

    public Optional<Film> getFilmByID(int id)  {
        String url = this.swapiURL + "films/" + Integer.toString(id) + "/";
        return this.getByUrl(url, Film.class);
    }

    public List<Film> getAllFilms()  {
        String url = this.swapiURL + "films/";
        return this.getAllPage(url, Film.class);
    }

    public Optional<Species> getSpeciesByName(String name)  {
        List<Species> species = getAllSpecies();
        return species.stream().filter(species1 -> species1.getName().equalsIgnoreCase(name)).findFirst();
    }

    public Optional<Species> getSpeciesByID(int id)  {
        String url = this.swapiURL + "species/" + Integer.toString(id) + "/";
        return this.getByUrl(url, Species.class);
    }

    public List<Species> getAllSpecies()  {
        String url = this.swapiURL + "species/";
        return this.getAllPage(url, Species.class);
    }

    public Optional<Vehicle> getVehicleByName(String name)  {
        List<Vehicle> vehicles = getAllVehicles();
        return vehicles.stream().filter(vehicle -> vehicle.getName().equalsIgnoreCase(name)).findFirst();
    }

    public Optional<Vehicle> getVehicleByID(int id)  {
        String url = this.swapiURL + "vehicles/" + Integer.toString(id) + "/";
        return this.getByUrl(url, Vehicle.class);
    }

    public List<Vehicle> getAllVehicles()  {
        String url = this.swapiURL + "vehicles/";
        return this.getAllPage(url, Vehicle.class);
    }

    public Optional<Starship> getStarshipByName(String name)  {
        List<Starship> starships = getAllStarships();
        return starships.stream().filter(starship -> starship.getName().equalsIgnoreCase(name)).findFirst();
    }

    public Optional<Starship> getStarshipByID(int id)  {
        String url = this.swapiURL + "starships/" + Integer.toString(id) + "/";
        return this.getByUrl(url, Starship.class);
    }

    public List<Starship> getAllStarships()  {
        String url = this.swapiURL + "starships/";
        return this.getAllPage(url, Starship.class);
    }
}
