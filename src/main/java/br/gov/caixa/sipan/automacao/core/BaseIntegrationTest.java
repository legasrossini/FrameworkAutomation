package br.gov.caixa.sipan.automacao.core;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.itextpdf.text.DocumentException;

@RunWith(SeleniumPageRunner.class)
public abstract class BaseIntegrationTest {

	public static final String BASE_URL_KEY = "selenium.url";
	public static final String APP_URL = "/wps/portal/sipan";
	
	public static String nome;
	private static WebDriver driver;
	private static String baseUrl;

	private static EvidenceGenerator evidenceGenerator = null;

	@BeforeClass
	public static void setUp() throws Throwable {
		initWebDriver();
		evidenceGenerator = new EvidenceGenerator(driver);
		baseUrl = getBaseUrl();		
	}

	@AfterClass
	public static void tearDown() {
		//driver.quit();
		closeDoc();
	}

	@Before
	public void before() {
		driver.get(baseUrl + APP_URL);
		logInfo("Acessando a url: " + baseUrl + APP_URL);
	}
	
	public final static void initWebDriver() {
		if (driver == null) {
			System.setProperty("webdriver.gecko.driver", "libs/geckodriver.exe");			
			driver = new FirefoxDriver();
			driver.manage().timeouts().implicitlyWait(180, TimeUnit.SECONDS);
			driver.manage().window().maximize();
		}
	}

	public WebDriver getDriver() {
		return driver;
	}

	public static String getBaseUrl() {
		return System.getProperty(BASE_URL_KEY, "http://10.116.84.116");
	}
	
	public void logInfo(String mensagem) {
		try {
			evidenceGenerator.logInfo(mensagem);
		} catch (IOException | DocumentException e) {
			e.printStackTrace();
		}
	}
	
	public void logInfo(String mensagem, Boolean tirarPrint) {
		try {
			evidenceGenerator.logInfo(mensagem, tirarPrint);
		} catch (IOException | DocumentException e) {
			e.printStackTrace();
		}
	}
	
	public void logError(String mensagem) {
		try {
			Thread.sleep(2000);
			evidenceGenerator.logError(mensagem);
		} catch (IOException | DocumentException | InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	public static void closeDoc() {
		EvidenceGenerator.doc.close();
	}

	public static EvidenceGenerator getEvidenceGenerator() {
		return evidenceGenerator;
	}

}
