package app;

import com.google.gson.Gson;
import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.JsonNode;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;
import models.People;

public class MainClass {
    public static void main(String[] args) throws UnirestException {





        HttpResponse<JsonNode> jsonResponse = Unirest.get("http://swapi.co/api/people/1")
                .asJson();

        System.out.print("status code: ");
        System.out.println(jsonResponse.getStatus());

        System.out.print("status text: ");
        System.out.println(jsonResponse.getStatusText());

        System.out.print("headers: ");
        System.out.println(jsonResponse.getHeaders());

        System.out.print("body: ");
        System.out.println(jsonResponse.getBody());

        Gson gson = new Gson();
        String responseJsonString = jsonResponse.getBody().toString();
        People people = gson.fromJson(responseJsonString, People.class);

        System.out.println(people.getName());



    }

}
