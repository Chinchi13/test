package interfaces;

import org.openqa.selenium.WebElement;

public interface seleniumActionsMethodsI {

	public void moveMouse(WebElement element) throws InterruptedException;
	public void moveMouseSlider(WebElement element);
	public void moveMouseSliderDisminucion(WebElement element);
	public void moveMouseSliderAumentoAdicional(WebElement element);
}
