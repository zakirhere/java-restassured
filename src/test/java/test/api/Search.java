package test.api;

import framework.E2ESuiteBase;
import framework.UserTestBase;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Map;

import static com.google.common.truth.Truth.assertThat;

/**
 * Created by zakir_000 on 3/3/2018.
 */
public class Search extends UserTestBase {

    @BeforeClass
    public void setupToken() {
        setToken();
    }

    @Test(dataProvider = "searchCriteria")
    public void testSearchUser(int startAge, int endAge, String emails) {
        Response response = searchUser(startAge, endAge, E2ESuiteBase.token);
        checkApiSuccess(response);

        ArrayList<Map<String, Object>> jsonAsArrayList = JsonPath.from(response.body().asString()).get("");

        for (Map<String, Object> user : jsonAsArrayList) {
            Object id = usersAvailable.get(user.get("email").toString());
            if(id == null) {
                System.out.println("Skipping not the user I created but found: " + user.get("email"));
                continue;
            }
            Object[] getUserToUpdate = getUserDetailsByEmail(user.get("email").toString());
            assertThat(user.get("first_name")).isEqualTo(getUserToUpdate[1].toString());
            assertThat(user.get("last_name")).isEqualTo(getUserToUpdate[2].toString());
            assertThat(user.get("age")).isEqualTo(getUserToUpdate[3]);
        }
        // Making sure we are not getting any extra users
        //assertThat(emails.split(",").length).isEqualTo(jsonAsArrayList.size());
    }
}
