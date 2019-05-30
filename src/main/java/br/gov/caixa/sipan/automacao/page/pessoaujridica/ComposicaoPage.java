package br.gov.caixa.sipan.automacao.page.pessoaujridica;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import br.gov.caixa.sipan.automacao.core.BasePage;

/**
* @see [Page]: Classe que representa a tela de Composicao.
* @author Douglas Legas Rossini.
* @since 28/03/2019.
*/
public class ComposicaoPage extends BasePage {
	
	@FindBy(id = "idFormPrincipal:tipoVinculo_label")
	private WebElement tipoVinculoLabel;
	
	@FindBy(xpath = "/html/body/div[7]/div/ul")
	private WebElement tipoVinculoUl;
	
	@FindBy(id = "idFormPrincipal:cmdTipoPessoaAlterar_label")
	private WebElement tipoPessoaLabel;
	
	@FindBy(xpath = "/html/body/div[7]/div/ul")
	private WebElement tipoPessoaUl;
	
	@FindBy(id = "idFormPrincipal:dtUltimaAlteracaoComposicao")
	private WebElement ultimaAlteracaoInput;
	
	@FindBy(id = "idFormPrincipal:txtPorcentagemParticipacao")
	private WebElement porcentagemInput;
	
	@FindBy(id = "idFormPrincipal:cpfCnpj")
	private WebElement cpfCnpjInput;
	
	@FindBy(id = "idFormPrincipal:btnInserirSocioAdmin")
	private WebElement incluirSocioButton;
	
	@FindBy(id = "idFormPrincipal:idCmdLnkConsultaClienteAlterar")
	private WebElement consultarClienteButton;
	
	@FindBy(id = "idFormPrincipal:cmdLnkSalvarAlteracaoVinculo")
	private WebElement incluirButton;
	
	@FindBy(id = "idFormPrincipal:cmdLnkProximo")
	private WebElement proximoButton;
	
	public ComposicaoPage(WebDriver driver) {
		super(driver);	
	}
	
	public void preencherComposicao (String ultimaAlteracao, String tipoPessoa, String cpfOuCnpj, String tipoVinculo, String porcentagem) {
		digitarUltimaAlteracao(ultimaAlteracao);
		logInfo("- Ultima Alteração preenchida: " + ultimaAlteracao);
		clicarIncluirSocio();
		logInfo("- Botão Incluir Sócio clicado");
		selecionarTipoPessoa(tipoPessoa);
		logInfo("- Tipo de Pessoa selecionado: " + tipoPessoa);
		digitarCpfOuCnpj(cpfOuCnpj);
		logInfo("- CPF ou CNPJ preenchido: " + cpfOuCnpj);
		clicarConsultarCliente();
		logInfo("- Botão Consultar Cliente clicado");
		selecionarTipoVinculo(tipoVinculo);
		logInfo("- Tipo de Vínculo selecionado: " + tipoVinculo);
		digitarDigitarPorcentagem(porcentagem);
		logInfo("- Porcentagem preenchida: " + porcentagem);
		clicarIncluir();
		logInfo("- Botão Incluir clicado", true);
		clicarProximo();
	}
	
	/**
	* @see [Function]: Seleciona uma opção no campo tipo de vinculo.
	* @param tipoVinculo opção a ser escolhida.
	*/
	public void selecionarTipoVinculo(String tipoVinculo) {
		waitForElementEnabled(tipoVinculoLabel);
		tipoVinculoLabel.click();
		WebElement tipoVinculoLi = tipoVinculoUl.findElement(By.xpath("//li[@data-label='" + tipoVinculo + "']"));
		tipoVinculoLi.click();
	}
	
	/**
	* @see [Function]: Seleciona uma opção no campo de tipo de pessoa.
	* @param tipoPessoa opção a ser escolhida.
	*/
	public void selecionarTipoPessoa(String tipoPessoa) {
		waitForElementEnabled(tipoPessoaLabel);
		tipoPessoaLabel.click();
		WebElement tipoPessoaLi = tipoPessoaUl.findElement(By.xpath("//li[@data-label='" + tipoPessoa + "']"));
		tipoPessoaLi.click();
	}

	/**
	* @see [Function]: Digita o valor da referencia da residencia.
	* @param referencia a ser digitado.
	*/	
	public void digitarUltimaAlteracao(String dataUltimaAlteracao) {
		waitForElement(ultimaAlteracaoInput);
		sendKeysJs(dataUltimaAlteracao, ultimaAlteracaoInput);
	}
	
	/**
	* @see [Function]: Digita o valor da porcentagem do sócio.
	* @param porcentagem a ser digitado.
	*/	
	public void digitarDigitarPorcentagem(String porcentagem) {
		sendKeysJs(porcentagem, porcentagemInput);
	}
	
	/**
	* @see [Function]: Digita o valor do cpf ou cnpj do sócio.
	* @param cpfOuCnpj a ser digitado.
	*/	
	public void digitarCpfOuCnpj(String cpfOuCnpj) {
		waitForElement(cpfCnpjInput);
		cpfCnpjInput.sendKeys(cpfOuCnpj);
	}
	
	/**
	* @see [Function]: Conclui o cadastro do sócio.
	*/
	public void clicarIncluirSocio() {
		waitForElementEnabled(incluirSocioButton);
		incluirSocioButton.click();
	}
	
	/**
	* @see [Function]: Consulta o cliente.
	*/
	public void clicarConsultarCliente() {
		consultarClienteButton.click();
	}
	
	/**
	* @see [Function]: Conclui o cadastro.
	*/
	public void clicarIncluir() {
		incluirButton.click();
	}
	
	/**
	* @see [Function]: Vai a próxima página.
	*/
	public void clicarProximo() {
		waitForElementEnabled(proximoButton);
		proximoButton.click();
	}
}
