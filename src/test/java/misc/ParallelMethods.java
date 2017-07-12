package misc;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.fest.assertions.api.Assertions.assertThat;

/**
 * Created by zsayed on 7/11/2017.
 */
public class ParallelMethods {

    @BeforeMethod
    public void resetCalc() {
        System.out.println("Executing ParallelMethods BeforeMethod");
        assertThat(4).isEqualTo(4);
    }

    @Test
    public void testAdd01() throws Exception {
        System.out.println("Executing testAdd01");
        assertThat(5).isEqualTo(5);
    }

    @Test
    public void testAdd02() throws Exception {
        System.out.println("Executing testAdd02");
        assertThat(5).isEqualTo(5);
    }

}
