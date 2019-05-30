package br.gov.caixa.sipan.automacao.page.common;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import br.gov.caixa.sipan.automacao.core.BasePage;
import br.gov.caixa.sipan.automacao.core.EvidenceGenerator;

/**
* @see [Page]: Classe que representa a tela de Login.
* @author Douglas Legas Rossini.
* @since 28/03/2019.
*/
public class LoginPage extends BasePage {

	@FindBy(id = "userID")
	private WebElement usernameInput;

	@FindBy(id = "password")
	private WebElement passwordInput;

	@FindBy(id = "login.button.login")
	private WebElement loginButton;

	/**
	 *
	 * @param driver
	 * @throws Throwable 
	 */
	public LoginPage(WebDriver driver, EvidenceGenerator evidenceGenerator) throws Throwable {
		super(driver, evidenceGenerator);
	}

	/**
	* @see [Function]: Realiza login no sistema.
	* @param login nome de usuario
	* @param senha senha de usuario
	*/
	public void logar(String login, String senha) {
		waitForElement(usernameInput);
		usernameInput.sendKeys(login);
		logInfo("- Login preenchido: " + login);
		passwordInput.sendKeys(senha);
		logInfo("- Senha preenchida: " + senha, true);
		loginButton.click();
	}

}
