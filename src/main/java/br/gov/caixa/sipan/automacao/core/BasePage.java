package br.gov.caixa.sipan.automacao.core;

import java.io.IOException;
import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.Wait;

import com.itextpdf.text.DocumentException;

/**
 * Classe abstrata para expor metodos comuns a todas as telas testadas.
 * @author DSK004
 *
 */
public abstract class BasePage {
	
	public static final int DEFAULT_WAIT_IN_MILLIS = 2500;
	public static final int DEFAULT_TIMEOUT_IN_SECONDS = Integer.valueOf(System.getProperty("selenium.timeout.seconds", "60"));
	
	private EvidenceGenerator evidenceGenerator;
	BaseIntegrationTest baseIntegrationTest;

	private WebDriver driver;
	private Wait<WebDriver> wait;

	public BasePage(WebDriver driver, EvidenceGenerator evidenceGenerator) {
		this.driver = driver;
		this.evidenceGenerator = evidenceGenerator;
		
		this.wait = new FluentWait<WebDriver>(driver)  
                .withTimeout(Duration.ofSeconds(2))
                .pollingEvery(Duration.ofSeconds(2));
		
		LocalPageFactory.initElements(driver, this);
	}
	
	public WebElement findId(String id, String msg) {
		WebElement element = null;
		try {
			element = driver.findElement(By.id(id));
		} catch (Exception e){
			baseIntegrationTest.logError("Erro: "+ msg + " motivo: " + e.getMessage());
		}
		return element;
	}
	
	public WebElement findXpath(String xpath, String msg) {
		WebElement element = null;
		try {
			element = driver.findElement(By.xpath(xpath));
		} catch (Exception e){
			baseIntegrationTest.logError("Erro: "+ msg + " motivo: " + e.getMessage());		
		}
		return element;		
	}	
	
	/**
	 * Escreve no campo via javascript.
	 * @param texto
	 * @param objeto webdriver.
	 */
	public void sendKeysJs(String text, WebElement elementInput) {
		((JavascriptExecutor) driver).executeScript("arguments[0].value='"+text+"';", elementInput);
	}
	
	/**
	 * Escreve no campo via javascript.
	 * @param texto
	 * @param objeto webdriver.
	 */
	public void clickJs(WebElement elementForClick) {
		((JavascriptExecutor) driver).executeScript("arguments[0].click();", elementForClick);	
	}


	/**
	 * Espera por um tempo para continuar os testes.
	 * @param timeout
	 */
	public void waitFor(long timeout) {
		try {
			Thread.sleep(timeout);
		} catch (InterruptedException e) {}
	}

	/**
	 * Espera que um elemento esteja visivel na tela.
	 * @param element
	 */
	protected void waitForElement(WebElement element) {
		waitFor(DEFAULT_WAIT_IN_MILLIS);
		//wait.until(ExpectedConditions.visibilityOf(element));
	}

	/**
	 * Espera que um elemento esteja visivel na tela.
	 * @param element
	 */
	protected void waitForElement(WebElement element, int timeout) {
		waitFor(timeout);
		wait.until(ExpectedConditions.visibilityOf(element));
	}

	/**
	 * Espera que um elemento esteja visivel na tela.
	 * @param elementId
	 */
	protected void waitForElement(String elementId) {
		waitFor(DEFAULT_WAIT_IN_MILLIS);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(elementId)));
	}

	/**
	 * Espera que um elemento esteja presente na tela.
	 * @param element
	 */
	protected void waitForElementPresent(WebElement element) {
		waitFor(DEFAULT_WAIT_IN_MILLIS);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.id(element.getAttribute("id"))));
	}

	/**
	 * Espera que um elemento esteja habilitado na tela.
	 * @param element
	 */
	protected void waitForElementEnabled(WebElement element) {
		waitFor(DEFAULT_WAIT_IN_MILLIS);
		wait.until(ExpectedConditions.elementToBeClickable(element));
	}
	
	
	/**
	 * Espera que um elemento esteja habilitado na tela.
	 * @param element
	 */
	protected void waitForElementEnabled(WebElement element, int timeout) {
		waitFor(timeout);
		wait.until(ExpectedConditions.elementToBeClickable(element));
	}

	/**
	 * Espera que um elemento esteja habilitado na tela.
	 * @param element
	 */
	protected void waitForElementSelectable(WebElement element) {
		waitFor(DEFAULT_WAIT_IN_MILLIS);
		wait.until(ExpectedConditions.elementToBeSelected(element));
	}

	/**
	 * Espera que um select tenha seus options preenchidos.
	 * @param element
	 */
	protected void waitForOptions(WebElement element) {
		String id = element.getAttribute("id");
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//select[@id='" + id + "']/option[3]")));
	}

	/**
	 * Seleciona uma op��o do select pelo texto visivel.
	 * @param element
	 * @param value
	 */
	protected void selectOption(WebElement element, String value) {
		Select select = new Select(element);
		select.selectByVisibleText(value);
	}

	/**
	 * Seleciona uma op��o pelo �ndice.
	 * @param element
	 * @param indice
	 */
	protected void selectOptionByIndex(WebElement element, int index) {
		Select select = new Select(element);
		select.selectByIndex(index);
	}

	/**
	 * Seleciona a primeira op��o do select que contem o texto.
	 * @param element
	 * @param value
	 */
	protected void selectOptionContains(WebElement element, String value) {
		Select select = new Select(element);
		for (WebElement option : select.getOptions()) {
			if (option.getText().contains(value)) {
				select.selectByVisibleText(option.getText());
				break;
			}
		}
	}

	/**
	 * Seleciona a primeira op��o do select.
	 * @param element
	 */
	protected void selectFirstOption(WebElement element) {
		Select select = new Select(element);
		List<WebElement> options = new Select(element).getOptions();

		if (options.get(0).getText().isEmpty()) {
			select.selectByVisibleText(options.get(1).getText());
		} else {
			select.selectByVisibleText(options.get(0).getText());
		}
	}

	/**
	 * Espera at� que o texto esteja presente no elemento.
	 * @param element
	 * @param text
	 */
	protected void waitForTextPresent(WebElement element, String text) {
		wait.until(ExpectedConditions.textToBePresentInElement(element, text));
	}

	/**
	 * Usa o m�todo que vasculha todo o arquivo HTML.
	 *
	 * @param textoPresenca
	 *            - o texto que ser� procurado na tela
	 * @param msgErro
	 *            - caso n�o encontre, esta ser� a msg exibida via JUnit
	 *
	 * */
	public void verificarTextoPresenca(String textoPresenca, String msgErro,
			boolean isDeveriaExistirNaTela) {
		if (!isDeveriaExistirNaTela) {
			if (driver.getPageSource().contains(textoPresenca)) {
				throw new AssertionError(msgErro + ". O texto ["
						+ textoPresenca + "] foi localizado na tela.");
			}
		} else {
			if (!driver.getPageSource().contains(textoPresenca)) {
				throw new AssertionError(msgErro + ". O texto ["
						+ textoPresenca + "] n�o foi localizado na tela.");
			}
		}
	}

	/**
	 * Verificar a presen�a de um texto espec�fico no elemento da tela atrav�s
	 * de um identificador �nico.
	 *
	 * @param textoPresenca
	 *            - o texto que ser� procurado na tela
	 * @param elemento
	 *            - elemento DOM
	 * @param msgErro
	 *            - caso n�o encontre, esta ser� a msg exibida via JUnit
	 *
	 * */
	public void verificarTextoPresenca(String textoPresenca, By elemento,
			String msgErro) {
		final String valueDoElemento = driver.findElement(elemento).getText()
				.trim();

		if (!valueDoElemento.equals(textoPresenca)) {
			throw new AssertionError(msgErro + ". O texto [" + textoPresenca
					+ "] " + "n�o foi localizado, o elemento [" + elemento
					+ "] tem o value [" + valueDoElemento + "].");
		}

	}
	
	
	public void verificarTexto(String mensagemEsperada, WebElement elemento) {		
		 String mensagemRetornada = elemento.getText();			 
		 if (!mensagemEsperada.equals(mensagemRetornada)) {
			 throw new AssertionError(mensagemRetornada + " não é igual a " + mensagemEsperada);
		 }
	}

	/**
	 * Verifica o texto em um elemento espec�fico.
	 * @param textoPresenca
	 * @param elemento
	 * @param msgErro
	 */
	public void verificarTextoPresenca(String textoPresenca, WebElement elemento,
			String msgErro) {
		final String valueDoElemento = elemento.getText()
				.trim();

		if (!valueDoElemento.equals(textoPresenca)) {
			throw new AssertionError(msgErro + ". O texto [" + textoPresenca
					+ "] " + "n�o foi localizado, o elemento [" + elemento
					+ "] tem o value [" + valueDoElemento + "].");
		}

	}

	/**
	 * @param textoPresenca
	 */
	public void verificarResultadoProcessamento(String textoPresenca) {
		waitFor(5000);
		verificarTextoPresenca(textoPresenca, "Erro valida��o campo", true);
	}

	/**
	 * @param msg
	 */
	public void verificarMsgAlertErroViaContains(String msg) {
		waitFor(DEFAULT_WAIT_IN_MILLIS);
		verificarTextoPresenca(msg, "Erro valida��o msg campo  [" + msg + "]",
				true);
	}

	/**
	 * @param msg
	 */
	public void verificarMsgAlertErroViaElemento(String msg) {
		waitFor(DEFAULT_WAIT_IN_MILLIS);
		verificarTextoPresenca(
				msg, By.className("errormsg"), "Erro valida��o msg campo  [" + msg + "]");
	}

	/**
	 * Clica no alerta do browser.
	 */
	public void clickAlertOk() {
		 driver.switchTo().alert().accept();
	}

	public WebDriver getDriver() {
		return driver;
	}

	public void setDriver(WebDriver driver) {
		this.driver = driver;
	}

	public Wait<WebDriver> getWait() {
		return wait;
	}

	public void setWait(Wait<WebDriver> wait) {
		this.wait = wait;
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

}
