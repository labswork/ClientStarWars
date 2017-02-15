package app;

import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.JsonNode;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;
import com.mashape.unirest.request.GetRequest;
import com.mashape.unirest.request.HttpRequest;
import com.mashape.unirest.request.HttpRequestWithBody;

/**
 * Created by rootid on 13.02.2017.
 */
public class MainClass {
    public static void main(String[] args) throws UnirestException {



        HttpResponse<JsonNode> jsonResponse = Unirest.post("http://httpbin.org/post")
                .header("accept", "application/json")
                .queryString("apiKey", "123")
                .field("parameter", "value")
                .field("foo", "bar")
                .asJson();






        System.out.print("status code: ");
        System.out.println(jsonResponse.getStatus());

        System.out.print("status text: ");
        System.out.println(jsonResponse.getStatusText());

        System.out.print("heders: ");
        System.out.println(jsonResponse.getHeaders());

        System.out.print("body: ");
        System.out.println(jsonResponse.getBody());


////        HttpRequestWithBody request = Unirest.post("http://httpbin.org/people");
//
//        HttpResponse response = Unirest.get("http://httpbin.org/people")
//                .header("accept", "application/json").asString();
//
//
////        HttpResponse<JsonNode> jsonResponse = Unirest.post("http://httpbin.org/people").asJson();
//        System.out.println(response);
//
//



    }
}
