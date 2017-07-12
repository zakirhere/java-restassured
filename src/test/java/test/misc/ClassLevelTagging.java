package test.misc;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.fest.assertions.api.Assertions.assertThat;

/**
 * Created by zsayed on 7/11/2017.
 */

@Test
public class ClassLevelTagging {

    @BeforeMethod
    public void resetCalc() {
        System.out.println("ClassLevelTagging BeforeMethod");
        assertThat(4).isEqualTo(4);
    }

    public void testAdd01() throws Exception {
        System.out.println("ClassLevel testAdd01");
        Thread.sleep(2000);
        assertThat(5).isEqualTo(5);
    }

    public void testAdd02() throws Exception {
        System.out.println("ClassLevel testAdd02");
        Thread.sleep(3000);
        assertThat(5).isEqualTo(5);
    }

}
