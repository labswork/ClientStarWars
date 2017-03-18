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






    public Optional<People> getHumanByName(String name){
        ArrayList<People> people = getAllPeople();
        return people.stream().filter((people1 -> people1.getName().equalsIgnoreCase(name))).findFirst();
    }

    public Optional<People> getHumanByID(int id){

        String url = this.swapiURL + "people/" + Integer.toString(id) + "/";
        BildModels bildModels = new BildModels();

        People people = null;
        try {
            String responseJsonString = bildModels.requestJsonString(url);
            Gson gson = new Gson();
            people = gson.fromJson(responseJsonString, People.class);
        } catch (UnirestException e) {
            e.printStackTrace();
        }
        return Optional.ofNullable(people);
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







    public Optional<Planet> getPlanetByName(String name)  {
        ArrayList<Planet> planets = getAllPlanets();
        return planets.stream().filter(planet -> planet.getName().equalsIgnoreCase(name)).findFirst();
    }

    public Optional<Planet> getPlanetByID(int id)  {
        String url = this.swapiURL + "planets/" + Integer.toString(id) + "/";
        BildModels bildModels = new BildModels();

        Planet planet = null;
        try {
            String responseJsonString = bildModels.requestJsonString(url);
            Gson gson = new Gson();
            planet = gson.fromJson(responseJsonString, Planet.class);

        } catch (UnirestException e) {
            e.printStackTrace();
        }
        return Optional.ofNullable(planet);
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





    public Optional<Film> getFilmByTitle(String title)  {
        ArrayList<Film> films = getAllFilms();
        return films.stream().filter(film -> film.getTitle().equalsIgnoreCase(title)).findFirst();
    }

    public Optional<Film> getFilmByID(int id)  {
        String url = this.swapiURL + "films/" + Integer.toString(id) + "/";
        BildModels bildModels = new BildModels();

        Film film = null;
        try {
            String responseJsonString = bildModels.requestJsonString(url);
            Gson gson = new Gson();
             film = gson.fromJson(responseJsonString, Film.class);

        } catch (UnirestException e) {
            e.printStackTrace();
        }
        return Optional.ofNullable(film);
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





    public Optional<Species> getSpeciesByName(String name)  {
        ArrayList<Species> species = getAllSpecies();
        return species.stream().filter(species1 -> species1.getName().equalsIgnoreCase(name)).findFirst();
    }

    public Optional<Species> getSpeciesByID(int id)  {
        String url = this.swapiURL + "species/" + Integer.toString(id) + "/";
        BildModels bildModels = new BildModels();

        Species species = null;
        try {
            String responseJsonString = bildModels.requestJsonString(url);
            Gson gson = new Gson();
            species = gson.fromJson(responseJsonString, Species.class);
        } catch (UnirestException e) {
            e.printStackTrace();
        }
        return Optional.ofNullable(species);
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





    public Optional<Vehicle> getVehicleByName(String name)  {
        ArrayList<Vehicle> vehicles = getAllVehicles();
        return vehicles.stream().filter(vehicle -> vehicle.getName().equalsIgnoreCase(name)).findFirst();
    }

    public Optional<Vehicle> getVehicleByID(int id)  {
        String url = this.swapiURL + "vehicles/" + Integer.toString(id) + "/";
        BildModels bildModels = new BildModels();

        Vehicle vehicle = null;
        try {
            String responseJsonString = bildModels.requestJsonString(url);
            Gson gson = new Gson();
            vehicle = gson.fromJson(responseJsonString, Vehicle.class);
        } catch (UnirestException e) {
            e.printStackTrace();
        }
        return Optional.ofNullable(vehicle);
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





    public Optional<Starship> getStarshipByName(String name)  {
        ArrayList<Starship> starships = getAllStarships();
        return starships.stream().filter(starship -> starship.getName().equalsIgnoreCase(name)).findFirst();
    }

    public Optional<Starship> getStarshipByID(int id)  {
        String url = this.swapiURL + "starships/" + Integer.toString(id) + "/";
        BildModels bildModels = new BildModels();

        Starship starship = null;
        try {
            String responseJsonString = bildModels.requestJsonString(url);
            Gson gson = new Gson();
            starship = gson.fromJson(responseJsonString, Starship.class);
        } catch (UnirestException e) {
            e.printStackTrace();
        }
        return Optional.ofNullable(starship);
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
