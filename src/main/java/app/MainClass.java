package app;

import com.google.gson.*;
import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.JsonNode;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;
import deserialize.PeopleDeserializer;
import models.Arrays.People;
import models.Human;

public class MainClass {
    public static void main(String[] args) throws UnirestException {





        String url = "http://swapi.co/api/people/";
        String next = "First Start";
        People people = new People();

        while (next != "") {
            HttpResponse<JsonNode> jsonResponse = Unirest.get(url)
                    .asJson();

//            System.out.print("status code: ");
//            System.out.println(jsonResponse.getStatus());
//
//            System.out.print("status text: ");
//            System.out.println(jsonResponse.getStatusText());
//
//            System.out.print("headers: ");
//            System.out.println(jsonResponse.getHeaders());
//
            System.out.print("body: ");
            System.out.println(jsonResponse.getBody());
            String responseJsonString = jsonResponse.getBody().toString();

            JsonElement jsonElementParse = new JsonParser().parse(responseJsonString);
            JsonObject jsonObjectParse = jsonElementParse.getAsJsonObject();

//            System.out.println(jsonObjectParse.get("next").getAsString());

            if (jsonObjectParse.get("next").isJsonNull()){
                next = "";
            }
            else {
                next = jsonObjectParse.get("next").getAsString();
                url = next;
            }


            Gson gson = new GsonBuilder()
                    .registerTypeAdapter(People.class, new PeopleDeserializer())
                    .create();
            people = gson.fromJson(responseJsonString, People.class);
        }


        Human human = people.getPeople("http://swapi.co/api/people/88/");
        System.out.println(human.getName());




    }

}
