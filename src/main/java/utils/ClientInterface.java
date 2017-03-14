package utils;

import com.mashape.unirest.http.exceptions.UnirestException;
import models.*;

import java.util.List;
import java.util.Optional;

/**
 * Created by vgorokhov on 02.03.2017.
 */
public interface ClientInterface {
    People getHumanByName (String name);
    Optional<People> getHumanByID(int id) ;
    List<People> getAllPeople() ;

    Planet getPlanetByName(String name) ;
    Planet getPlanetByID(int id) ;
    List<Planet> getAllPlanets() ;

    Film getFilmByTitle(String title) ;
    Film getFilmByID(int id) ;
    List<Film> getAllFilms() ;

    Species getSpeciesByName(String name) ;
    Species getSpeciesByID(int id) ;
    List<Species> getAllSpecies() ;

    Vehicle getVehicleByName(String name) ;
    Vehicle getVehicleByID(int id) ;
    List<Vehicle> getAllVehicles() ;

    Starship getStarshipByName(String name) ;
    Starship getStarshipByID(int id) ;
    List<Starship> getAllStarships() ;


}
