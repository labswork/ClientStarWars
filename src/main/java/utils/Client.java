package utils;

import com.google.gson.*;
import com.mashape.unirest.http.exceptions.UnirestException;
import models.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * Created by vgorokhov on 02.03.2017.
 */
public class Client implements ClientInterface {

    private String swapiURL = "http://swapi.co/api/";


    private <T> List<T> getOnePage(String responseJsonString, T t)  {

        List<T> listItems = new ArrayList<>();
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


    public Optional<People> getPeopleByName(String name){
        List<People> people = getAllPeople();
        return people.stream().filter((people1 -> people1.getName().equalsIgnoreCase(name))).findFirst();
    }

    public Optional<People> getPeopleByID(int id){

        String url = this.swapiURL + "people/" + Integer.toString(id) + "/";
        People people = null;
        try {
            String responseJsonString = BuildModels.requestJsonString(url);
            Gson gson = new Gson();
            people = gson.fromJson(responseJsonString, People.class);
        } catch (UnirestException e) {
            e.printStackTrace();
        }
        return Optional.ofNullable(people);
    }

    public List<People> getAllPeople()  {
        String url = this.swapiURL + "people/";
        List<People> people = new ArrayList<>();
        People onePeople = new People();

        String responseJsonString = null;
        try {
            responseJsonString = BuildModels.requestJsonString(url);
        } catch (UnirestException e) {
            e.printStackTrace();
        }

        boolean FirstStart = true;
        while ((!BuildModels.itLastPage(responseJsonString)) || FirstStart){
            FirstStart = false;
            if (!BuildModels.itLastPage(responseJsonString)) url = BuildModels.getNextPageLink(responseJsonString);
            people.addAll(getOnePage(responseJsonString, onePeople));
            try {
                responseJsonString = BuildModels.requestJsonString(url);
            } catch (UnirestException e) {
                e.printStackTrace();
            }

        }
        return people;
    }







    public Optional<Planet> getPlanetByName(String name)  {
        List<Planet> planets = getAllPlanets();
        return planets.stream().filter(planet -> planet.getName().equalsIgnoreCase(name)).findFirst();
    }

    public Optional<Planet> getPlanetByID(int id)  {
        String url = this.swapiURL + "planets/" + Integer.toString(id) + "/";
        

        Planet planet = null;
        try {
            String responseJsonString = BuildModels.requestJsonString(url);
            Gson gson = new Gson();
            planet = gson.fromJson(responseJsonString, Planet.class);

        } catch (UnirestException e) {
            e.printStackTrace();
        }
        return Optional.ofNullable(planet);
    }

    public List<Planet> getAllPlanets()  {
        String url = this.swapiURL + "planets/";

        List<Planet> planets = new ArrayList<>();
        Planet planet = new Planet();
        

        String responseJsonString = null;
        try {
            responseJsonString = BuildModels.requestJsonString(url);
        } catch (UnirestException e) {
            e.printStackTrace();
        }

        boolean FirstStart = true;
        while ((!BuildModels.itLastPage(responseJsonString)) || FirstStart){
            FirstStart = false;
            if (!BuildModels.itLastPage(responseJsonString)) url = BuildModels.getNextPageLink(responseJsonString);
            planets.addAll(getOnePage(responseJsonString, planet));
            try {
                responseJsonString = BuildModels.requestJsonString(url);
            } catch (UnirestException e) {
                e.printStackTrace();
            }
        }
        return planets;
    }





    public Optional<Film> getFilmByTitle(String title)  {
        List<Film> films = getAllFilms();
        return films.stream().filter(film -> film.getTitle().equalsIgnoreCase(title)).findFirst();
    }

    public Optional<Film> getFilmByID(int id)  {
        String url = this.swapiURL + "films/" + Integer.toString(id) + "/";
        

        Film film = null;
        try {
            String responseJsonString = BuildModels.requestJsonString(url);
            Gson gson = new Gson();
             film = gson.fromJson(responseJsonString, Film.class);

        } catch (UnirestException e) {
            e.printStackTrace();
        }
        return Optional.ofNullable(film);
    }


    public List<Film> getAllFilms()  {
        String url = this.swapiURL + "films/";

        List<Film> films = new ArrayList<>();
        Film film = new Film();
        

        String responseJsonString = null;
        try {
            responseJsonString = BuildModels.requestJsonString(url);
        } catch (UnirestException e) {
            e.printStackTrace();
        }

        boolean FirstStart = true;
        while ((!BuildModels.itLastPage(responseJsonString)) || FirstStart){
            FirstStart = false;
            if (!BuildModels.itLastPage(responseJsonString)) url = BuildModels.getNextPageLink(responseJsonString);
            films.addAll(getOnePage(responseJsonString, film));
            try {
                responseJsonString = BuildModels.requestJsonString(url);
            } catch (UnirestException e) {
                e.printStackTrace();
            }
        }
        return films;
    }





    public Optional<Species> getSpeciesByName(String name)  {
        List<Species> species = getAllSpecies();
        return species.stream().filter(species1 -> species1.getName().equalsIgnoreCase(name)).findFirst();
    }

    public Optional<Species> getSpeciesByID(int id)  {
        String url = this.swapiURL + "species/" + Integer.toString(id) + "/";
        

        Species species = null;
        try {
            String responseJsonString = BuildModels.requestJsonString(url);
            Gson gson = new Gson();
            species = gson.fromJson(responseJsonString, Species.class);
        } catch (UnirestException e) {
            e.printStackTrace();
        }
        return Optional.ofNullable(species);
    }



    public List<Species> getAllSpecies()  {
        String url = this.swapiURL + "species/";

        List<Species> species = new ArrayList<>();
        Species oneSpecies = new Species();
        

        String responseJsonString = null;
        try {
            responseJsonString = BuildModels.requestJsonString(url);
        } catch (UnirestException e) {
            e.printStackTrace();
        }

        boolean FirstStart = true;
        while ((!BuildModels.itLastPage(responseJsonString)) || FirstStart){
            FirstStart = false;
            if (!BuildModels.itLastPage(responseJsonString)) url = BuildModels.getNextPageLink(responseJsonString);
            species.addAll(getOnePage(responseJsonString, oneSpecies));
            try {
                responseJsonString = BuildModels.requestJsonString(url);
            } catch (UnirestException e) {
                e.printStackTrace();
            }
        }
        return species;
    }





    public Optional<Vehicle> getVehicleByName(String name)  {
        List<Vehicle> vehicles = getAllVehicles();
        return vehicles.stream().filter(vehicle -> vehicle.getName().equalsIgnoreCase(name)).findFirst();
    }

    public Optional<Vehicle> getVehicleByID(int id)  {
        String url = this.swapiURL + "vehicles/" + Integer.toString(id) + "/";
        

        Vehicle vehicle = null;
        try {
            String responseJsonString = BuildModels.requestJsonString(url);
            Gson gson = new Gson();
            vehicle = gson.fromJson(responseJsonString, Vehicle.class);
        } catch (UnirestException e) {
            e.printStackTrace();
        }
        return Optional.ofNullable(vehicle);
    }

    public List<Vehicle> getAllVehicles()  {
        String url = this.swapiURL + "vehicles/";

        List<Vehicle> vehicles = new ArrayList<>();
        Vehicle oneVehicle = new Vehicle();
        


        String responseJsonString = null;
        try {
            responseJsonString = BuildModels.requestJsonString(url);
        } catch (UnirestException e) {
            e.printStackTrace();
        }


        boolean FirstStart = true;
        while ((!BuildModels.itLastPage(responseJsonString)) || FirstStart){
            FirstStart = false;
            if (!BuildModels.itLastPage(responseJsonString)) url = BuildModels.getNextPageLink(responseJsonString);
            vehicles.addAll(getOnePage(responseJsonString, oneVehicle));
            try {
                responseJsonString = BuildModels.requestJsonString(url);
            } catch (UnirestException e) {
                e.printStackTrace();
            }
        }

        return vehicles;
    }





    public Optional<Starship> getStarshipByName(String name)  {
        List<Starship> starships = getAllStarships();
        return starships.stream().filter(starship -> starship.getName().equalsIgnoreCase(name)).findFirst();
    }

    public Optional<Starship> getStarshipByID(int id)  {
        String url = this.swapiURL + "starships/" + Integer.toString(id) + "/";
        

        Starship starship = null;
        try {
            String responseJsonString = BuildModels.requestJsonString(url);
            Gson gson = new Gson();
            starship = gson.fromJson(responseJsonString, Starship.class);
        } catch (UnirestException e) {
            e.printStackTrace();
        }
        return Optional.ofNullable(starship);
    }

    public List<Starship> getAllStarships()  {
        String url = this.swapiURL + "starships/";

        List<Starship> starships = new ArrayList<>();
        Starship oneStarship = new Starship();

        String responseJsonString = null;
        try {
            responseJsonString = BuildModels.requestJsonString(url);
        } catch (UnirestException e) {
            e.printStackTrace();
        }

        boolean FirstStart = true;
        while ((!BuildModels.itLastPage(responseJsonString)) || FirstStart){
            FirstStart = false;
            if (!BuildModels.itLastPage(responseJsonString)) url = BuildModels.getNextPageLink(responseJsonString);
            starships.addAll(getOnePage(responseJsonString, oneStarship));
            try {
                responseJsonString = BuildModels.requestJsonString(url);
            } catch (UnirestException e) {
                e.printStackTrace();
            }
        }
        return starships;
    }
}
