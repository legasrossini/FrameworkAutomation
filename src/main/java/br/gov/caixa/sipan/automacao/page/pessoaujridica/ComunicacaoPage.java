package br.gov.caixa.sipan.automacao.page.pessoaujridica;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import br.gov.caixa.sipan.automacao.core.BasePage;

/**
* @see [Page]: Classe que representa a tela de Comunicacao.
* @author Douglas Legas Rossini.
* @since 28/03/2019.
*/
public class ComunicacaoPage extends BasePage {
	
	@FindBy(id = "idFormPrincipal:cmbTipoTelefone_label")
	private WebElement meioDeComunicacaoLabel;
	
	@FindBy(xpath = "/html/body/div[33]/div/ul")
	private WebElement meioDeComunicacaoUl;
	
	@FindBy(id = "idFormPrincipal:ns_Z7_8I441240MGSV10ATAM00VP1002_j_id1292209230_4354b5b0")
	private WebElement telefoneInput;
	
	@FindBy(id = "idFormPrincipal:idCmdBtnSalvar")
	private WebElement salvarButton;
	
	@FindBy(id = "idFormPrincipal:cmdLnkProcessoAutomaticoAbrirContaCorrente")
	private WebElement proximoButton;
	
	@FindBy(id = "idFormPrincipal:ns_Z7_8I441240MGSV10ATAM00VP1002_j_id518262956_1_7a1a732")
	private WebElement mensagemSucessoText;
		
	public ComunicacaoPage(WebDriver driver) {
		super(driver);
	}
	
	public void preencherComunicacao(String meioDeComunicacao, String telefone, String mensagem) {
		selecionarMeioDeComunicacao(meioDeComunicacao);
		logInfo("- Meio de Comunicação selecionado: " + meioDeComunicacao);
		digitarTelefone(telefone);
		logInfo("- Telefone preenchido: " + telefone);
		clicarSalvar();
		logInfo("- Botão Salvar clicado", true);
		clicarProximo();
		logInfo("- Botão Próximo (Concluir o Cadastro) clicado");
		validarMensagemSucesso(mensagem);
		logInfo("- Menssagem de retorno obtida com sucesso: " + mensagem, true);
	}
	
	/**
	* @see [Function]: Seleciona uma opção no campo meio de comunicação.
	* @param meioComunicacao opção a ser escolhida.
	*/
	public void selecionarMeioDeComunicacao(String meioComunicacao) {
		waitForElementEnabled(meioDeComunicacaoLabel);
		meioDeComunicacaoLabel.click();
		WebElement meioDeComunicacaoLi = meioDeComunicacaoUl.findElement(By.xpath("//li[@data-label='" + meioComunicacao + "']"));
		meioDeComunicacaoLi.click();
	}
	
	/**
	* @see [Function]: Digita o valor do telefone.
	* @param telefone a ser digitado.
	*/	
	public void digitarTelefone(String telefone) {
		sendKeysJs(telefone, telefoneInput);
	}
	
	/**
	* @see [Function]: Salva o contato cadastrado.
	*/
	public void clicarSalvar() {
		waitForElementEnabled(salvarButton);
		salvarButton.click();
	}
	
	/**
	* @see [Function]: Vai a próxima página e conclui o cadastro.
	*/
	public void clicarProximo() {
		waitForElementEnabled(proximoButton);
		proximoButton.click();
	}
	
	/**
	* @see [Function]: Valida a mensagem obtida com a mensagem esperada.
	* @param mensagemSucessoEsperada mensagem esperada a ser comparada com a recebida.
	*/	
	public void validarMensagemSucesso(String mensagemSucessoEsperada) {
		verificarTexto(mensagemSucessoEsperada, mensagemSucessoText);
	}

}
