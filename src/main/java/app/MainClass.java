package app;

import com.mashape.unirest.http.exceptions.UnirestException;
import models.Arrays.People;
import models.Arrays.Planets;
import models.Human;
import models.Planet;
import utils.BildModels;

public class MainClass {
    public static void main(String[] args) throws UnirestException {

        BildModels bildModels = new BildModels();
        People people = bildModels.bildPeople();
        Planets planets = bildModels.bildPlanets();

        Human human = people.getPeople("http://swapi.co/api/people/88/");
        Planet planet = planets.getPlanet("http://swapi.co/api/planets/61/");
        System.out.println(human.getName());
        System.out.println(planet.getName());




    }

}
