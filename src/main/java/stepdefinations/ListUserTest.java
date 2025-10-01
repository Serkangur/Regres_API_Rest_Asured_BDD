package stepdefinations;

import io.cucumber.java.en.Given;
import io.restassured.response.Response;
import model.ListUser;
import org.junit.Assert;
import org.junit.Test;
import utils.Constant;
import utils.SetupEndpoint;

public class ListUserTest {
    public static ListUser user;
    @Test()
    @Given("1. sayfadaki kullanıcılar listelenir")
    public void list_user() {

        SetupEndpoint.createUrl("/users");
        Response response= SetupEndpoint.createRequest("reqres-free-v1").get();
        System.out.println(response.getBody().asString());
        user = response.getBody().as(ListUser.class);
        Assert.assertEquals(Constant.STATUS_CODE_NOT_200,response.statusCode(),200);
        Assert.assertEquals(Constant.FIRST_PAGE,user.getPage());
        Assert.assertEquals(Constant.PER_PAGE,user.getPer_page());
        Assert.assertEquals(Constant.TOTAL,user.getTotal());

    }

    @Test()
    @Given("2. sayfadaki kullanıcılar listelenir")
    public void list_user_page_two() {
        SetupEndpoint.createUrl("/users");
        Response response = SetupEndpoint.createRequestWithParam("page", "2","reqres-free-v1").get();
        System.out.println(response.getBody().asString());
        user = response.getBody().as(ListUser.class);
        Assert.assertEquals(Constant.STATUS_CODE_NOT_200,response.statusCode(),200);
        Assert.assertEquals(Constant.SECOND_PAGE,user.getPage());

    }

    @Test()
    @Given("Tek bir kullanıcı listeleme")
    public void list_singel_user() {
        SetupEndpoint.createUrl("/users/5");
        Response response = SetupEndpoint.createRequestWithHeaders("reqres-free-v1").get();
        System.out.println(response.getBody().asString());
        Assert.assertEquals(Constant.STATUS_CODE_NOT_200,response.statusCode(),200);

    }

    @Test()
    @Given("Kaynak Listesi")
    public void list_resource() {
        SetupEndpoint.createUrl("/unknown");
        Response response = SetupEndpoint.createRequestWithHeaders("reqres-free-v1").get();
        System.out.println(response.getBody().asString());
        Assert.assertEquals(Constant.STATUS_CODE_NOT_200,response.statusCode(),200);

    }

    @Test()
    @Given("Single resource")
    public void single_resource() {
        SetupEndpoint.createUrl("/unknown/12");
        Response response = SetupEndpoint.createRequestWithHeaders("reqres-free-v1").get();
        System.out.println(response.getBody().asString());
        Assert.assertEquals(Constant.STATUS_CODE_NOT_200,response.statusCode(),200);

    }




}
