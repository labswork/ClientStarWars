package app;

import com.mashape.unirest.http.exceptions.UnirestException;
import models.Arrays.Films;
import models.Arrays.People;
import models.Arrays.Planets;
import models.Arrays.SpeciesMap;
import models.Film;
import models.Human;
import models.Planet;
import models.Species;
import utils.BildModels;

public class MainClass {
    public static void main(String[] args) throws UnirestException {

        BildModels bildModels = new BildModels();
        People people = bildModels.bildPeople();
        Planets planets = bildModels.bildPlanets();
        Films films = bildModels.bildFilms();
        SpeciesMap speciesMap = bildModels.bildSpeciesMap();

        Human human = people.getPeople("http://swapi.co/api/people/88/");
        Planet planet = planets.getPlanet("http://swapi.co/api/planets/61/");
        Film film = films.getFilm("http://swapi.co/api/films/7/");
        Species species = speciesMap.getSpesies("http://swapi.co/api/species/37/");

        System.out.println(human.getName());
        System.out.println(planet.getName());
        System.out.println(film.getTitle());
        System.out.println(species.getName());




    }

}
