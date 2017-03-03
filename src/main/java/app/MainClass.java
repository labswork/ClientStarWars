package app;

import com.mashape.unirest.http.exceptions.UnirestException;
import models.*;
import models.Arrays.*;
import utils.BildModels;
import utils.Singleton;

public class MainClass {
    public static void main(String[] args) throws UnirestException {

        Singleton singleton = new Singleton();

        System.out.println(singleton.getAllPeople().size());
        System.out.println(singleton.getAllPeople().get(0));

        System.out.println(singleton.getHumanByID(1).getName());





//        BildModels bildModels = new BildModels();
//        People people = bildModels.bildPeople();
//        Planets planets = bildModels.bildPlanets();
//        Films films = bildModels.bildFilms();
//        SpeciesMap speciesMap = bildModels.bildSpeciesMap();
//        VehiclesMap vehiclesMap = bildModels.bildVehiclesMap();
//        StarshipsMap starshipsMap = bildModels.bildStarshipsMap();
//
//        Human human = people.getPeople("http://swapi.co/api/people/8/");
//        Planet planet = planets.getPlanet("http://swapi.co/api/planets/6/");
//        Film film = films.getFilm("http://swapi.co/api/films/4/");
//        Species species = speciesMap.getSpesies("http://swapi.co/api/species/7/");
//        Vehicle vehicle = vehiclesMap.getVehicle("http://swapi.co/api/vehicles/4/");
//        Starship starship = starshipsMap.getStarship("http://swapi.co/api/starships/5/");
//
//        System.out.println(human.getName());
//        System.out.println(planet.getName());
//        System.out.println(film.getTitle());
//        System.out.println(species.getName());
//        System.out.println(vehicle.getName());
//        System.out.println(starship.getName());
//
//        //new branch




    }

}
