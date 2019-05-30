package br.gov.caixa.sipan.automacao.page.pessoaujridica;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import br.gov.caixa.sipan.automacao.core.BasePage;
import br.gov.caixa.sipan.automacao.core.EvidenceGenerator;

/**
* @see [Page]: Classe que representa a tela de Endereco.
* @author Douglas Legas Rossini.
* @since 28/03/2019.
*/
public class EnderecosPage extends BasePage {
	
	@FindBy(id = "idFormPrincipal:cmbTipoLogradouro_label")
	private WebElement tipoLogradouroLabel;
	
	@FindBy(xpath = "/html/body/div[23]/div[2]/ul")
	private WebElement tipoLogradouroUl;
	
	@FindBy(id = "idFormPrincipal:cmbTipoImovel_label")
	private WebElement tipoImovelLabel;
	
	@FindBy(xpath = "/html/body/div[26]/div/ul")
	private WebElement tipoImovelUl;
		
	@FindBy(id = "idFormPrincipal:cmbFinalidadeImovel_label")
	private WebElement finalidadeImovelLabel;
	
	@FindBy(xpath = "/html/body/div[27]/div/ul")
	private WebElement finalidadeImovelUl;
	
	@FindBy(id = "idFormPrincipal:cepCliente")
	private WebElement cepInput;
	
	@FindBy(id = "idFormPrincipal:numero")
	private WebElement numeroInput;
		
	@FindBy(id = "idFormPrincipal:complemento")
	private WebElement complementoInput;

	@FindBy(id = "idFormPrincipal:referencia")
	private WebElement referenciaInput;
		
	@FindBy(id = "idFormPrincipal:cmdLnkConsultaDadosCep")
	private WebElement consultarCepButton;
		
	@FindBy(id = "idFormPrincipal:cmdLnkProximo")
	private WebElement proximoButton;
	
	public EnderecosPage(WebDriver driver, EvidenceGenerator evidenceGenerator) {
		super(driver, evidenceGenerator);	
	}
	
	public void preencherEndereco(String cep, String tipologradouro, String numero, String complemento, String tipoImovel, String referencia, String finalidadeImovel) {
		digitarCep(cep);
		logInfo("- Cep preenchido: " + cep);
		clicarConsultarCep();
		logInfo("- Botao Consultar Cep clicado");
		selecionarTipoLogradouro(tipologradouro);
		logInfo("- Tipo de Logradouro selecionado: " + tipologradouro);
		digitarNumero(numero);
		logInfo("- Numero preenchido: " + numero);
		digitarComplemento(complemento);
		logInfo("- Complemento preenchido: " + complemento);
		selecionarTipoImovel(tipoImovel);
		logInfo("- Tipo de Imóvel selecionado: " + tipoImovel);
		digitarReferencia(referencia);
		logInfo("- Referencia preenchida: " + referencia);
		selecionarFinalidadeImovel(finalidadeImovel);
		logInfo("- Finalidade do Imóvel selecionada: " + finalidadeImovel,true);
		clicarProximo();
	}
	
	/**
	* @see [Function]: Seleciona uma opção no campo de tipo de logradouro.
	* @param tipoLogradouro opção a ser escolhida.
	*/	
	public void selecionarTipoLogradouro(String tipoLogradouro) {
		waitForElementEnabled(tipoLogradouroLabel);
		tipoLogradouroLabel.click();
		WebElement tipoLogradouroLi = tipoLogradouroUl.findElement(By.xpath("//li[@data-label='" + tipoLogradouro + "']"));
		tipoLogradouroLi.click();
	}
	
	/**
	* @see [Function]: Seleciona uma opção no campo de tipo de imovel.
	* @param tipoImovel opção a ser escolhida.
	*/
	public void selecionarTipoImovel(String tipoImovel) {
		waitForElementEnabled(tipoImovelLabel);
		tipoImovelLabel.click();
		WebElement tipoImovelLi = tipoImovelUl.findElement(By.xpath("//li[@data-label='" + tipoImovel + "']"));
		tipoImovelLi.click();
	}
	
	/**
	* @see [Function]: Seleciona uma opção no campo de finalidade imovel.
	* @param finalidadeImovel opção a ser escolhida.
	*/
	public void selecionarFinalidadeImovel(String finalidadeImovel) {
		waitForElementEnabled(finalidadeImovelLabel);
		finalidadeImovelLabel.click();
		WebElement finalidadeImovelLi = finalidadeImovelUl.findElement(By.xpath("//li[@data-label='" + finalidadeImovel + "']"));
		finalidadeImovelLi.click();
	}

	/**
	* @see [Function]: Digita o valor do cep.
	* @param cep a ser digitado.
	*/	
	public void digitarCep(String cep) {
		waitForElement(cepInput);
		sendKeysJs(cep, cepInput);
	}
	
	/**
	* @see [Function]: Digita o valor do numero da residencia.
	* @param numero a ser digitado.
	*/	
	public void digitarNumero(String numero) {
		waitForElementEnabled(numeroInput);
		numeroInput.sendKeys(numero);
	}
	
	/**
	* @see [Function]: Digita o valor do complemento da residencia.
	* @param complemento a ser digitado.
	*/	
	public void digitarComplemento(String complemento) {
		complementoInput.sendKeys(complemento);
	}
	
	/**
	* @see [Function]: Digita o valor da referencia da residencia.
	* @param referencia a ser digitado.
	*/	
	public void digitarReferencia(String referencia) {
		sendKeysJs(referencia, referenciaInput);
	}
	
	/**
	* @see [Function]: consulta endereço pelo cep.
	*/
	public void clicarConsultarCep() {
		consultarCepButton.click();
	}
	
	/**
	* @see [Function]: Vai a próxima página.
	*/
	public void clicarProximo() {
		proximoButton.click();
	}
	
}
