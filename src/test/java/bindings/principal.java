package bindings;   

import Utils.Driver;
import Utils.Excel;
import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import pageObjects.Page_Princiapl;

public class principal extends Driver{
	 Page_Princiapl ps = new Page_Princiapl(driver);	
	


	public static Scenario scenario;

	@Before
	public void before(Scenario pScenario) { // se ejecuta al iniciar la prueba
		scenario = pScenario;
	}
//		@After
//			public static void tearDown(Scenario tDScenario) {
//				scenario = tDScenario;
//				String escenario = scenario.getName().toString();
//				String lastScenario = "Solicitud de Pin para entrega a domicilio (OSR) 20019";
//				if (lastScenario.equals(escenario)) {
//					Driver.quitDriver();
//				} else {
//					Driver.quitDriver();
//					Driver.initChromeDriver();
//				}
//			} 
//	

	@Given("^Insertar datos")
	public void Insertar_los_datos_del_Login() throws Throwable {
		

		ps.llenarcampos(scenario);;
	
	
	}


}
