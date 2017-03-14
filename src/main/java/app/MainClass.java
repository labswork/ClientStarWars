package app;

import com.mashape.unirest.http.exceptions.UnirestException;
import jdk.nashorn.internal.runtime.options.Option;
import models.*;
import utils.BildModels;
import utils.Singleton;

import java.util.ArrayList;
import java.util.Optional;

public class MainClass {
    public static void main(String[] args) throws UnirestException {


///*
        Singleton singleton = new Singleton();

        String namePeople = "luke skywalker";
        String namePlanet = "Alderaan";
        String titleFilm = "A New Hope";
        String nameSpecies = "Hutt";
        String nameVehicle = "Sand Crawler";
        String nameStarship = "Sentinel-class landing craft";

        System.out.println(singleton.getHumanByName(namePeople).getUrl());
        System.out.println(singleton.getPlanetByName(namePlanet).getUrl());
        System.out.println(singleton.getFilmByTitle(titleFilm).getUrl());
        System.out.println(singleton.getSpeciesByName(nameSpecies).getUrl());
        System.out.println(singleton.getVehicleByName(nameVehicle).getUrl());
        System.out.println(singleton.getStarshipByName(nameStarship).getUrl());


        String string = singleton.getHumanByID(1).get().getName();
        System.out.print(string);
        System.out.print(" соответвует ссылке: ");
        System.out.println(namePeople.equalsIgnoreCase(string));

        string = singleton.getPlanetByID(2).getName();
        System.out.print(string);
        System.out.print(" соответвует ссылке: ");
        System.out.println(namePlanet.equalsIgnoreCase(string));

        string = singleton.getFilmByID(1).getTitle();
        System.out.print(string);
        System.out.print(" соответвует ссылке: ");
        System.out.println(titleFilm.equalsIgnoreCase(string));

        string = singleton.getSpeciesByID(5).getName();
        System.out.print(string);
        System.out.print(" соответвует ссылке: ");
        System.out.println(nameSpecies.equalsIgnoreCase(string));

        string = singleton.getVehicleByID(4).getName();
        System.out.print(string);
        System.out.print(" соответвует ссылке: ");
        System.out.println(nameVehicle.equalsIgnoreCase(string));

        string = singleton.getStarshipByID(5).getName();
        System.out.print(string);
        System.out.print(" соответвует ссылке: ");
        System.out.println(nameStarship.equalsIgnoreCase(string));

//*/


    }


}
