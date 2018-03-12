package test.api;

import framework.UserTestBase;
import org.testng.annotations.Test;

import static com.google.common.truth.Truth.assertThat;

public class DoLogin extends UserTestBase {

    @Test
    public void testLogin() {
        assertThat(setToken()).isNotNull();
    }

}
