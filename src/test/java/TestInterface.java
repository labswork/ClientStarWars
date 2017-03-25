
import jdk.nashorn.internal.runtime.options.Option;
import models.*;
import org.testng.Assert;
import org.testng.annotations.Test;
import utils.Client;

import java.util.List;
import java.util.Optional;


public class TestInterface {
    @Test
    public void getPeopleByNameTest(){
        Client client = new Client();
        String name = "Luke Skywalker";
        Optional<People> peopleOptional = client.getPeopleByName(name);
        peopleOptional.ifPresent(people -> Assert.assertEquals(name, people.getName()));
    }
    @Test
    public void getPeopleByIDTest(){
        Client client = new Client();
        Integer id = 50;
        String url = "http://swapi.co/api/people/" + id.toString() + "/";
        Optional<People> peopleOptional = client.getPeopleByID(id);
        peopleOptional.ifPresent(people -> Assert.assertEquals(url, people.getUrl()));
    }
    @Test
    public void getAllPeopleTest(){
        Client client = new Client();
        List<People> people = client.getAllPeople();
        Assert.assertEquals(80, people.size());
    }

    @Test
    public void getPlanetByNameTest(){
        Client client = new Client();
        String name = "Alderaan";
        Optional<Planet> planetOptional = client.getPlanetByName(name);
        planetOptional.ifPresent(planet -> Assert.assertEquals(name, planet.getName()));
    }
    @Test
    public void getPlanetByIDTest() {
        Client client = new Client();
        Integer id = 30;
        String url = "http://swapi.co/api/planets/" + id.toString() + "/";
        Optional<Planet> planetOptional = client.getPlanetByID(id);
        planetOptional.ifPresent(planet -> Assert.assertEquals(url, planet.getUrl()));
    }
    @Test
    public void getAllPlanetsTest() {
        Client client = new Client();
        List<Planet> planets = client.getAllPlanets();
        Assert.assertEquals(60, planets.size());
    }

    @Test
    public void getFilmByTitleTest() {
        Client client = new Client();
        String title = "A New Hope";
        Optional<Film> filmOptional = client.getFilmByTitle(title);
        filmOptional.ifPresent(film -> Assert.assertEquals(title, film.getTitle()));
    }
    @Test
    public void getFilmByIDTest() {
        Client client = new Client();
        Integer id = 5;
        String url = "http://swapi.co/api/films/" + id.toString() + "/";
        Optional<Film> filmOptional = client.getFilmByID(id);
        filmOptional.ifPresent(film -> Assert.assertEquals(url, film.getUrl()));
    }
    @Test
    public void getAllFilmsTest() {
        Client client = new Client();
        List<Film> films = client.getAllFilms();
        Assert.assertEquals(7, films.size());
    }

    @Test
    public void getSpeciesByNameTest() {
        Client client = new Client();
        String name = "Hutt";
        Optional<Species> speciesOptional = client.getSpeciesByName(name);
        speciesOptional.ifPresent(species -> Assert.assertEquals(name, species.getName()));
    }
    @Test
    public void getSpeciesByIDTest() {
        Client client = new Client();
        Integer id = 20;
        String url = "http://swapi.co/api/species/" + id.toString() + "/";
        Optional<Species> speciesOptional = client.getSpeciesByID(id);
        speciesOptional.ifPresent(species -> Assert.assertEquals(url, species.getUrl()));
    }
    @Test
    public void getAllSpeciesTest() {
        Client client = new Client();
        List<Species> species = client.getAllSpecies();
        Assert.assertEquals(30, species.size());
    }

    @Test
    public void getVehicleByNameTest() {
        Client client = new Client();
        String name = "Sand Crawler";
        Optional<Vehicle> vehicleOptional = client.getVehicleByName(name);
        vehicleOptional.ifPresent(vehicle -> Assert.assertEquals(name, vehicle.getName()));
    }
    @Test
    public void getVehicleByIDTest() {
        Client client = new Client();
        Integer id = 25;
        String url = "http://swapi.co/api/vehicles/" + id.toString() + "/";
        Optional<Vehicle> vehicleOptional = client.getVehicleByID(id);
        vehicleOptional.ifPresent(vehicle -> Assert.assertEquals(url, vehicle.getUrl()));
    }
    @Test
    public void getAllVehiclesTest() {
        Client client = new Client();
        List<Vehicle> vehicles = client.getAllVehicles();
        Assert.assertEquals(30, vehicles.size());
    }

    @Test
    public void getStarshipByNameTest() {
        Client client = new Client();
        String name = "Sentinel-class landing craft";
        Optional<Starship> starshipOptional = client.getStarshipByName(name);
        starshipOptional.ifPresent(starship -> Assert.assertEquals(name, starship.getName()));
    }
    @Test
    public void getStarshipByIDTest() {
        Client client = new Client();
        Integer id = 22;
        String url = "http://swapi.co/api/starships/" + id.toString() + "/";
        Optional<Starship> starshipOptional = client.getStarshipByID(id);
        starshipOptional.ifPresent(starship -> Assert.assertEquals(url, starship.getUrl()));
    }
    @Test
    public void getAllStarshipsTest() {
        Client client = new Client();
        List<Starship> starships = client.getAllStarships();
        Assert.assertEquals(30, starships.size());
    }
}
