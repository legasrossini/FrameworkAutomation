package br.gov.caixa.sipan.automacao.page.pessoaujridica;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import br.gov.caixa.sipan.automacao.core.BasePage;
import br.gov.caixa.sipan.automacao.core.EvidenceGenerator;

/**
* @see [Page]: Classe que representa a tela de Busca.
* @author Douglas Legas Rossini.
* @since 28/03/2019.
*/
public class BuscaPage extends BasePage {
	
	@FindBy(id = "idFormPrincipal:ns_Z7_10CI0JO0J0HBD0AGPO08AV30M6_j_id873721890_17dbcabe")
	private WebElement cnpjInput;

	@FindBy(id = "idFormPrincipal:ns_Z7_10CI0JO0J0HBD0AGPO08AV30M6_j_id873721890_17dbcaa3")
	private WebElement pesquisarCnpjButton;

	@FindBy(id = "idFormPrincipal:cmdLnkSim")
	private WebElement simCnpjButton;	


	public BuscaPage(WebDriver driver, EvidenceGenerator evidenceGenerator) {
		super(driver, evidenceGenerator);
	}
	
	/**
	* @see [Function]: Busca por um CNPJ no sistema.
	* @param cnpj a ser buscado.
	*/
	public void buscarCnpj(String cnpj) {
		waitForElement(cnpjInput);		
		cnpjInput.sendKeys(cnpj);
		logInfo("- Cnpj preenchido: " + cnpj);
		pesquisarCnpjButton.click();
		logInfo("- Botao de Pesquisa clicado", true);
		waitForElementEnabled(simCnpjButton);
		simCnpjButton.click();
	}

}
