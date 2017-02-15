package app;

import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.JsonNode;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;


public class MainClass {
    public static void main(String[] args) throws UnirestException {





        HttpResponse<JsonNode> jsonResponse = Unirest.get("http://swapi.co/api/")
                .asJson();



        System.out.print("status code: ");
        System.out.println(jsonResponse.getStatus());

        System.out.print("status text: ");
        System.out.println(jsonResponse.getStatusText());

        System.out.print("headers: ");
        System.out.println(jsonResponse.getHeaders());

        System.out.print("body: ");
        System.out.println(jsonResponse.getBody());




    }
}
