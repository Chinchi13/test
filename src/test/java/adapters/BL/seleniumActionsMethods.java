package adapters.BL;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import interfaces.seleniumActionsMethodsI;

public class seleniumActionsMethods implements seleniumActionsMethodsI {

	protected WebDriver driver;
	protected WebDriverWait wait;

	public seleniumActionsMethods(WebDriver driver) {

		this.driver = driver;
		wait = new WebDriverWait(driver, 60);
	}

	public void moveMouse(WebElement element) throws InterruptedException {
		wait.until(ExpectedConditions.visibilityOf(element));
		
		wait.until(ExpectedConditions.visibilityOf(element));

		wait.until(ExpectedConditions.elementToBeClickable(element));
		TimeUnit.SECONDS.sleep(3);

		Actions actions = new Actions(driver);
		actions.moveToElement(element).perform();
	}
	public void moveMouseSlider(WebElement element) {
		

		wait.until(ExpectedConditions.elementToBeClickable(element));
		Actions actions = new Actions(driver);
		actions.moveToElement(element).perform();
		actions.dragAndDropBy(element,10,0).release().build().perform();
		element.click();
	}

	public void moveMouseSliderDisminucion(WebElement element) {

		wait.until(ExpectedConditions.elementToBeClickable(element));
		Actions actions = new Actions(driver);
		actions.moveToElement(element).perform();
		actions.dragAndDropBy(element,-30,0).release().build().perform();
		element.click();
	}
	public void moveMouseSliderAumentoAdicional(WebElement element) {
		

		wait.until(ExpectedConditions.elementToBeClickable(element));
		Actions actions = new Actions(driver);
		actions.moveToElement(element).perform();
		actions.dragAndDropBy(element,18,0).release().build().perform();
		element.click();
	}

}
