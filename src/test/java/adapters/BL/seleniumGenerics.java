package adapters.BL;

import static org.junit.Assert.assertTrue;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import Utils.Excel;
import cucumber.api.Scenario;
import interfaces.seleniumGenericsI;

public class seleniumGenerics  implements seleniumGenericsI {
	protected WebDriver driver;
	protected static WebDriverWait wait;
	private Excel e;

	public seleniumGenerics(WebDriver driver) {
		this.driver = driver;
		wait = new WebDriverWait(driver, 120);
		 e = new Excel();
	}

	public void senkeys(WebElement element, String text) {
		try {
			TimeUnit.SECONDS.sleep(2);
			wait.until(ExpectedConditions.elementToBeClickable(element)).sendKeys(text);
			TakeScreenFile();
		//	logger.info("Texto ingresado = " + text + "\r\n");
			System.out.println("Texto ingresado Correctamente = " + text + "\r\n");
		} catch (Exception e) {
			TakeScreenFile();
			//logger.error("Motivo de error: " + text);

			throw new RuntimeException("Motivo de error = " + e.getLocalizedMessage());
		}

	}
	
	public void elementClickable(WebElement el) {
		WebDriverWait wait = new WebDriverWait(driver, 130);
		wait.until(ExpectedConditions.elementToBeClickable(el));


	}

	public void clickOnElement(WebElement element) {
		try {

			wait.until(ExpectedConditions.visibilityOf(element));
			element.isEnabled();
			System.out.println(
					BLACK + "El elemento se encuentra: = " + RESET + GREEN + element.isEnabled() + "\r\n" + RESET);

			String datoElemento = element.getText();
			if (datoElemento.isEmpty()) {
				System.out.println(BLUE + "Realiza accion click =" + "\r\n" + RESET);
			} else {
				System.out.println(BLACK + "Accion click al elemento llamado: = " + RESET + BLUE + element.getText()
						+ "\r\n" + RESET);
			}
			TakeScreenFile();

			wait.until(ExpectedConditions.elementToBeClickable(element)).click();

		} catch (Exception e) {


			System.out.println("Nombre de elemento no encontrado para click = " + element.getText() + "\r\n");
			TakeScreenFile();
			throw new RuntimeException("Motivo de error del evento Click= " + RED + e.getLocalizedMessage() + RESET);

		}

	}

	public void explicitWait() {
		WebDriverWait wait = new WebDriverWait(driver, 130);
		WebElement loding = driver.findElement(By.id("loading"));

		if (loding.isEnabled()) {
			try {
				wait.until(ExpectedConditions.invisibilityOfElementLocated(By.id("loading")));
			} catch (Exception e) {
				TakeScreenFile();

			}
		}
	}

	public void typeOnElement(WebElement element, String text) {
		try {

			wait.until(ExpectedConditions.elementToBeClickable(element)).sendKeys(text);

			TakeScreenFile();
			TimeUnit.SECONDS.sleep(2);

		} catch (Exception e) {

			TakeScreenFile();
			throw new RuntimeException("Motivo de error = " + e.getLocalizedMessage());
		}
	}

	public void TakeSnapShot(Scenario scenario) {
		TakeScreenFile();
		scenario.embed(((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES), "image/png");
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

	public void SelectListProductos(WebElement element, String valor) {

		try {
			List<WebElement> rows = element.findElements(By.tagName("span"));
			for (WebElement row : rows) {
				if (row.getText().trim().contains(valor)) {
					row.click();
					row.click();
					break;
				}
			}
		} catch (Exception e) {

			e.printStackTrace();
		}
	}

	public void SearchTable(WebElement element, String variable, int tdposition) {

		try {
			List<WebElement> rows = element.findElements(By.tagName("tr"));

			for (int i = 0; i < rows.size(); i++) {
				System.out.print(element
						.findElement(By.xpath(
								"//*[@id=\"GridPlanes\"]/table/tbody/tr[" + (i + 1) + "]/td[" + tdposition + "]"))
						.getText());

				if (element
						.findElement(By.xpath(
								"//*[@id=\"GridPlanes\"]/table/tbody/tr[" + (i + 1) + "]/td[" + tdposition + "]"))
						.getText().trim().equals(variable)) {

					dobleClick(element.findElement(By
							.xpath("//*[@id=\"GridPlanes\"]/table/tbody/tr[" + (i + 1) + "]/td[7]/span/span[2]/span")));

					break;

				}
			}

		} catch (Exception e) {

			e.printStackTrace();

		}
	}

	public void SearchTableVentas(WebElement element, String variable, int tdposition) {

		try {
			List<WebElement> rows = element.findElements(By.tagName("tr"));

			for (int i = 0; i < rows.size(); i++) {
				System.out.print(element
						.findElement(By.xpath(
								"//*[@id=\"GridPlanes\"]/table/tbody/tr[" + (i + 1) + "]/td[" + tdposition + "]"))
						.getText());

				if (element
						.findElement(By.xpath(
								"//*[@id=\"GridPlanes\"]/table/tbody/tr[" + (i + 1) + "]/td[" + tdposition + "]"))
						.getText().trim().equals(variable)) {

					element.findElement(By.xpath("//*[@id=\"GridPlanes\"]/table/tbody/tr[" + (i + 1) + "]/td[6]/a"))
							.click();
					;

					break;

				}
			}

		} catch (Exception e) {

			e.printStackTrace();

		}
	}

	public WebDriver getDriver() {
		return driver;
	}

	public void tablaPagoMalFinanciamientos(WebElement element, String variable, int tdposition) {

		try {
			List<WebElement> rows = element.findElements(By.tagName("tr"));

			for (int i = 0; i < rows.size(); i++) {

				System.out.print(element.findElement(By.xpath(
						"//*[@id='gridInstalments']/div[2]/table/tbody/tr[" + (i + 1) + "]/td[" + tdposition + "]"))
						.getText());

				if (element.findElement(By.xpath(
						"//*[@id='gridInstalments']/div[2]/table/tbody/tr[" + (i + 1) + "]/td[" + tdposition + "]"))
						.getText().trim().equals(variable)) {
					dobleClick(element.findElement(By.xpath("//*[@id='gridInstalments']/div[2]/table/tbody/tr["
							+ (i + 1) + "]/td[2]/span/span[2]/span/span[2]")));

					break;

				} // *[@id="gridDetallePagosTC"]/div[2]/table/tbody/tr[1]/td[1]/span/span[1]
			}

		} catch (Exception e) {

			e.printStackTrace();

		}
	}

	public void tablaPagoMalAplicado(WebElement element, String variable, int tdposition) {

		try {
			List<WebElement> rows = element.findElements(By.tagName("tr"));

			for (int i = 0; i < rows.size(); i++) {

				System.out.print(element.findElement(By.xpath("//*[@id='gridDetallePagosTC']/div[2]/table/tbody/tr["
						+ (i + 1) + "]/td[" + tdposition + "]")).getText());

				if (element.findElement(By.xpath("//*[@id='gridDetallePagosTC']/div[2]/table/tbody/tr[" + (i + 1)
						+ "]/td[" + tdposition + "]")).getText().trim().equals(variable)) {
					dobleClick(element.findElement(By.xpath("//*[@id='gridDetallePagosTC']/div[2]/table/tbody/tr["
							+ (i + 1) + "]/td[1]/span[1]/span[2]/span/span[2]")));
					break;

				} // *[@id="gridDetallePagosTC"]/div[2]/table/tbody/tr[1]/td[1]/span/span[1]
			}

		} catch (Exception e) {

			e.printStackTrace();

		}
	}

	public void tablaDistribuir(WebElement element, String variable, int tdposition) {

		try {
			List<WebElement> rows = element.findElements(By.tagName("tr"));

			for (int i = 0; i < rows.size(); i++) {

				System.out.print(
						element.findElement(By.xpath("//*[@id=\"gridInstalmentsDistribuir\"]/div[2]/table/tbody/tr["
								+ (i + 1) + "]/td[" + tdposition + "]")).getText());

				if (element.findElement(By.xpath("//*[@id=\"gridInstalmentsDistribuir\"]/div[2]/table/tbody/tr["
						+ (i + 1) + "]/td[" + tdposition + "]")).getText().trim().equals(variable)) {

					dobleClick(
							element.findElement(By.xpath("//*[@id=\"gridInstalmentsDistribuir\"]/div[2]/table/tbody/tr["
									+ (i + 1) + "]/td[1]/span/span[2]/span")));
					break;

				}
			}

		} catch (Exception e) {

			e.printStackTrace();

		}
	}

	public void tablaDistribuirFinanciamiento(WebElement element, String variable, int tdposition) {

		try {
			List<WebElement> rows = element.findElements(By.tagName("tr"));

			for (int i = 0; i < rows.size(); i++) {
				System.out.print(
						element.findElement(By.xpath("//*[@id='gridInstalmentsDistribuir']/div[2]/table/tbody/tr["
								+ (i + 1) + "]/td[" + tdposition + "]")).getText());

				if (element.findElement(By.xpath("//*[@id='gridInstalmentsDistribuir']/div[2]/table/tbody/tr[" + (i + 1)
						+ "]/td[" + tdposition + "]")).getText().trim().equals(variable)) {

					dobleClick(
							element.findElement(By.xpath("//*[@id='gridInstalmentsDistribuir']/div[2]/table/tbody/tr["
									+ (i + 1) + "]/td[1]/span/span[2]/span")));

					break;

				}
			}

		} catch (Exception e) {

			e.printStackTrace();

		}
	}

	public void tablaDistribuirFinanciamiento_PagFinanciamiento(WebElement element, String variable, int tdposition) {

		try {
			List<WebElement> rows = element.findElements(By.tagName("tr"));

			for (int i = 0; i < rows.size(); i++) {
				System.out.print(
						element.findElement(By.xpath("//*[@id='gridInstalmentsDistribuir']/div[2]/table/tbody/tr["
								+ (i + 1) + "]/td[" + tdposition + "]")).getText());

				if (element.findElement(By.xpath("//*[@id='gridInstalmentsDistribuir']/div[2]/table/tbody/tr[" + (i + 1)
						+ "]/td[" + tdposition + "]")).getText().trim().equals(variable)) {

					dobleClick(
							element.findElement(By.xpath("//*[@id='gridInstalmentsDistribuir']/div[2]/table/tbody/tr["
									+ (i + 1) + "]/td[1]/span/span[2]/span/span[2]")));

					break;

				}
			}

		} catch (Exception e) {

			e.printStackTrace();

		}
	}

	public void AssertTextModalTakeSnapShot(WebElement element, String valor, Scenario scenario)
			throws InterruptedException {

		System.out.println("Nombre de elemento" + element.getText());
		String ValorTextoElemento = element.getText();
		System.out.println(ValorTextoElemento);

		if (ValorTextoElemento.equals(valor)) {

			assertTrue(element.isEnabled());
			TakeScreenFile();
			TakeSnapShot(scenario);

		}

		if (!ValorTextoElemento.equals(valor)) {
			TimeUnit.SECONDS.sleep(4);
			assertTrue(element.isEnabled());
			TakeScreenFile();
			TakeSnapShot(scenario);
			TimeUnit.SECONDS.sleep(2);
			driver.findElement(By.xpath("//button[text()='OK']")).click();
			throw new RuntimeException("Mensaje de error del sistema: " + ValorTextoElemento);

		}

	}

	private static String readAllBytesJava7(String filePath) {
		String content = "";

		try {
			content = new String(Files.readAllBytes(Paths.get(filePath)));
		} catch (IOException e) {
			e.printStackTrace();
		}

		return content;
	}

	int paso = 0;
	SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
	SimpleDateFormat hourFormat = new SimpleDateFormat("HH-mm-ss");
	Date date = new Date();

	String FolderPath2 = dateFormat.format(date);
	String FolderPath0 = hourFormat.format(date);

	public void TakeScreenFile() {
		try {

			String ValorScenario = "";

			File fileScenario = new File("C:\\Evidencia SGC CR\\Scenario.txt");

			if (fileScenario.exists()) {

				String fileName = "C:\\Evidencia SGC CR\\Scenario.txt";

				ValorScenario = this.readAllBytesJava7(fileName);
			}

			File file = new File("C:\\Evidencia SGC CR\\" + FolderPath2);
			file.isDirectory();

			String FolderPath6 = "C:\\Evidencia SGC CR\\" + new File(FolderPath2) + "\\" + ValorScenario + " "
					+ hourFormat.format(date) + "\\";

			String FolderPath4 = "C:\\Evidencia SGC CR\\" + FolderPath2 + "\\" + ValorScenario + " " + hourFormat.format(date)
					+ "\\";

			SimpleDateFormat hourFormat = new SimpleDateFormat("HH-mm-ss");
			SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");

			File f = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
			Date date2 = new Date();

			if (file.isDirectory()) {

				FileUtils.copyFile(f, new File(FolderPath4 + hourFormat.format(date2) + ".png"));

			}

			else {

				FileUtils.copyFile(f, new File(FolderPath6 + hourFormat.format(date2) + ".png"));
			}

		} catch (Exception e) {

			System.out.println("Fallo en la captura de evidencia.");

			e.printStackTrace();
		}

	}


	public void createAndSetTxt(Scenario scenario) throws IOException {

		File file = new File("C:\\Evidencia SGC CR\\Scenario.txt");

		if (file.exists()) {
			file.delete();
			file.createNewFile();
			FileWriter fw = new FileWriter("C:\\Evidencia SGC CR\\Scenario.txt");
			fw.write(scenario.getName());
			fw.close();

		} else {
			file.createNewFile();
			FileWriter fw = new FileWriter("C:\\Evidencia SGC CR\\Scenario.txt");
			fw.write(scenario.getName());
			fw.close();

		}
	}

	public static final String BLACK = "\u001B[30m";
	public static final String RED = "\u001B[31m";
	public static final String GREEN = "\u001B[32m";
	public static final String YELLOW = "\u001B[33m";
	public static final String BLUE = "\u001B[34m";
	public static final String PURPLE = "\u001B[35m";
	public static final String CYAN = "\u001B[36m";
	public static final String WHITE = "\u001B[37m";
	public static final String RESET = "\u001B[0m";
}
