package br.gov.caixa.sipan.automacao.page.pessoafisica;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import br.gov.caixa.sipan.automacao.core.BasePage;

/**
* @see [Page]: Classe que representa a tela de Busca.
* @author Douglas Legas Rossini.
* @since 28/03/2019.
*/
public class BuscaPage extends BasePage {
	
	@FindBy(id = "viewns_Z7_H84629S0JOK5D0AG0MIL2E1007_:idFormPrincipal:ns_Z7_H84629S0JOK5D0AG0MIL2E1007_j_id873721890_17dbca89")
	private WebElement cpfInput;

	@FindBy(id = "viewns_Z7_H84629S0JOK5D0AG0MIL2E1007_:idFormPrincipal:ns_Z7_H84629S0JOK5D0AG0MIL2E1007_j_id873721890_17dbcabe")
	private WebElement pesquisarCpfButton;

	@FindBy(id = "viewns_Z7_H84629S0JOK5D0AG0MIL2E1007_:idFormPrincipal:cmdLnkSim")
	private WebElement simCpfButton;

	public BuscaPage(WebDriver driver) {
		super(driver);
	}
	
	/**
	* @see [Function]: Busca por um CPF no sistema.
	* @param cpf a ser buscado.
	*/	
	public void buscarCpf(String cpf) {
		waitForElement(cpfInput);		
		cpfInput.sendKeys(cpf);
		logInfo("- Cpf preenchido: " + cpf);
		pesquisarCpfButton.click();
		logInfo("- Botao de Pesquisa clicado", true);
		waitForElementEnabled(simCpfButton);
		simCpfButton.click();
	}

}
