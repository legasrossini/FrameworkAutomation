package br.gov.caixa.sipan.automacao.page.pessoafisica;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import br.gov.caixa.sipan.automacao.core.BasePage;
import br.gov.caixa.sipan.automacao.core.EvidenceGenerator;

/**
* @see [Page]: Classe que representa a tela de Dados Cadastrais.
* @author Douglas Legas Rossini.
* @since 28/03/2019.
*/
public class MeiosComunicacaoPage extends BasePage {

	@FindBy(id = "frmSipanPessoaFisica:finalidade_label")
	private WebElement finalidadeLabel;	
	@FindBy(xpath = "/html/body/div[39]/div/ul")
	private WebElement finalidadeUl;
	
	@FindBy(id = "frmSipanPessoaFisica:comunicacao_label")
	private WebElement meiosComunicacaoLabel;	
	@FindBy(xpath = "/html/body/div[40]/div/ul")
	private WebElement meiosComunicacaoUl;
	
	@FindBy(id = "frmSipanPessoaFisica:ddd")
	private WebElement dddInput;
	
	@FindBy(id = "frmSipanPessoaFisica:numeroTelefoneDadosCadastraisMeioComunicacao")
	private WebElement numeroInput;
	
	@FindBy(id = "frmSipanPessoaFisica:contato")
	private WebElement contatoInput;
	
	@FindBy(id = "frmSipanPessoaFisica:ns_Z7_H84629S0JOK5D0AG0MIL2E1006_j_id1017501706_69fd70a7")
	private WebElement propagandaCheckBox;
	
	@FindBy(id = "frmSipanPessoaFisica:ns_Z7_H84629S0JOK5D0AG0MIL2E1006_j_id1017501706_69fd70c1")
	private WebElement comunicacaoCheckBox;
	
	@FindBy(id = "frmSipanPessoaFisica:cmdBtnAlterarMeio")
	private WebElement salvarAlteracaoButton;
	
	@FindBy(id = "frmSipanPessoaFisica:cmdLnkProximo")
	private WebElement proximoButton;		
	
	public MeiosComunicacaoPage(WebDriver driver, EvidenceGenerator evidenceGenerator) {
		super(driver, evidenceGenerator);
	}
	
	public void preencherdadosDaRenda(String tipoRenda, String caracteristicaRenda, String tipoFontePagadora, String cpfOuCnpj) {
	}	
	
	/**
	* @see [Function]: Digita o valor do Cpf ou Cpj da Fonte Pagadora.
	* @param cpfOuCnpj a ser digitado.
	*/	
	public void digitarCpfCnpjFontePagadora(String cpfOuCnpj) {
		//waitForElement(fontePagadoraCpfCnpjInput);
		//sendKeysJs(cpfOuCnpj,fontePagadoraCpfCnpjInput);		
	}	
	
	/**
	* @see [Function]: Seleciona uma opção no campo de tipo de renda.
	* @param tipoRenda opção a ser escolhida.
	*/
	public void selecionarTipoRenda(String tipoRenda) {
		//waitForElementEnabled(tipoRendaLabel);
		//tipoRendaLabel.click();
		//WebElement tipoRendaLi = tipoRendaUl.findElement(By.xpath("//html/body/div[22]/div/ul/li[@data-label='"+tipoRenda+"']"));
		//tipoRendaLi.click();
	}
	
	/**
	* @see [Function]: Vai a próxima página.
	*/
	public void clicarProximo() {
		waitForElementEnabled(proximoButton);
		proximoButton.click();
	}
	
}
