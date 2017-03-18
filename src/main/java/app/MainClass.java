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


        System.out.println(singleton.getPeopleByName(namePeople).get().getUrl());
        System.out.println(singleton.getPlanetByName(namePlanet).get().getUrl());
        System.out.println(singleton.getFilmByTitle(titleFilm).get().getUrl());
        System.out.println(singleton.getSpeciesByName(nameSpecies).get().getUrl());
        System.out.println(singleton.getVehicleByName(nameVehicle).get().getUrl());
        System.out.println(singleton.getStarshipByName(nameStarship).get().getUrl());

        String string = "";

        Optional<People> peopleOptional = singleton.getPeopleByID(1);
        if (peopleOptional.isPresent()) {
            string = peopleOptional.get().getName();
            System.out.print(string);
            System.out.print(" соответвует ссылке: ");
            System.out.println(namePeople.equalsIgnoreCase(string));
        }

        string = singleton.getPlanetByID(2).get().getName();
        System.out.print(string);
        System.out.print(" соответвует ссылке: ");
        System.out.println(namePlanet.equalsIgnoreCase(string));

        string = singleton.getFilmByID(1).get().getTitle();
        System.out.print(string);
        System.out.print(" соответвует ссылке: ");
        System.out.println(titleFilm.equalsIgnoreCase(string));

        string = singleton.getSpeciesByID(5).get().getName();
        System.out.print(string);
        System.out.print(" соответвует ссылке: ");
        System.out.println(nameSpecies.equalsIgnoreCase(string));

        string = singleton.getVehicleByID(4).get().getName();
        System.out.print(string);
        System.out.print(" соответвует ссылке: ");
        System.out.println(nameVehicle.equalsIgnoreCase(string));

        string = singleton.getStarshipByID(5).get().getName();
        System.out.print(string);
        System.out.print(" соответвует ссылке: ");
        System.out.println(nameStarship.equalsIgnoreCase(string));

//*/


    }


}
