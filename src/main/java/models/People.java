package models;
import utils.BuildModels;

import javax.xml.bind.annotation.*;
import java.util.ArrayList;

@XmlRootElement(name = "People")
@XmlType(propOrder = {"name", "height", "mass", "hair_color", "skin_color", "eye_color", "birth_year", "gender", "homeworld", "films", "species", "vehicles", "starships"})
public class People {



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

    public People() {

    }

    public People(People people) {
    }


    public String getName() {
        return this.name;
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

    @XmlElementWrapper
    @XmlElement(name = "film")
    public ArrayList<String> getFilms() {
        return films;
    }

    @XmlElementWrapper
    @XmlElement(name = "specie")
    public ArrayList<String> getSpecies() {
        return species;
    }

    @XmlElementWrapper
    @XmlElement(name = "vehicle")
    public ArrayList<String> getVehicles() {
        return vehicles;
    }

    @XmlElementWrapper
    @XmlElement(name = "starship")
    public ArrayList<String> getStarships() {
        return starships;
    }

//    @XmlTransient]
    @XmlAttribute
    public String getUrl() {
        return url;
    }

//    @XmlAttribute(name = "id")
//    public int getID(){
//        return  BuildModels.getID(url);
//    }



    public void setName(String name) {
        this.name = name;
    }

    public void setHeight(String height) {
        this.height = height;
    }

    public void setMass(String mass) {
        this.mass = mass;
    }

    public void setHair_color(String hair_color) {
        this.hair_color = hair_color;
    }

    public void setSkin_color(String skin_color) {
        this.skin_color = skin_color;
    }

    public void setEye_color(String eye_color) {
        this.eye_color = eye_color;
    }

    public void setBirth_year(String birth_year) {
        this.birth_year = birth_year;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public void setHomeworld(String homeworld) {
        this.homeworld = homeworld;
    }

    public void setFilms(ArrayList<String> films) {
        this.films = films;
    }

    public void setSpecies(ArrayList<String> species) {
        this.species = species;
    }

    public void setVehicles(ArrayList<String> vehicles) {
        this.vehicles = vehicles;
    }

    public void setStarships(ArrayList<String> starships) {
        this.starships = starships;
    }

    public void setUrl(String url) {
        this.url = url;
    }


}


