package br.gov.caixa.sipan.automacao.page.pessoafisica;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import br.gov.caixa.sipan.automacao.core.BasePage;

/**
* @see [Page]: Classe que representa a tela de Dados Cadastrais.
* @author Douglas Legas Rossini.
* @since 28/03/2019.
*/
public class EnderecosPage extends BasePage {

	@FindBy(id = "frmSipanPessoaFisica:cepCliente")
	private WebElement cepInput;
	
	@FindBy(id = "frmSipanPessoaFisica:cmdLnkConsultaDadosCep")
	private WebElement consultarCepButton;

	@FindBy(id = "frmSipanPessoaFisica:cmbTipoLogradouro_label")
	private WebElement tipoLogradouroLabel;	
	@FindBy(xpath = "/html/body/div[32]/div[2]/ul")
	private WebElement tipoLogradouroUl;
	
	@FindBy(id = "frmSipanPessoaFisica:logradouro")
	private WebElement logradouroInput;	
	
	@FindBy(id = "frmSipanPessoaFisica:numeroDadosCadastraisEndereco")
	private WebElement numeroInput;
	
	@FindBy(id = "frmSipanPessoaFisica:complemento")
	private WebElement complementoInput;
	
	@FindBy(id = "frmSipanPessoaFisica:bairro")
	private WebElement bairroInput;
	
	@FindBy(id = "frmSipanPessoaFisica:cmbTipoImovel_label")
	private WebElement tipoImovelLabel;	
	@FindBy(xpath = "/html/body/div[35]/div/ul")
	private WebElement tipoImovelUl;
	
	@FindBy(id = "frmSipanPessoaFisica:cmbOcupacaoImovel_label")
	private WebElement ocupacaoImovelLabel;	
	@FindBy(xpath = "/html/body/div[36]/div/ul")
	private WebElement ocupacaoImovelUl;
	
	@FindBy(id = "frmSipanPessoaFisica:correspondencia")
	private WebElement correspondenciaCheckBox;
	
	@FindBy(id = "frmSipanPessoaFisica:propaganda")
	private WebElement propagandaCheckBox;
	
	@FindBy(id = "frmSipanPessoaFisica:referencia")
	private WebElement dataReferenciaInput;
	
	@FindBy(id = "frmSipanPessoaFisica:cmdLnkProximo")
	private WebElement proximoButton;	
	
	public EnderecosPage(WebDriver driver) {
		super(driver);
	}
	
	public void preencherEndereco(String cep, String numero, String complemento, String tipoImovel, String ocupacaoImovel, String dataReferencia) {
		digitarCep(cep);
		clicarConsultarCep();
		digitarNumero(numero);
		digitarComplemento(complemento);
		selecionarTipoImovel(tipoImovel);
		selecionarOcupacaoImovel(ocupacaoImovel);
		digitarDataReferencia(dataReferencia);
		clicarCorrespondencia();
		clicarPropaganda();
		clicarProximo();
	}	
	
	/**
	* @see [Function]: Digita o valor Cep a ser buscado.
	* @param cep a ser digitado.
	*/	
	public void digitarCep(String cep) {
		waitForElement(cepInput);
		sendKeysJs(cep,cepInput);		
	}
	
	/**
	* @see [Function]: Clica no botão Consultar Cep.
	*/
	public void clicarConsultarCep() {
		consultarCepButton.click();
	}
	
	/**
	* @see [Function]: Seleciona uma opção no campo de Tipo de Logradouro.
	* @param tipoLogradouro opção a ser escolhida.
	*/
	public void selecionarTipoLogradouro(String tipoLogradouro) {
		tipoLogradouroLabel.click();
		WebElement tipoLogradouroLi = tipoLogradouroUl.findElement(By.xpath("//li[@data-label='"+tipoLogradouro+"']"));
		tipoLogradouroLi.click();
	}
	
	/**
	* @see [Function]: Digita o Número da Residencia.
	* @param numero a ser digitado.
	*/	
	public void digitarNumero(String numero) {
		numeroInput.sendKeys(numero);
	}
	
	/**
	* @see [Function]: Digita o Complemento do Endereço.
	* @param complemento a ser digitado.
	*/	
	public void digitarComplemento(String complemento) {
		complementoInput.sendKeys(complemento);
	}
	
	/**
	* @see [Function]: Seleciona uma opção no campo de Tipo de Imovel.
	* @param tipoImovel opção a ser escolhida.
	*/
	public void selecionarTipoImovel(String tipoImovel) {
		tipoImovelLabel.click();
		WebElement tipoImovelLi = tipoImovelUl.findElement(By.xpath("//li[@data-label='"+tipoImovel+"']"));
		tipoImovelLi.click();
	}
	
	/**
	* @see [Function]: Seleciona uma opção no campo de Ocupação do Imóvel.
	* @param ocupacaoImovel opção a ser escolhida.
	*/
	public void selecionarOcupacaoImovel(String ocupacaoImovel) {
		ocupacaoImovelLabel.click();
		WebElement ocupacaoImovelLi = ocupacaoImovelUl.findElement(By.xpath("//li[@data-label='"+ocupacaoImovel+"']"));
		ocupacaoImovelLi.click();
	}
	
	/**
	* @see [Function]: Digita a Data de Referência.
	* @param dataReferencia a ser digitado.
	*/	
	public void digitarDataReferencia(String dataReferencia) {
		sendKeysJs(dataReferencia, dataReferenciaInput);
	}
	
	/**
	* @see [Function]: Clica no CheckBox Correspondencia.
	*/
	public void clicarCorrespondencia() {
		correspondenciaCheckBox.click();
	}
	
	/**
	* @see [Function]: Clica no CheckBox Propaganda.
	*/
	public void clicarPropaganda() {
		propagandaCheckBox.click();
	}
	
	/**
	* @see [Function]: Vai a próxima página.
	*/
	public void clicarProximo() {
		waitForElementEnabled(proximoButton);
		proximoButton.click();
	}
	
}
