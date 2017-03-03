package utils;

import com.google.gson.*;
import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.JsonNode;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;


/**
 * Created by rootid on 19.02.2017.
 */
public class BildModels {


    public String requestJsonString(String url) throws UnirestException{
        HttpResponse<JsonNode> jsonResponse = Unirest.get(url)
                .asJson();
        System.out.print("body: ");
        System.out.println(jsonResponse.getBody());
        return jsonResponse.getBody().toString();
    }
    public boolean itLastPage(String jsonString){
        JsonObject jsonObjectParse = getJsonObjectParse(jsonString);
        if (jsonObjectParse.get("next").isJsonNull()){
            return true;
        }
        return false;
    }
    public String getNextPageLink(String jsonString){
        JsonObject jsonObjectParse = getJsonObjectParse(jsonString);
        return jsonObjectParse.get("next").getAsString();
    }
    public JsonObject getJsonObjectParse(String jsonString){
        JsonElement jsonElementParse = new JsonParser().parse(jsonString);
        return jsonElementParse.getAsJsonObject();
    }

}
