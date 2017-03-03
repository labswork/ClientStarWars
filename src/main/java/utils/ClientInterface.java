package utils;

import com.mashape.unirest.http.exceptions.UnirestException;
import models.*;

import java.util.List;

/**
 * Created by vgorokhov on 02.03.2017.
 */
public interface ClientInterface {
    Human getHumanByName (String name) throws UnirestException;
    Human getHumanByID(int id) throws UnirestException;
    List<Human> getAllPeople() throws UnirestException;

    Planet getPlanetByName(String name) throws UnirestException;
    Planet getPlanetByID(int id) throws UnirestException;
    List<Planet> getAllPlanets() throws UnirestException;

    Film getFilmByName(String title) throws UnirestException;
    Film getFilmByID(int id) throws UnirestException;
    List<Film> getAllFilms() throws UnirestException;

    Species getSpeciesByName(String name) throws UnirestException;
    Species getSpeciesByID(int id) throws UnirestException;
    List<Species> getAllSpecies() throws UnirestException;

    Vehicle getVehicleByName(String name) throws UnirestException;
    Vehicle getVehicleByID(int id) throws UnirestException;
    List<Vehicle> getAllVehicles() throws UnirestException;

    Starship getStarshipByName(String name) throws UnirestException;
    Starship getStarshipByID(int id) throws UnirestException;
    List<Starship> getAllStarships() throws UnirestException;




}
