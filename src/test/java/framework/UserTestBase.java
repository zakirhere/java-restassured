package framework;

import framework.Paths.UserPaths;
import io.restassured.response.Response;
import org.json.simple.JSONObject;

import java.util.HashMap;
import java.util.Map;

import static com.google.common.truth.Truth.assertThat;

/**
 * Created by zakir_000 on 3/3/2018.
 */
public class UserTestBase extends ApiTestBase {

    public static Map<String, Object> usersAvailable = new HashMap<>();

    public Response doLogin() {
        Map<String, String> req = new HashMap<>();
        req.put("username", "zsayed");
        req.put("password", "zsayed123");
        return doPost(UserPaths.LOGIN, new JSONObject(req).toString(), null);
    }

    public String setToken() {
        if(E2ESuiteBase.token == null) {
            Response response = doLogin();
            assertThat(response.getStatusCode()).isEqualTo(200);
            E2ESuiteBase.token = response.getBody().jsonPath().getString("token");
        }
        return E2ESuiteBase.token;
    }

    public Response createUser(String email, String firstName, String lastName, int age, String token) {
        Map<String, Object> req = new HashMap<>();
        req.put("email", email);
        req.put("first_name", firstName);
        req.put("last_name", lastName);
        req.put("age", age);

        return doPost(UserPaths.USER, new JSONObject(req).toString(), token);
    }

    public Response getUser(int id, String token) {
        return doGet(UserPaths.USER + "/" + id, token);
    }

    public Response updateUser(int id, String firstName, String lastName, String email, int age, String token) {
        Map<String, Object> req = new HashMap<>();
        req.put("id", id);
        req.put("first_name", firstName);
        req.put("last_name", lastName);
        req.put("email", email);
        req.put("age", age);

        return doPut(UserPaths.USER + "/" + id, new JSONObject(req).toString(), token);
    }

    public Response searchUser(int startAge, int endAge, String token) {
        Map<String, Object> req = new HashMap<>();
        req.put("start_age", startAge);
        req.put("end_age", endAge);

        return doPost(UserPaths.USER_SEARCH, new JSONObject(req).toString(), token);
    }
}
