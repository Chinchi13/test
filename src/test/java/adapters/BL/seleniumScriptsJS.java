package adapters.BL;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import interfaces.seleniumScriptsJSI;

public class seleniumScriptsJS implements seleniumScriptsJSI {
	protected WebDriver driver;

	public seleniumScriptsJS(WebDriver driver) {
		this.driver = driver;
	}

	public void scrollPageDown() {

		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollTo(0, document.body.scrollHeight)");

	}

	public void scrollPageDownMore() {

		((JavascriptExecutor) driver).executeScript("scroll(0,500)");

	}

	public void scrollDo() {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0, 200)");
	}
	public void scrollDown(WebElement element) {
				
		JavascriptExecutor js = (JavascriptExecutor)driver;

		js.executeScript("arguments[0].scrollIntoView();",element);

	} 
	public void scrollDoPA() {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0, 250)");
	}

	public void scrollVentas() {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0, 500)");
	}

	public void scrollCargosRecurrentes() {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0, 300)");
	}

	public void scrollDM() {

		((JavascriptExecutor) driver).executeScript("scroll(0,500)");

	}

	public void scrollPageUpMore() {

		((JavascriptExecutor) driver).executeScript("scroll(0,-600)");

	}

	public void scrollPageUp_More() {

		((JavascriptExecutor) driver).executeScript("window.scrollBy(0,-250)");

	}public void scrollPageUpp_More() {

		((JavascriptExecutor) driver).executeScript("window.scrollBy(0,-350)");

	}

	public void scrollPageUpMoreMonto() {

		((JavascriptExecutor) driver).executeScript("window.scrollBy(0,-450)");

	}

	public void scrollPageUp() {

		((JavascriptExecutor) driver).executeScript("scroll(0,-600)");

	}
	public void scrollPageUpPA() {

		((JavascriptExecutor) driver).executeScript("window.scrollBy(0,-10)");

	}
}
