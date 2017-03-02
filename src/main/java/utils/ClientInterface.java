package utils;

import models.*;

import java.util.ArrayList;

/**
 * Created by vgorokhov on 02.03.2017.
 */
public interface ClientInterface {
    Human getHumanByName(String name);
    Human getHumanByLink(String url);
    ArrayList<String> getAllPeople();

    Planet getPlanetByName(String name);
    Planet getPlanetByLink(String url);
    ArrayList<String> getAllPlanets();

    Film getFilmByName(String title);
    Film getFilmByLink(String url);
    ArrayList<String> getAllFilms();

    Species getSpeciesByName(String name);
    Species getSpeciesByLink(String url);
    ArrayList<String> getAllSpecies();

    Vehicle getVehicleByName(String name);
    Vehicle getVehicleByLink(String url);
    ArrayList<String> getAllVehicles();

    Starship getStarshipByName(String name);
    Starship getStarshipByLink(String url);
    ArrayList<String> getAllStarships();




}
