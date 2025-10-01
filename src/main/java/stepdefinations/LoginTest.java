package stepdefinations;

import io.cucumber.java.en.Given;
import io.restassured.response.Response;
import org.json.JSONObject;
import org.junit.Assert;
import org.junit.Test;
import utils.Constant;
import utils.SetupEndpoint;

public class LoginTest {

    @Test()
    @Given("Basarili sekilde kullanici girisi")
    public void successful_login() {
        SetupEndpoint.createUrl("/login");
        JSONObject jsonBody = new JSONObject();
        jsonBody.put("email", "eve.holt@reqres.in");
        jsonBody.put("password", "cityslicka");

        Response response = SetupEndpoint.createRequestWithBodyAndParams("reqres-free-v1",jsonBody).post();
        System.out.println(response.getBody().asString());
        Assert.assertEquals(Constant.STATUS_CODE_NOT_200,200,response.statusCode());

    }


    @Test()
    @Given("Gecerli mail gecersiz sifre kullanici girisi")
    public void failed_login_with_wrong_password() {
        SetupEndpoint.createUrl("/login");
        JSONObject jsonBody = new JSONObject();
        jsonBody.put("email", "eve.holt@reqres.in");
        jsonBody.put("password", "asdasdasd");

        Response response = SetupEndpoint.createRequestWithBodyAndParams("reqres-free-v1",jsonBody).post();
        System.out.println(response.getBody().asString());
        Assert.assertEquals(Constant.STATUS_CODE_NOT_401,401,response.statusCode());

    }

    @Test()
    @Given("Gecersiz mail gecerli sifre kullanici girisi")
    public void failed_login_with_wrong_email() {
        SetupEndpoint.createUrl("/login");
        JSONObject jsonBody = new JSONObject();
        jsonBody.put("email", "asdasd@reqres.in");
        jsonBody.put("password", "cityslicka");

        Response response = SetupEndpoint.createRequestWithBodyAndParams("reqres-free-v1",jsonBody).post();
        System.out.println(response.getBody().asString());
        Assert.assertEquals(Constant.STATUS_CODE_NOT_401,401,response.statusCode());

    }

    @Test()
    @Given("Gecersiz mail gecersiz sifre kullanici girisi")
    public void failed_login_with_wrong_mail_password() {
        SetupEndpoint.createUrl("/login");
        JSONObject jsonBody = new JSONObject();
        jsonBody.put("email", "asdasd@reqres.in");
        jsonBody.put("password", "asdasdasd");

        Response response = SetupEndpoint.createRequestWithBodyAndParams("reqres-free-v1",jsonBody).post();
        System.out.println(response.getBody().asString());
        Assert.assertEquals(Constant.STATUS_CODE_NOT_401,401,response.statusCode());

    }

    @Test()
    @Given("Bos mail ve sifre alanı ile kullanici girisi")
    public void empty_mail_password_login() {
        SetupEndpoint.createUrl("/login");
        JSONObject jsonBody = new JSONObject();
        jsonBody.put("email", "");
        jsonBody.put("password", "");

        Response response = SetupEndpoint.createRequestWithBodyAndParams("reqres-free-v1",jsonBody).post();
        System.out.println(response.getBody().asString());
        Assert.assertEquals(Constant.STATUS_CODE_NOT_400,400,response.statusCode());

    }
}
