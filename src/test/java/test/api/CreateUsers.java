package test.api;

import framework.E2ESuiteBase;
import framework.UserTestBase;
import io.restassured.response.Response;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static com.google.common.truth.Truth.assertThat;

public class CreateUsers extends UserTestBase {

    @BeforeClass
    public void setupToken() {
        setToken();
    }

    @Test(dataProvider = "userdata")
    public void testCreateUser(String email, String firstName, String lastName, int age) {
        Response resCreate = createUser(email, firstName, lastName, age, E2ESuiteBase.token);
        checkApiSuccess(resCreate);

        int id = resCreate.getBody().jsonPath().getInt("id");
        Response resGet = getUser(id, E2ESuiteBase.token);
        checkApiSuccess(resGet);
        usersAvailable.put(email, id);

        assertThat(resGet.getBody().jsonPath().getString("first_name")).isEqualTo(firstName);
        assertThat(resGet.getBody().jsonPath().getString("last_name")).isEqualTo(lastName);
        assertThat(resGet.getBody().jsonPath().getString("email")).isEqualTo(email);
        assertThat(resGet.getBody().jsonPath().getInt("age")).isEqualTo(age);
    }

}
