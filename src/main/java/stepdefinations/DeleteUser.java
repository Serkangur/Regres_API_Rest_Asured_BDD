package stepdefinations;

import io.cucumber.java.en.Given;
import io.restassured.response.Response;
import org.junit.Assert;
import org.junit.Test;
import utils.Constant;
import utils.SetupEndpoint;

public class DeleteUser {

    @Test()
    @Given("Basarili sekilde kullanici silme")
    public void successful_delete_user() {
        SetupEndpoint.createUrl("/users/2");
        Response response = SetupEndpoint.createRequestWithHeaders("reqres-free-v1").delete();
        System.out.println(response.getBody().asString());
        Assert.assertEquals(Constant.STATUS_CODE_NOT_200,204,response.statusCode());

    }}
