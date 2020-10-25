package interfaces;

import java.io.IOException;

import org.openqa.selenium.WebElement;

import cucumber.api.Scenario;

public interface seleniumGenericsI {

	public void clickOnElement(WebElement element);

	public void typeOnElement(WebElement element, String text);

	public void tablaDistribuirFinanciamiento_PagFinanciamiento(WebElement element, String variable, int tdposition);

	public void dobleClick(WebElement element) throws Exception;

	public void TakeSnapShot(Scenario scenario);

	public void createAndSetTxt(Scenario scenario) throws IOException;

	public void SearchTable(WebElement element, String variable, int tdposition);

	public void SelectListProductos(WebElement element, String valor);

	public void tablaPagoMalAplicado(WebElement element, String variable, int tdposition);

	public void tablaDistribuir(WebElement element, String variable, int tdposition);

	public void AssertTextModalTakeSnapShot(WebElement element, String valor, Scenario scenario)
			throws InterruptedException;

	public void tablaPagoMalFinanciamientos(WebElement element, String variable, int tdposition);

	public void tablaDistribuirFinanciamiento(WebElement element, String variable, int tdposition);

	public void elementClickable(WebElement el);

	public void explicitWait();

	public void SearchTableVentas(WebElement element, String variable, int tdposition);

	public void senkeys(WebElement element, String codigoBloqueo);
}
