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
public class DadosCadastraisPage extends BasePage {

	@FindBy(id = "frmSipanPessoaFisica:cmbSexo_label")
	private WebElement sexoLabel;	
	@FindBy(xpath = "/html/body/div[7]/div/ul")
	private WebElement sexoUl;
	
	@FindBy(id = "frmSipanPessoaFisica:cmbTipoNaturalidade_label")
	private WebElement tipoNaturalidadeLabel;	
	@FindBy(xpath = "/html/body/div[9]/div/ul")
	private WebElement tipoNaturalidadeUl;
	
	@FindBy(id = "frmSipanPessoaFisica:cmbNaturalidade_label")
	private WebElement naturalidadeLabel;	
	@FindBy(xpath = "/html/body/div[9]/div[2]/ul")
	private WebElement naturalidadeUl;

	@FindBy(id = "frmSipanPessoaFisica:cmbNaturalidadeMunicipio_label")
	private WebElement municipioLabel;	
	@FindBy(xpath = "/html/body/div[15]/div[2]/ul")
	private WebElement municipioUl;
	
	@FindBy(id = "frmSipanPessoaFisica:cmbGrauInstrucao_label")
	private WebElement grauIntrucaoLabel;	
	@FindBy(xpath = "/html/body/div[10]/div/ul")
	private WebElement grauIntrucaoUl;
	
	@FindBy(id = "frmSipanPessoaFisica:cmbTipoOcupacao_label")
	private WebElement tipoOcupacaoLabel;	
	@FindBy(xpath = "/html/body/div[11]/div/ul")
	private WebElement tipoOcupacaoUl;
	
	@FindBy(id = "frmSipanPessoaFisica:cmbOcupacaoFormal_label")
	private WebElement principalOcupacaoLabel;	
	@FindBy(xpath = "/html/body/div[17]/div[2]/ul")
	private WebElement principalOcupacaoUl;
	
	@FindBy(id = "frmSipanPessoaFisica:cmbDocumentoIdentificacao_label")
	private WebElement documentoIdentificacaoLabel;	
	@FindBy(xpath = "/html/body/div[13]/div/ul")
	private WebElement documentoIdentificacaoUl;
	
	@FindBy(id = "frmSipanPessoaFisica:cmbTpDocumento_label")
	private WebElement tipoDocumentoLabel;	
	@FindBy(xpath = "/html/body/div[18]/div/ul")
	private WebElement tipoDocumentoUl;
	
	@FindBy(id = "frmSipanPessoaFisica:inputNrDoc")
	private WebElement numeroDocumentoInput;
	
	@FindBy(id = "frmSipanPessoaFisica:dtEmissaoDia")
	private WebElement dataEmissaoDiaInput;	
	@FindBy(id = "frmSipanPessoaFisica:dtEmissaoMes")
	private WebElement dataEmissaoMesInput;	
	@FindBy(id = "frmSipanPessoaFisica:dtEmissaoAno")
	private WebElement dataEmissaoAnoInput;
		
	@FindBy(id = "frmSipanPessoaFisica:cmdBtnAlterarDoc")
	private WebElement incluirButton;
	
	@FindBy(id = "frmSipanPessoaFisica:cmbOrgaoEmissor_label")
	private WebElement orgaoEmissorLabel;	
	@FindBy(xpath = "/html/body/div[19]/div/ul")
	private WebElement orgaoEmissorUl;
	
	@FindBy(id = "frmSipanPessoaFisica:cmbDocumentoUF_label")
	private WebElement documentoUfLabel;	
	@FindBy(xpath = "/html/body/div[20]/div/ul")
	private WebElement documentoUfUl;
	
	@FindBy(id = "frmSipanPessoaFisica:cmbEstadoCivil_label")
	private WebElement estadoCivilLabel;	
	@FindBy(xpath = "/html/body/div[19]/div/ul")
	private WebElement estadoCivilUl;
	
	@FindBy(id = "frmSipanPessoaFisica:cpfConjuge")
	private WebElement cpfConjugeInput;
	
	@FindBy(id = "frmSipanPessoaFisica:cmdLnkConsultaDadosReceitaConjuge")
	private WebElement consultarConjugeButton;	
	
	@FindBy(id = "frmSipanPessoaFisica:cmdLnkProximo")
	private WebElement proximoButton;	

	public DadosCadastraisPage(WebDriver driver) {
		super(driver);		
	}
	
	public void preencherDadosCadastrais(String sexo, String naturalidade, String municipio,  String grauIntrucao,  String tipoOcupacao,  
			String principalOcupacao) {		
		selecionarSexo(sexo);
		logInfo("- Sexo selecionado: " + sexo);		
		selecionarNaturalidade(naturalidade);
		logInfo("- Naturalidade selecionada: " + naturalidade);		
		selecionarMunicipio(municipio);
		logInfo("- Municipio selecionado: " + municipio);		
		selecionarGrauIntrucao(grauIntrucao);
		logInfo("- Grau de Instrução selecionado: " + grauIntrucao);		
		selecionarTipoOcupacao(tipoOcupacao);
		logInfo("- Tipo Ocupacao selecionado: " + tipoOcupacao);
		selecionarPrincipalOcupacao(principalOcupacao);
		logInfo("- Principal Ocupacao selecionada: " + principalOcupacao);
	}
	
	public void preencherDadosCadastraisDocumentosIdentificacao(String documentoIdentificacao, String tipoDocumento, String numeroDocumento,  
			String dataEmissaoDia,  String dataEmissaoMes, String dataEmissaoAno, String orgaoEmissor, String documentoUf) {		
		selecionarDocumentoIdentificacao(documentoIdentificacao);
		logInfo("- Documento de Indentificação selecionado: " + documentoIdentificacao);	
		selecionarTipoDocumento(tipoDocumento);
		logInfo("- Tipo de Documento de Indentificação selecionado: " + tipoDocumento);	
		digitarNumeroDocumento(numeroDocumento);
		logInfo("- Numero do Documento preenchido: " + numeroDocumento);
		digitarDataEmissaoDia(dataEmissaoDia);
		digitarDataEmissaoMes(dataEmissaoMes);
		digitarDataEmissaoAno(dataEmissaoAno);
		logInfo("- Data de Emissão preenchida: " + dataEmissaoDia+"/"+dataEmissaoMes+"/"+dataEmissaoAno);
		selecionarOrgaoEmissor(orgaoEmissor);
		logInfo("- Orgão Emissor selecionado: " + orgaoEmissor);	
		selecionarDocumentoUf(documentoUf);
		logInfo("- UF do Documento selecionada: " + documentoUf, true);
		clicarIncluir();
	}
	
	public void preencherDadosCadastraisConjuge(String estadoCivil, String cpfConjuge) {
		selecionarEstadoCivil(estadoCivil);
		logInfo("- Estado Civil selecionado: " + estadoCivil);
		digitarCpfConjuge(cpfConjuge);
		logInfo("-CPF do Conguje preenchido: " + cpfConjuge);
		clicarConultarConjuge();
		logInfo("- Botao de Consultar Conjuge clicado", true);
		clicarProximo();
	}
	
	/**
	* @see [Function]: Seleciona uma opção no campo de sexo.
	* @param sexo opção a ser escolhida.
	*/
	public void selecionarSexo(String sexo) {
		waitForElementEnabled(sexoLabel);
		sexoLabel.click();
		WebElement sexoLi = sexoUl.findElement(By.xpath("//li[@data-label='"+sexo+"']"));
		sexoLi.click();
	}
	
	/**
	* @see [Function]: Seleciona uma opção no campo de naturalidade.
	* @param naturalidade opção a ser escolhida.
	*/
	public void selecionarNaturalidade(String naturalidade) {
		naturalidadeLabel.click();
		WebElement naturalidadeLi = naturalidadeUl.findElement(By.xpath("//html/body/div[9]/div[2]/ul/li[@data-label='"+naturalidade+"']"));
		naturalidadeLi.click();
	}
	
	/**
	* @see [Function]: Seleciona uma opção no campo de municipio.
	* @param municipio opção a ser escolhida.
	*/
	public void selecionarMunicipio(String municipio) {
		waitForElementEnabled(municipioLabel);
		municipioLabel.click();
		WebElement municipioLi = municipioUl.findElement(By.xpath("//li[@data-label='"+municipio+"']"));
		municipioLi.click();
	}
	
	/**
	* @see [Function]: Seleciona uma opção no campo de Grau de Intrucao.
	* @param grauIntrucao opção a ser escolhida.
	*/
	public void selecionarGrauIntrucao(String grauIntrucao) {
		grauIntrucaoLabel.click();
		WebElement grauIntrucaoLi = grauIntrucaoUl.findElement(By.xpath("//li[@data-label='"+grauIntrucao+"']"));
		grauIntrucaoLi.click();
	}
	
	/**
	* @see [Function]: Seleciona uma opção no campo de Tipo Ocupação.
	* @param tipoOcupacao opção a ser escolhida.
	*/
	public void selecionarTipoOcupacao(String tipoOcupacao) {
		tipoOcupacaoLabel.click();
		WebElement tipoOcupacaoLi = grauIntrucaoUl.findElement(By.xpath("//li[@data-label='"+tipoOcupacao+"']"));
		tipoOcupacaoLi.click();
	}
	
	/**
	* @see [Function]: Seleciona uma opção no campo de Principal Ocupação.
	* @param principalOcupacao opção a ser escolhida.
	*/
	public void selecionarPrincipalOcupacao(String principalOcupacao) {
		principalOcupacaoLabel.click();
		WebElement principalOcupacaoLi = principalOcupacaoUl.findElement(By.xpath("//li[@data-label='"+principalOcupacao+"']"));
		principalOcupacaoLi.click();
	}
	
	/**
	* @see [Function]: Seleciona uma opção no campo de Documento de Indentificação.
	* @param documentoIdentificacao opção a ser escolhida.
	*/
	public void selecionarDocumentoIdentificacao(String documentoIdentificacao) {
		documentoIdentificacaoLabel.click();
		WebElement documentoIdentificacaoLi = documentoIdentificacaoUl.findElement(By.xpath("//li[@data-label='"+documentoIdentificacao+"']"));
		documentoIdentificacaoLi.click();
	}
	
	/**
	* @see [Function]: Seleciona uma opção no campo de Tipo de Documento.
	* @param tipoDocumento opção a ser escolhida.
	*/
	public void selecionarTipoDocumento(String tipoDocumento) {
		tipoDocumentoLabel.click();
		WebElement tipoDocumentoLi = tipoDocumentoUl.findElement(By.xpath("//li[@data-label='"+tipoDocumento+"']"));
		tipoDocumentoLi.click();
	}
	
	/**
	* @see [Function]: Digita o valor do Número do Documento.
	* @param numeroDocumentoInput a ser digitado.
	*/	
	public void digitarNumeroDocumento(String numeroDocumento) {
		waitForElement(numeroDocumentoInput);
		numeroDocumentoInput.sendKeys(numeroDocumento);
	}
	
	/**
	* @see [Function]: Digita o valor do dia data de emissão.
	* @param dataEmissaoDia a ser digitado.
	*/	
	public void digitarDataEmissaoDia(String dataEmissaoDia) {
		waitForElement(dataEmissaoDiaInput);
		sendKeysJs(dataEmissaoDia,dataEmissaoDiaInput);		
	}
	
	/**
	* @see [Function]: Digita o valor do mês data de emissão.
	* @param dataEmissaoMes a ser digitado.
	*/	
	public void digitarDataEmissaoMes(String dataEmissaoMes) {
		waitForElement(dataEmissaoMesInput);
		sendKeysJs(dataEmissaoMes,dataEmissaoMesInput);	
	}
	
	/**
	* @see [Function]: Digita o valor do ano da data de emissão.
	* @param dataEmissaoAno a ser digitado.
	*/	
	public void digitarDataEmissaoAno(String dataEmissaoAno) {
		waitForElement(dataEmissaoAnoInput);
		sendKeysJs(dataEmissaoAno,dataEmissaoAnoInput);	
	}
	
	/**
	* @see [Function]: Inclui Documento.
	*/
	public void clicarIncluir() {
		incluirButton.click();
	}
	
	/**
	* @see [Function]: Seleciona uma opção no campo de Orgão Emissor.
	* @param orgaoEmissor opção a ser escolhida.
	*/
	public void selecionarOrgaoEmissor(String orgaoEmissor) {
		waitForElementEnabled(orgaoEmissorLabel);
		orgaoEmissorLabel.click();
		WebElement orgaoEmissorLi = orgaoEmissorUl.findElement(By.xpath("//li[@data-label='"+orgaoEmissor+"']"));
		orgaoEmissorLi.click();
	}
	
	/**
	* @see [Function]: Seleciona uma opção no campo de Uf do documento.
	* @param documentoUf opção a ser escolhida.
	*/
	public void selecionarDocumentoUf(String documentoUf) {
		waitForElementEnabled(documentoUfLabel);
		documentoUfLabel.click(); 
		WebElement documentoUfLi = documentoUfUl.findElement(By.xpath("//html/body/div[20]/div/ul/li[@data-label='"+documentoUf+"']"));
		documentoUfLi.click();
	}

	/**
	* @see [Function]: Seleciona uma opção no campo do Estado Civil.
	* @param estadoCivil opção a ser escolhida.
	*/
	public void selecionarEstadoCivil(String estadoCivil) {
		waitForElementEnabled(estadoCivilLabel);
		estadoCivilLabel.click();
		WebElement estadoCivilLi = estadoCivilUl.findElement(By.xpath("//li[@data-label='"+estadoCivil+"']"));
		estadoCivilLi.click();
	}
	
	/**
	* @see [Function]: Digita o valor do CPF do Conjuge.
	* @param cpfConjuge a ser digitado.
	*/	
	public void digitarCpfConjuge(String cpfConjuge) {
		waitForElement(cpfConjugeInput);
		cpfConjugeInput.sendKeys(cpfConjuge);
	}
	
	/**
	* @see [Function]: Consulta os dados do Conjuge.
	*/
	public void clicarConultarConjuge() {
		consultarConjugeButton.click();
	}	

	/**
	* @see [Function]: Vai a próxima página.
	*/
	public void clicarProximo() {
		proximoButton.click();
	}

}
