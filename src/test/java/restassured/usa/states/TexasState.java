package restassured.usa.states;

import io.restassured.response.Response;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

/**
 * Created by zsayed on 7/11/2017.
 */
public class TexasState {
    Response response;
    String URL = "http://services.groupkt.com/state/search/USA?text=texas";

    @BeforeClass
    public void initSetup() {
        System.out.println("BeforeClass TexasState");
        response = given().when().get(URL);
    }

    @Test
    public void test01() throws InterruptedException {
        Thread.sleep(5000);
        System.out.println("TexasState Test01");
        response.then().statusCode(200);
    }

    @Test
    public void test02() throws Exception {
        Thread.sleep(3000);
        System.out.println("TexasState Test02");
        response.then().contentType("application/json");
    }

    @Test
    public void test03() throws Exception {
        Thread.sleep(1000);
        System.out.println("TexasState Test03");
//        response.then().body(containsString("texas"));
    }
}
