package app;

import com.mashape.unirest.http.exceptions.UnirestException;
import models.*;
import utils.BildModels;
import utils.Singleton;

import java.util.ArrayList;

public class MainClass {
    public static void main(String[] args) throws UnirestException {

        Singleton singleton = new Singleton();

        String name = "Luke Skywalker";
        String name1 = "luke skywalker";

        ArrayList<Human> people = singleton.getAllPeople();

        System.out.println(people.size());
        System.out.println(people.get(0).getName());
        System.out.println(people.get(79).getUrl());
//
        System.out.println(singleton.getHumanByID(1).getName());

        System.out.println(singleton.getHumanByName(name).getUrl());
        System.out.println(singleton.getHumanByName(name1).getUrl());


    }

}
