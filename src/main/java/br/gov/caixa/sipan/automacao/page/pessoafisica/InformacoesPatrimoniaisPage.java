package br.gov.caixa.sipan.automacao.page.pessoafisica;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import br.gov.caixa.sipan.automacao.core.BasePage;

/**
* @see [Page]: Classe que representa a tela de Dados Cadastrais.
* @author Douglas Legas Rossini.
* @since 28/03/2019.
*/
public class InformacoesPatrimoniaisPage extends BasePage {
	
	@FindBy(id = "frmSipanPessoaFisica:idPnlRadioTpPatrimonio")
	private WebElement patrimonioConsolidadoRadioButton;
	
	@FindBy(id = "frmSipanPessoaFisica:inputTotalPatrimonioConsolidado")
	private WebElement valorExpressoInput;
	
	@FindBy(id = "frmSipanPessoaFisica:cmdLnkProximo")
	private WebElement proximoButton;	
	
	public InformacoesPatrimoniaisPage(WebDriver driver) {
		super(driver);
	}
	
	public void preencherdadosDaRenda(String tipoRenda, String caracteristicaRenda, String tipoFontePagadora, String cpfOuCnpj) {
	}	
	
	/**
	* @see [Function]: Clica no Radio Button Patrimônio Consolidado.
	* @param patrimonioConsolidadoRadioButton a ser clicado.
	*/	
	public void clicarPatrimonioConsolidado() {
		patrimonioConsolidadoRadioButton.click();
	}	
	
	/**
	* @see [Function]: Digita um valor no campo de Total Expresso.
	* @param valorExpresso valor Total Expresso do Patrimônio Consolidado.
	*/
	public void selecionarTipoRenda(String valorExpresso) {
		sendKeysJs(valorExpresso, valorExpressoInput);
	}
	
	/**
	* @see [Function]: Vai a próxima página.
	*/
	public void clicarProximo() {
		waitForElementEnabled(proximoButton);
		proximoButton.click();
	}
	
}
