package utils;

import io.restassured.specification.RequestSpecification;
import org.json.JSONObject;

import java.util.Map;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;
import static utils.Constant.BASE_URL;

public class SetupEndpoint {
    //Bunları bütün endpointlerde yazıyoruz teker teker yazmamak için bu class'ı oluşturuyoz

    public static RequestSpecification createRequest(String apiKey){
        return given().header("Content-Type", "application/json")
                .header("x-api-key", apiKey)
                .when();
    }

    public static RequestSpecification createRequestWithParams(){
        return given()
                .header("Content-Type", "application/json")
                .when();
    }

    public static RequestSpecification createRequestWithHeaders(String apiKey){
        return given()
                .header("Content-Type", "application/json")
                .header("x-api-key", apiKey)
                .when();
    }

    public static RequestSpecification createRequestWithBody(JSONObject jsonBody){
        return given()
                .body(jsonBody.toString())
                .header("Content-Type", "application/json")
                .when();
    }

    public static RequestSpecification createRequestWithBodyAndParams(String apiKey,JSONObject jsonBody){
        return given()

                .header("Content-Type", "application/json")
                .header("x-api-key", apiKey)
                .body(jsonBody.toString())
                .when();
    }

    public static RequestSpecification createRequestWithParam(String key, String value,String apiKey) {
        return given()
                .header("Content-Type", "application/json")
                .header("x-api-key", apiKey)
                .queryParam(key, value)   // 👈 dışarıdan gelen parametreyi ekliyoruz
                .when();
    }

    public static void createUrl(String path) {
        baseURI = BASE_URL + path;
    }
}
