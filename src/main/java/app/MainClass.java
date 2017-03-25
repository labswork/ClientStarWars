package app;

import com.mashape.unirest.http.exceptions.UnirestException;
import models.*;
import utils.Client;

import java.util.Optional;

public class MainClass {
    public static void main(String[] args) throws UnirestException {



///*
        Client singleton = new Client();

        String namePeople = "luke skywalker";
        String namePlanet = "Alderaan";
        String titleFilm = "A New Hope";
        String nameSpecies = "Hutt";
        String nameVehicle = "Sand Crawler";
        String nameStarship = "Sentinel-class landing craft";


        Optional<People> peopleOptional = singleton.getPeopleByName(namePeople);
        Optional<Planet> planetOptional = singleton.getPlanetByName(namePlanet);
        Optional<Film> filmOptional = singleton.getFilmByTitle(titleFilm);
        Optional<Species> speciesOptional = singleton.getSpeciesByName(nameSpecies);
        Optional<Vehicle> vehicleOptional = singleton.getVehicleByName(nameVehicle);
        Optional<Starship> starshipOptional = singleton.getStarshipByName(nameStarship);

        peopleOptional.ifPresent(people -> System.out.println(people.getUrl()));
        planetOptional.ifPresent(planet -> System.out.println(planet.getUrl()));
        filmOptional.ifPresent(film -> System.out.println(film.getUrl()));
        speciesOptional.ifPresent(species -> System.out.println(species.getUrl()));
        vehicleOptional.ifPresent(vehicle -> System.out.println(vehicle.getUrl()));
        starshipOptional.ifPresent(starship -> System.out.println(starship.getUrl()));

        String string = "";

        peopleOptional = singleton.getPeopleByID(1);
        if (peopleOptional.isPresent()) {
            string = peopleOptional.get().getName();
            System.out.print(string);
            System.out.print(" соответвует ссылке: ");
            System.out.println(namePeople.equalsIgnoreCase(string));
        }

        planetOptional = singleton.getPlanetByID(2);
        if (planetOptional.isPresent()) {
            string = planetOptional.get().getName();
            System.out.print(string);
            System.out.print(" соответвует ссылке: ");
            System.out.println(namePlanet.equalsIgnoreCase(string));
        }

        filmOptional = singleton.getFilmByID(1);
        if (filmOptional.isPresent()) {
            string = filmOptional.get().getTitle();
            System.out.print(string);
            System.out.print(" соответвует ссылке: ");
            System.out.println(titleFilm.equalsIgnoreCase(string));
        }

        speciesOptional = singleton.getSpeciesByID(5);
        if (speciesOptional.isPresent()) {
            string = speciesOptional.get().getName();
            System.out.print(string);
            System.out.print(" соответвует ссылке: ");
            System.out.println(nameSpecies.equalsIgnoreCase(string));
        }

        vehicleOptional = singleton.getVehicleByID(4);
        if (vehicleOptional.isPresent()) {
            string = vehicleOptional.get().getName();
            System.out.print(string);
            System.out.print(" соответвует ссылке: ");
            System.out.println(nameVehicle.equalsIgnoreCase(string));
        }

        starshipOptional = singleton.getStarshipByID(5);
        if (starshipOptional.isPresent()) {
            string = starshipOptional.get().getName();
            System.out.print(string);
            System.out.print(" соответвует ссылке: ");
            System.out.println(nameStarship.equalsIgnoreCase(string));
        }

//*/


    }


}
