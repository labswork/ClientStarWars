package models.Arrays;

import models.Human;


import java.util.HashMap;
import java.util.Map;


/**
 * Created by rootid on 18.02.2017.
 */
public class People {
    private  Map<String, Human> peoples = new HashMap<String, Human>();

    public void addPeople(String url, Human human){
        peoples.put(url, human);
    }
    public Human getPeople(String url){
        return peoples.get(url);
    }

    public Map<String, Human> getPeoples() {
        return peoples;
    }

    public void getAllPeople(People people){
        peoples.putAll(people.getPeoples());
    }
}
