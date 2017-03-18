package utils;

import com.mashape.unirest.http.exceptions.UnirestException;
import models.*;

import java.util.List;
import java.util.Optional;

/**
 * Created by vgorokhov on 02.03.2017.
 */
public interface ClientInterface {
    Optional<People> getHumanByName (String name);
    Optional<People> getHumanByID(int id) ;
    List<People> getAllPeople() ;

    Optional<Planet> getPlanetByName(String name) ;
    Optional<Planet> getPlanetByID(int id) ;
    List<Planet> getAllPlanets() ;

    Optional<Film> getFilmByTitle(String title) ;
    Optional<Film> getFilmByID(int id) ;
    List<Film> getAllFilms() ;

    Optional<Species> getSpeciesByName(String name) ;
    Optional<Species> getSpeciesByID(int id) ;
    List<Species> getAllSpecies() ;

    Optional<Vehicle> getVehicleByName(String name) ;
    Optional<Vehicle> getVehicleByID(int id) ;
    List<Vehicle> getAllVehicles() ;

    Optional<Starship> getStarshipByName(String name) ;
    Optional<Starship> getStarshipByID(int id) ;
    List<Starship> getAllStarships() ;


}
