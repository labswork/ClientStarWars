package app;

import com.google.gson.*;
import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.JsonNode;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;
import deserialize.PeopleDeserializer;
import models.Arrays.People;
import models.Human;
import utils.BildModels;

public class MainClass {
    public static void main(String[] args) throws UnirestException {

        BildModels bildModels = new BildModels();
        People people = bildModels.bildPeople();

        Human human = people.getPeople("http://swapi.co/api/people/88/");
        System.out.println(human.getName());




    }

}
