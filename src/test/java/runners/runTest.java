package runners;

import cucumber.api.Scenario;
import Utils.Driver;
import Utils.Utils;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(features = { "src/test/resources/llenarCampos.feature" }, 
tags= {"Important"},
glue = { "bindings/", "Utils.Hooks", "Archivos/" }
, monochrome = true,
plugin = {
		"pretty", 
		"html:target/cucumber-htmlreport",
		"json:target/cucumber-reports/Cucumber.json",
		"com.cucumber.listener.ExtentCucumberFormatter:target/ExtentReport.html"})
public class runTest {

	public Scenario scenario;

	@BeforeClass
	public static void testSetup() {
		Runtime r = Runtime.getRuntime();
		r.addShutdownHook(new MyThread());
		Driver.initChromeDriver();
	}

	@AfterClass
	public static void teardownclass() throws InterruptedException {
		Driver.quitDriver();
	}
}

class MyThread extends Thread {
	public void run() {

}
}