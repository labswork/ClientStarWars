package models;


import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by rootid on 13.02.2017.
 */
public class Human{

    private String name;
    private String height;
    private String mass;
    private String hair_color;
    private String skin_color;
    private String eye_color;
    private String birth_year;
    private String gender;
    private String homeworld;

    private ArrayList<String> films;
    private ArrayList<String> species;
    private ArrayList<String> vehicles;
    private ArrayList<String> starships;

    private String url;

    public Human() {

    }


    public String getName() {
        return name;
    }

    public String getHeight() {
        return height;
    }

    public String getMass() {
        return mass;
    }

    public String getHair_color() {
        return hair_color;
    }

    public String getSkin_color() {
        return skin_color;
    }

    public String getEye_color() {
        return eye_color;
    }

    public String getBirth_year() {
        return birth_year;
    }

    public String getGender() {
        return gender;
    }

    public String getHomeworld() {
        return homeworld;
    }

    public ArrayList<String> getFilms() {
        return films;
    }

    public ArrayList<String> getSpecies() {
        return species;
    }

    public ArrayList<String> getVehicles() {
        return vehicles;
    }

    public ArrayList<String> getStarships() {
        return starships;
    }

    public String getUrl() {
        return url;
    }


}


