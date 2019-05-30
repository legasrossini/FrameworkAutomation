package br.gov.caixa.sipan.automacao.page.common;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import br.gov.caixa.sipan.automacao.core.BasePage;

/**
* @see [Page]: Classe que representa a tela de Menu.
* @author Douglas Legas Rossini.
* @since 28/03/2019.
*/
public class MenuPage extends BasePage {

	@FindBy(xpath = "/html/body/div[1]/div[3]/div/div/ul/li[5]/a")
	private WebElement pessoaJuridicaLink;	
	
	@FindBy(xpath = "/html/body/div[1]/div[3]/div/div/ul/li[3]/a")
	private WebElement pessoaFisicaLink;	

	public MenuPage(WebDriver driver) throws Throwable {
		super(driver);
	}
	
	/**
	* @see [Function]: Clica no menu superior de pessoa juridica.
	*/
	public void menuPessoaJuridica() {
		waitForElement(pessoaJuridicaLink);
		pessoaJuridicaLink.click();
		logInfo("- Menu pessoa juridica clicado.");
	}
	
	/**
	* @see [Function]: Clica no menu superior de pessoa fisica.
	*/
	public void menuPessoaFisica() {
		waitForElement(pessoaFisicaLink);
		pessoaFisicaLink.click();
		logInfo("- Menu pessoa fisica clicado.");
	}

}
