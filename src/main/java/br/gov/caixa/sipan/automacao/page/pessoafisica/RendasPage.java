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
public class RendasPage extends BasePage {

	@FindBy(id = "frmSipanPessoaFisica:cmbTpRenda_label")
	private WebElement tipoRendaLabel;	
	@FindBy(xpath = "/html/body/div[22]/div/ul")
	private WebElement tipoRendaUl;
	
	@FindBy(id = "frmSipanPessoaFisica:cmbTpCaracteristicasRenda_label")
	private WebElement caracteristicaRendaLabel;	
	@FindBy(xpath = "/html/body/div[23]/div/ul")
	private WebElement caracteristicaRendaUl;
	
	@FindBy(id = "frmSipanPessoaFisica:cmbTpFontePagadora_label")
	private WebElement tipoFontePagadoraLabel;	
	@FindBy(xpath = "/html/body/div[24]/div/ul")
	private WebElement tipoFontePagadoraUl;
	
	@FindBy(id = "frmSipanPessoaFisica:cpfCnpjFontePagadora")
	private WebElement fontePagadoraCpfCnpjInput;
	
	@FindBy(id = "frmSipanPessoaFisica:cmdLnkConsultaFontePagadora")
	private WebElement consultarButton;
	
	@FindBy(id = "frmSipanPessoaFisica:cmbTpOcupacaoFormal_label")
	private WebElement tipoOcupacaoLabel;	
	@FindBy(xpath = "/html/body/div[22]/div[2]/ul")
	private WebElement tipoOcupacaoUl;
	
	@FindBy(id = "frmSipanPessoaFisica:dtAdmissaoDia")
	private WebElement dataAdmissaoDiaInput;	
	@FindBy(id = "frmSipanPessoaFisica:dtAdmissaoMes")
	private WebElement dataAdmissaoMesInput;	
	@FindBy(id = "frmSipanPessoaFisica:dtAdmissaoAno")
	private WebElement dataAdmissaoAnoInput;
	
	@FindBy(id = "frmSipanPessoaFisica:dtDeligamentoDia")
	private WebElement dataDesligamentoDiaInput;	
	@FindBy(id = "frmSipanPessoaFisica:dtDeligamentoMes")
	private WebElement dataDesligamentoMesInput;	
	@FindBy(id = "frmSipanPessoaFisica:dtDeligamentoAno")
	private WebElement dataDesligamentoAnoInput;
	
	@FindBy(id = "frmSipanPessoaFisica:inputRendaBruta")
	private WebElement rendaBrutaInput;
	
	@FindBy(id = "frmSipanPessoaFisica:inputRendaLiq")
	private WebElement rendaLiquidaInput;
	
	@FindBy(id = "frmSipanPessoaFisica:inputAnosEmpAnterior")
	private WebElement tempoEmpregoAnteriorAnosInput;
	
	@FindBy(id = "frmSipanPessoaFisica:inputMesesEmpAnterior")
	private WebElement tempoEmpregoAnteriorMesesInput;
	
	@FindBy(id = "frmSipanPessoaFisica:idAnoMesRef")
	private WebElement mesAnoReferenciaInput;
	
	@FindBy(id = "frmSipanPessoaFisica:anoDesligamentoEmpAnterior")
	private WebElement anoDesligamentoAnteriorInput;
	
	@FindBy(id = "frmSipanPessoaFisica:valorIRRF")
	private WebElement valorImpostoRetidoInput;
	
	@FindBy(id = "frmSipanPessoaFisica:ns_Z7_H84629S0JOK5D0AG0MIL2E1006_j_id473046794_e2f81e8_label")
	private WebElement comprovanteRendaLabel;	
	@FindBy(xpath = "/html/body/div[22]/div/ul")
	private WebElement comprovanteRendaUl;	
	
	@FindBy(id = "frmSipanPessoaFisica:cmdLnkSalvarRenda")
	private WebElement salvarRendaButton;
	
	@FindBy(id = "frmSipanPessoaFisica:cmdLnkProximo")
	private WebElement proximoButton;
	
	public RendasPage(WebDriver driver) {
		super(driver);		
	}
	
	public void preencherRenda(String tipoRenda, String caracteristicaRenda, String tipoFontePagadora, String cpfOuCnpj) {
		selecionarTipoRenda(tipoRenda);
		selecionarCaracteristicaRenda(caracteristicaRenda);
		selecionarTipoFontePagadora(tipoFontePagadora);
		digitarCpfCnpjFontePagadora(cpfOuCnpj);
		clicarConsultar();
	}
	
	public void preencherOcupacao(String tipoOcupacaoRendas, String dataAdmissaoDia, String dataAdmissaoMes, String dataAdmissaoAno, 
			String rendaBruta, String rendaLiquida, String mesAnoReferencia, String comprovanteRenda) {
		selecionarTipoOcupacao(tipoOcupacaoRendas);
		digitarDataAdmissaoDia(dataAdmissaoDia);
		digitarDataAdmissaoMes(dataAdmissaoMes);
		digitarDataAdmissaoAno(dataAdmissaoAno);
		digitarRendaBruta(rendaBruta);
		digitarRendaLiquida(rendaLiquida);
		digitarMesAnoReferencia(mesAnoReferencia);
		selecionarComprovanteRenda(comprovanteRenda);
		clicarSalvar();
		clicarProximo();
	}
	
	/**
	* @see [Function]: Seleciona uma opção no campo de tipo de renda.
	* @param tipoRenda opção a ser escolhida.
	*/
	public void selecionarTipoRenda(String tipoRenda) {
		waitForElementEnabled(tipoRendaLabel);
		tipoRendaLabel.click();
		WebElement tipoRendaLi = tipoRendaUl.findElement(By.xpath("//html/body/div[22]/div/ul/li[@data-label='"+tipoRenda+"']"));
		tipoRendaLi.click();
	}
	
	/**
	* @see [Function]: Seleciona uma opção no campo de Caracteristica de Renda.
	* @param caracteristicaRenda opção a ser escolhida.
	*/
	public void selecionarCaracteristicaRenda(String caracteristicaRenda) {
		waitForElementEnabled(caracteristicaRendaLabel);
		caracteristicaRendaLabel.click();
		WebElement caracteristicaRendaLi = caracteristicaRendaUl.findElement(By.xpath("//li[@data-label='"+caracteristicaRenda+"']"));
		caracteristicaRendaLi.click();
	}
	
	/**
	* @see [Function]: Seleciona uma opção no campo de Tipo de Fonte Pagadora.
	* @param tipoFontePagadora opção a ser escolhida.
	*/
	public void selecionarTipoFontePagadora(String tipoFontePagadora) {
		waitForElementEnabled(tipoFontePagadoraLabel);
		tipoFontePagadoraLabel.click();
		WebElement tipoFontePagadoraLi = tipoFontePagadoraUl.findElement(By.xpath("//li[@data-label='"+tipoFontePagadora+"']"));
		tipoFontePagadoraLi.click();
	}
	
	/**
	* @see [Function]: Digita o valor do Cpf ou Cpj da Fonte Pagadora.
	* @param cpfOuCnpj a ser digitado.
	*/	
	public void digitarCpfCnpjFontePagadora(String cpfOuCnpj) {
		waitForElement(fontePagadoraCpfCnpjInput);
		sendKeysJs(cpfOuCnpj,fontePagadoraCpfCnpjInput);		
	}
	
	/**
	* @see [Function]: Consultar Cpf ou Cnpj da Fonte Pagadora.
	*/
	public void clicarConsultar() {
		consultarButton.click();
	}
	
	/**
	* @see [Function]: Seleciona uma opção no campo de Tipo de Ocupação.
	* @param tipoOcupacao opção a ser escolhida.
	*/
	public void selecionarTipoOcupacao(String tipoOcupacaoRendas) {
		waitForElementEnabled(tipoOcupacaoLabel);
		tipoOcupacaoLabel.click();
		WebElement tipoOcupacaoLi = tipoOcupacaoUl.findElement(By.xpath("//html/body/div[26]/div[2]/ul//li[@data-label='"+tipoOcupacaoRendas+"']"));
		tipoOcupacaoLi.click();
	}
	
	/**
	* @see [Function]: Digita o valor do dia data de Admissao.
	* @param dataAdmissaoDia a ser digitado.
	*/	
	public void digitarDataAdmissaoDia(String dataAdmissaoDia) {
		waitForElement(dataAdmissaoDiaInput);
		sendKeysJs(dataAdmissaoDia,dataAdmissaoDiaInput);		
	}
	
	/**
	* @see [Function]: Digita o valor do mês data de Admissao.
	* @param dataAdmissaoMes a ser digitado.
	*/	
	public void digitarDataAdmissaoMes(String dataAdmissaoMes) {
		waitForElement(dataAdmissaoMesInput);
		sendKeysJs(dataAdmissaoMes,dataAdmissaoMesInput);	
	}
	
	/**
	* @see [Function]: Digita o valor do ano da data de Admissao.
	* @param dataAdmissaoAno a ser digitado.
	*/	
	public void digitarDataAdmissaoAno(String dataAdmissaoAno) {
		waitForElement(dataAdmissaoAnoInput);
		sendKeysJs(dataAdmissaoAno,dataAdmissaoAnoInput);
	}

	/**
	* @see [Function]: Digita o valor do dia data de Desligamento.
	* @param dataDesligamentoDia a ser digitado.
	*/	
	public void digitarDataDesligamentoDia(String dataDesligamentoDia) {
		waitForElement(dataDesligamentoDiaInput);
		sendKeysJs(dataDesligamentoDia,dataDesligamentoDiaInput);		
	}
	
	/**
	* @see [Function]: Digita o valor do mês data de Desligamento.
	* @param dataDesligamentoMes a ser digitado.
	*/	
	public void digitarDataDesligamentoMes(String dataDesligamentoMes) {
		waitForElement(dataDesligamentoMesInput);
		sendKeysJs(dataDesligamentoMes,dataDesligamentoMesInput);	
	}
	
	/**
	* @see [Function]: Digita o valor do ano da data de Desligamento.
	* @param dataDesligamentoAno a ser digitado.
	*/	
	public void digitarDataDesligamentAno(String dataDesligamentoAno) {
		waitForElement(dataDesligamentoAnoInput);
		sendKeysJs(dataDesligamentoAno,dataDesligamentoAnoInput);	
	}
	
	/**
	* @see [Function]: Digita o valor do da Renda Bruta.
	* @param rendaBruta a ser digitado.
	*/	
	public void digitarRendaBruta (String rendaBruta) {
		waitForElement(rendaBrutaInput);
		rendaBrutaInput.sendKeys(rendaBruta);	
	}
	
	/**
	* @see [Function]: Digita o valor do da Renda Liquida.
	* @param rendaLiquida a ser digitado.
	*/	
	public void digitarRendaLiquida (String rendaLiquida) {
		waitForElement(rendaLiquidaInput);
		rendaLiquidaInput.sendKeys(rendaLiquida);	
	}

	/**
	* @see [Function]: Digita o valor de Ano do Tempo no Emprego Interior.
	* @param tempoEmpregoAnteriorAnos a ser digitado.
	*/	
	public void digitarTempoEmpregoAnteriorAnos(String tempoEmpregoAnteriorAnos) {
		waitForElement(tempoEmpregoAnteriorAnosInput);
		sendKeysJs(tempoEmpregoAnteriorAnos,tempoEmpregoAnteriorAnosInput);	
	}
	
	/**
	* @see [Function]: Digita o valor de Meses do Tempo no Emprego Interior.
	* @param tempoEmpregoAnteriorMeses a ser digitado.
	*/	
	public void digitarTempoEmpregoAnteriorMeses(String tempoEmpregoAnteriorMeses) {
		waitForElement(tempoEmpregoAnteriorMesesInput);
		sendKeysJs(tempoEmpregoAnteriorMeses,tempoEmpregoAnteriorMesesInput);	
	}
	
	/**
	* @see [Function]: Digita o valor de Mês e Ano de Referência.
	* @param mesAnoReferencia a ser digitado.
	*/	
	public void digitarMesAnoReferencia(String mesAnoReferencia) {
		waitForElement(mesAnoReferenciaInput);
		sendKeysJs(mesAnoReferencia, mesAnoReferenciaInput);	
	}	

	/**
	* @see [Function]: Digita o valor do Ano de Desligamento do Emprego Anterior.
	* @param anoDesligamentoAnterior a ser digitado.
	*/	
	public void digitarAnoDesligamentoAnterior(String anoDesligamentoAnterior) {
		waitForElement(anoDesligamentoAnteriorInput);
		anoDesligamentoAnteriorInput.sendKeys(anoDesligamentoAnterior);	
	}
	
	/**
	* @see [Function]: Digita o valor do Imposto de Renda Retido na Fonte.
	* @param valorImpostoRetido a ser digitado.
	*/	
	public void digitarValorImpostoRetido(String valorImpostoRetido) {
		waitForElement(valorImpostoRetidoInput);
		valorImpostoRetidoInput.sendKeys(valorImpostoRetido);	
	}
	
	/**
	* @see [Function]: Seleciona uma opção no campo de Comprovante de Renda.
	* @param comprovanteRenda opção a ser escolhida.
	*/
	public void selecionarComprovanteRenda(String comprovanteRenda) {		
		comprovanteRendaLabel.click();
		WebElement comprovanteRendaLi = comprovanteRendaUl.findElement(By.xpath("//html/body/div[27]/div/ul/li[@data-label='"+comprovanteRenda+"']"));
		comprovanteRendaLi.click();
	}
	
	/**
	* @see [Function]: Vai a próxima página.
	*/
	public void clicarSalvar() {
		salvarRendaButton.click();
	}
	
	/**
	* @see [Function]: Vai a próxima página.
	*/
	public void clicarProximo() {
		waitForElementEnabled(proximoButton);
		proximoButton.click();
	}
	
}
