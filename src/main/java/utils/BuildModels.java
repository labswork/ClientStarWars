package utils;

import com.google.gson.*;
import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.JsonNode;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;

import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class BuildModels {

    private static Pattern pattern = Pattern.compile("\\d");

    public static String requestJsonString(String url) throws UnirestException{
        HttpResponse<JsonNode> jsonResponse = Unirest.get(url)
                .asJson();
        return jsonResponse.getBody().toString();
    }
    public static boolean itLastPage(String jsonString){
        JsonObject jsonObjectParse = getJsonObjectParse(jsonString);
        if (jsonObjectParse.get("next").isJsonNull()){
            return true;
        }
        return false;
    }
    public static String getNextPageLink(String jsonString){
        JsonObject jsonObjectParse = getJsonObjectParse(jsonString);
        return jsonObjectParse.get("next").getAsString();
    }
    public static JsonObject getJsonObjectParse(String jsonString){
        JsonElement jsonElementParse = new JsonParser().parse(jsonString);
        return jsonElementParse.getAsJsonObject();
    }
    public static int getID(String url){
        Matcher matcher = pattern.matcher(url);
        int id = -1;
        if (matcher.find()) id = Integer.parseInt(matcher.group());
        return id;

    }

}
