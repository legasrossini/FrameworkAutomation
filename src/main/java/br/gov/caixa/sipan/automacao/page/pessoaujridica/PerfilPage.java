package br.gov.caixa.sipan.automacao.page.pessoaujridica;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import br.gov.caixa.sipan.automacao.core.BasePage;
import br.gov.caixa.sipan.automacao.core.EvidenceGenerator;

/**
* @see [Page]: Classe que representa a tela de Perfil.
* @author Douglas Legas Rossini.
* @since 28/03/2019.
*/
public class PerfilPage extends BasePage {
	
	@FindBy(id = "idFormPrincipal:segmentoCarteira_label")
	private WebElement segmentoLabel;
	
	@FindBy(xpath = "/html/body/div[19]/div/ul")
	private WebElement segmentoUl;
	
	@FindBy(id = "idFormPrincipal:gerenteResponsavel_label")
	private WebElement gerenteResponsavelLabel;
	
	@FindBy(xpath = "/html/body/div[20]/div/ul")
	private WebElement gerenteResponsavelUl;
	
	@FindBy(id = "idFormPrincipal:movimentacaoContaDepositoPoupanca")
	private WebElement contaDepositoPoupacaCheckBox;
	
	@FindBy(id = "idFormPrincipal:cmdLnkProximo")
	private WebElement proximoButton;
	
	
	public PerfilPage(WebDriver driver, EvidenceGenerator evidenceGenerator) {
		super(driver, evidenceGenerator);
	}
	
	public void preencherPerfil(String segmento, String gerenteResponsavel) {
		selecionarSegmento(segmento);
		logInfo("- Segmento selecionada: " + segmento);
		selecionarGerenteResponsavel(gerenteResponsavel);
		logInfo("- Gerente Responsavél selecionad0: " + gerenteResponsavel);
		clicarContaDepositoPoupanca();
		logInfo("- Opção de conta deposito selecionada", true);
		clicarProximo();
	}
	
	/**
	* @see [Function]: Seleciona uma opção no campo de segmento.
	* @param segmento opção a ser escolhida.
	*/	
	public void selecionarSegmento(String segmento) {
		waitForElementEnabled(segmentoLabel);
		segmentoLabel.click();
		WebElement segmentoLi = segmentoUl.findElement(By.xpath("//li[@data-label='" + segmento + "']"));
		segmentoLi.click();
	}
	
	/**
	* @see [Function]: Seleciona uma opção no campo de gerente responsavél.
	* @param gerenteResponsavel opção a ser escolhida.
	*/	
	public void selecionarGerenteResponsavel(String gerenteResponsavel) {
		waitForElementEnabled(gerenteResponsavelLabel);
		gerenteResponsavelLabel.click();
		WebElement gerenteResponsavelLi = gerenteResponsavelUl.findElement(By.xpath("//li[@data-label='" + gerenteResponsavel + "']"));
		gerenteResponsavelLi.click();
	}

	/**
	* @see [Function]: Seleciona a opção conta deposito/poupança de check box.
	*/	
	public void clicarContaDepositoPoupanca() {
		waitForElementEnabled(contaDepositoPoupacaCheckBox);
		contaDepositoPoupacaCheckBox.click();
	}	
	
	/**
	* @see [Function]: Vai a próxima página.
	*/
	public void clicarProximo() {	
		proximoButton.click();
	}	

}
