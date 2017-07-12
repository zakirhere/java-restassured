package slow;

import org.testng.annotations.Test;
import static org.fest.assertions.api.Assertions.assertThat;

import org.testng.annotations.BeforeMethod;
public class DelayedExecution {

    @BeforeMethod(alwaysRun = true)
    public void resetCalc() {
        System.out.println("DelayedExecution BeforeMethod");
        assertThat(4).isEqualTo(4);
    }

    @Test(dependsOnMethods= {"testAdd03"}, alwaysRun = true)
	public void testAdd01() throws Exception {
    	System.out.println("Delayed  testAdd01");
    	Thread.sleep(2000);
    	assertThat(5).isEqualTo(5);
    }
    
    @Test(dependsOnMethods= {"testAdd01"})
	public void testAdd02() throws Exception {
    	System.out.println("Delayed  testAdd02");
    	Thread.sleep(3000);
        assertThat(5).isEqualTo(5);
    }
    
    @Test
	public void testAdd03() {
    	System.out.println("Delayed  testAdd03");
        assertThat(5).isEqualTo(5);
    }
    
    @Test
	public void testAdd04() {
    	System.out.println("Delayed  testAdd04");
        assertThat(5).isEqualTo(5);
    }
    
    @Test
	public void testAdd05() throws InterruptedException {
    	System.out.println("Delayed  testAdd05");
    	Thread.sleep(1000);
        assertThat(5).isEqualTo(5);
    }
    
    @Test
	public void testAdd06() {
        assertThat(5).isEqualTo(5);
    }
}
