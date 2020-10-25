package adapters.BL;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import interfaces.seleniumReadTablesI;

import java.util.List;
import java.util.concurrent.TimeUnit;

import java.util.Iterator;

public class seleniumReadTables implements seleniumReadTablesI {

	protected WebDriver driver;

	public seleniumReadTables(WebDriver driver) {

		this.driver = driver;
	}

	public void SelectTable(WebElement element, String variable) {

		Select oSelect = new Select(element);
		List<WebElement> elem = oSelect.getOptions();
		int iSize = elem.size();
		for (int i = 0; i < iSize; i++) {
			String sValue = oSelect.getOptions().get(i).getText();
			oSelect.getOptions().get(i).click();
			System.out.println(sValue);
			if (sValue.equals(variable)) {
				oSelect.selectByIndex(i);

				break;
			}
		}

	}

	public void selectTableSapn(String valor) {
		try {
			List<WebElement> links = driver.findElements(By.tagName("span"));
			Iterator<WebElement> iter = links.iterator();
			while (iter.hasNext()) {
				WebElement we = iter.next();
				if (we.getText().trim().contains(valor)) {
					we.click();

				}
			}
		} catch (Exception e) {

e.printStackTrace();
		}


	}
	public void SearchTableboton(WebElement element, String variable,int tdposition) {
		try 
		{	
			List<WebElement> rows = element.findElements(By.tagName("tr"));
	
			for (int i=0; i<rows.size();i++) {
				System.out.print(element.findElement(By.xpath("//*[@id=\"TablaClientes\"]/tr["+ (i +1)+"]/td["+tdposition+"]")).getText());
				
			  if(element.findElement(By.xpath("//*[@id=\"TablaClientes\"]/tr["+ (i +1)+"]/td["+tdposition+"]")).getText().trim().equals(variable))
			  {
				  element.findElement(By.xpath("//*[@id=\"TablaClientes\"]/tr["+ (i +1)+"]/td[5]/button")).click();
				  break;
				  
				  
			  }
			}
		}catch(Exception e) {

	}
}   
	public void selectTableSapn1(String valor) throws InterruptedException {
		List<WebElement> links = driver.findElements(By.tagName("span"));
		Iterator<WebElement> iter = links.iterator();
		while (iter.hasNext()) {
			WebElement we = iter.next();
			if (we.getText().trim().contains(valor)) {
				Actions action = new Actions(driver);
				we.click();
				TimeUnit.SECONDS.sleep(3);
				action.doubleClick(we);

				action.perform();

			}
		}

	}
	public void dobleClick(WebElement element) throws Exception {
		try {

			Actions action = new Actions(driver);
			action.doubleClick(element);
			action.perform();
		} catch (Exception e) {

			System.out.println("Nombre de elemento no encontrado para click = " + element.getText() + "\r\n");

			throw e;
		}

	}
	public void tablaGestion20020(WebElement element, String variable, int tdposition) {

		try {
			List<WebElement> rows = element.findElements(By.tagName("tr"));

			for (int i = 0; i < rows.size(); i++) {
				System.out.print(element.findElement(By.xpath("//*[@id='gridDetalleMovimientos']/div[@class]/table/tbody/tr["+ (i + 1) + "]/td[" + tdposition + "]")).getText());

				if (element.findElement(By.xpath("//*[@id='gridDetalleMovimientos']/div[@class]/table/tbody/tr[" + (i + 1) + "]/td[" + tdposition + "]")).getText().trim().equals(variable)) {
					System.out.print(element);
					dobleClick(element.findElement(By.xpath("//*[@id='gridDetalleMovimientos']/div[@class]/table/tbody/tr["	+ (i + 1) + "]/td[1]/span/span[2]/span/span[2]")));
					break;

				}
			}

		} catch (Exception e) {

			e.printStackTrace();

		}
	}
	

}
