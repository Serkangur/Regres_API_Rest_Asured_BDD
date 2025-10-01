package stepdefinations;

import io.cucumber.java.en.Given;
import io.restassured.response.Response;
import org.json.JSONObject;
import org.junit.Assert;
import org.junit.Test;
import utils.Constant;
import utils.SetupEndpoint;

public class RegisterTest {
    @Test()
    @Given("Basarili sekilde kullanici kayit")
    public void successful_login() {
        SetupEndpoint.createUrl("/register");
        JSONObject jsonBody = new JSONObject();
        jsonBody.put("email", "eve.holt@reqres.in");
        jsonBody.put("password", "pistol");

        Response response = SetupEndpoint.createRequestWithBodyAndParams("reqres-free-v1",jsonBody).post();
        System.out.println(response.getBody().asString());
        Assert.assertEquals(Constant.STATUS_CODE_NOT_200,200,response.statusCode());

    }
}
