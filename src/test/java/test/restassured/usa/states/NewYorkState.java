package test.restassured.usa.states;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
//import static org.

import io.restassured.response.Response;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

/**
 * Created by zsayed on 7/11/2017.
 */
public class NewYorkState {
//    RestAssured request = new RestAssured();
    Response response;
    String URL = "http://services.groupkt.com/state/search/USA?text=new";

    @BeforeClass
    public void initSetup() {
    	System.out.println("NewYorkState BeforeClass");
        response = given().when().get(URL);
    }

    @Test
    public void test01() throws InterruptedException {
        Thread.sleep(5000);
        System.out.println("NewYorkState Test01");
        response.then().statusCode(200);
    }

    @Test
    public void test02() throws Exception {
        Thread.sleep(5500);
        System.out.println("NewYorkState Test02");
        response.then().contentType("application/json");
    }

    @Test
    public void test03() throws Exception {
        Thread.sleep(1000);
        System.out.println("NewYorkState Test03");
//        response.then().body(containsString("new york"));
    }
}
