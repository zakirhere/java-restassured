package framework;

import io.restassured.http.ContentType;
import io.restassured.response.Response;

import static com.google.common.truth.Truth.assertThat;
import static io.restassured.RestAssured.given;

public class ApiTestBase extends Dataprovider {

    public Response doPut(String url, String body, String token) {
        if (token == null) {
            return doRequestWIthoutHeader("PUT", url, body);
        }
        return doRequest("PUT", url, body, token);
    }

    public Response doGet(String url, String token) {
        Response response = given()
                .log().all()
                .contentType(ContentType.JSON)
                .header("X-Auth-Token", token)
                .when()
                .request("GET", url)
                .then()
                .log().all()
                .extract().response();
        return response;
    }

    public Response doPost(String url, String body, String token) {
        if (token == null) {
            return doRequestWIthoutHeader("POST", url, body);
        }
        return doRequest("POST", url, body, token);
    }

    public static Response doRequest(String method, String url, String body, String token) {
        Response response = given()
                .log().all()
                .contentType(ContentType.JSON)
                .header("X-Auth-Token", token)
                .body(body)
                .when()
                .request(method, url)
                .then()
                .log().all()
                .extract().response();
        return response;
    }

    public static Response doRequestWIthoutHeader(String method, String url, String body) {
        Response response = given()
                .log().all()
                .contentType(ContentType.JSON)
                .body(body)
                .when()
                .request(method, url)
                .then()
                .log().all()
                .extract().response();
        return response;
    }

    public static void checkApiSuccess(Response response) {
        assertThat(response.getStatusCode()).isEqualTo(200);
    }

}
