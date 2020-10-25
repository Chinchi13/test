package Utils;

import cucumber.api.java.After;
import cucumber.api.java.Before;

import static Utils.Driver.driver;

public class Hooks {
    @Before
    public void beforeScenario() {
        if (driver != null) {
            Driver.getDriver();
        } else {
            Driver.initChromeDriver();
        }
    }
    @After
    public static void afterScenario() throws InterruptedException {
    	   System.out.println("after");
    	   	    }
}