package utils;

import models.*;

import java.util.List;
import java.util.Optional;


public interface ClientInterface {
    Optional<People> getPeopleByName (String name);
    Optional<People> getPeopleByID(int id) ;
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
