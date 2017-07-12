package restassured.usa.states;

import io.restassured.response.Response;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

/**
 * Created by zsayed on 7/11/2017.
 */
public class CaliforniaState {
    Response response;
    String URL = "http://services.groupkt.com/state/search/USA?text=california";

    @BeforeClass
    public void initSetup() {
    	System.out.println("CaliforniaState BeforeClass");
        response = given().when().get(URL);
    }

    @Test
    public void test01() throws InterruptedException {
        Thread.sleep(5000);
        System.out.println("CaliforniaState Test01");
        response.then().statusCode(200);
    }

    @Test
    public void test02() throws Exception {
        Thread.sleep(3000);
        System.out.println("CaliforniaState Test02");
        response.then().contentType("application/json");
    }

    @Test
    public void test03() throws Exception {
        Thread.sleep(1000);
        System.out.println("CaliforniaState Test03");
//        response.then().body(containsString("california"));
    }
}
