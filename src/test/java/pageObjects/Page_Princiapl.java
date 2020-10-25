package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


import adapters.BL.seleniumGenerics;
import cucumber.api.Scenario;
import interfaces.seleniumGenericsI;

public class Page_Princiapl {
	private seleniumGenericsI SG;
	@FindBy(id = "firstName")
	private WebElement firts;

	@FindBy(id = "lastName")
	private WebElement last;

	@FindBy(id = "username")
	private WebElement correo;

	@FindBy(name = "Passwd")
	private WebElement pass;

	@FindBy(name = "ConfirmPasswd")
	private WebElement confirmarpass;

	@FindBy(id = "headingText")
	private WebElement titulo;

	@FindBy(id = "accountDetailsNext")
	private WebElement account;

	public Page_Princiapl(WebDriver driver) {
		PageFactory.initElements(driver, this);
		SG = new seleniumGenerics(driver);
	}


	public void llenarcampos(Scenario scenario) throws InterruptedException {
		Thread.sleep(3000);
		SG.senkeys(firts, "Kevin");
		SG.senkeys(last, "Fonseca");
		SG.senkeys(correo, "usu9090909000000");
		SG.senkeys(pass, "12ERWE34DE");
		SG.senkeys(confirmarpass, "12ERWE34DE");
		SG.TakeSnapShot(scenario);
		SG.clickOnElement(account);		
	}

}
