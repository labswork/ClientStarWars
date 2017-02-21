package models.Arrays;

import models.Film;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by rootid on 19.02.2017.
 */
public class Films {
    private Map<String, Film> filmMap = new HashMap<String, Film>();

    public void addFilm(String url, Film film){
        filmMap.put(url, film);
    }
    public Film getFilm(String url){
        return filmMap.get(url);
    }

    public void setFilmMap(Map<String, Film> filmMap) {
        this.filmMap = filmMap;
    }
}