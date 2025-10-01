package stepdefinations;

import io.cucumber.java.en.Given;
import io.restassured.response.Response;
import org.json.JSONObject;
import org.junit.Assert;
import org.junit.Test;
import utils.Constant;
import utils.SetupEndpoint;


public class CreateNewUserTest {

    @Test()
    @Given("Basarili sekilde kullanici olusturma")
    public void create_new_user() {
        SetupEndpoint.createUrl("/users");
        JSONObject jsonBody = new JSONObject();
        jsonBody.put("name", "Serkan");
        jsonBody.put("job", "QA Engineer");

        Response response = SetupEndpoint.createRequestWithBodyAndParams("reqres-free-v1",jsonBody).post();
        System.out.println(response.getBody().asString());
        Assert.assertEquals(Constant.STATUS_CODE_NOT_201,201,response.statusCode());

    }


    @Test()
    @Given("Basarili sekilde kullanici guncelleme")
    public void update_user() {
        SetupEndpoint.createUrl("/users/2");
        JSONObject jsonBody = new JSONObject();
        jsonBody.put("name", "Serkan");
        jsonBody.put("job", "Doctor");

        Response response = SetupEndpoint.createRequestWithBodyAndParams("reqres-free-v1",jsonBody).put();
        System.out.println(response.getBody().asString());
        Assert.assertEquals(Constant.STATUS_CODE_NOT_200,200,response.statusCode());

    }

    @Test()
    @Given("PATCH ile basarili sekilde kullanici guncelleme")
    public void update_user_with_patch() {
        SetupEndpoint.createUrl("/users/2");
        JSONObject jsonBody = new JSONObject();
        jsonBody.put("name", "morpheus");
        jsonBody.put("job", "zion resident");

        Response response = SetupEndpoint.createRequestWithBodyAndParams("reqres-free-v1",jsonBody).patch();
        System.out.println(response.getBody().asString());
        Assert.assertEquals(Constant.STATUS_CODE_NOT_200,200,response.statusCode());

    }
}
