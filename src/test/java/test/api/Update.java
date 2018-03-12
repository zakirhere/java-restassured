package test.api;

import framework.E2ESuiteBase;
import framework.UserTestBase;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static com.google.common.truth.Truth.assertThat;

public class Update extends UserTestBase {

    @BeforeClass
    public void setupToken() {
        setToken();
    }

    @Test(dataProvider = "updateDetails")
    public void updateUserDetails(String email, String fieldToUpdate, Object oldValue, Object newValue) {
        Object[] getUserToUpdate = getUserDetailsByEmail(email);
        int id = Integer.parseInt(usersAvailable.get(email).toString());
        String firstName = fieldToUpdate.equals("first_name") ? newValue.toString() : getUserToUpdate[1].toString();
        String lastName = fieldToUpdate.equals("last_name") ? newValue.toString() : getUserToUpdate[2].toString();
        int age = fieldToUpdate.equals("age") ? Integer.parseInt(newValue.toString()) : Integer.parseInt(getUserToUpdate[3].toString());

        Response response = updateUser(id, firstName, lastName, email, age, E2ESuiteBase.token);
        checkApiSuccess(response);

        JsonPath res = response.getBody().jsonPath();
        assertThat(res.getInt("id")).isEqualTo(id);
        assertThat(res.getString("first_name")).isEqualTo(firstName);
        assertThat(res.getString("last_name")).isEqualTo(lastName);
        assertThat(res.getInt("age")).isEqualTo(age);
        assertThat(res.getString("email")).isEqualTo(email);
    }

}
