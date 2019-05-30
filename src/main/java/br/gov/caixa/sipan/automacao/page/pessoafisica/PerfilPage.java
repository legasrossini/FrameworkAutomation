package br.gov.caixa.sipan.automacao.page.pessoafisica;

import org.openqa.selenium.By;
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
public class PerfilPage extends BasePage {

	@FindBy(id = "frmSipanPessoaFisica:segmentoCarteira_label")
	private WebElement segmentoLabel;	
	@FindBy(xpath = "/html/body/div[29]/div/ul")
	private WebElement segmentoUl;
	
	@FindBy(id = "frmSipanPessoaFisica:gerenteResponsavel_label")
	private WebElement gerenteResponsavelLabel;	
	@FindBy(xpath = "/html/body/div[30]/div/ul")
	private WebElement gerenteResponsavelUl;
	
	@FindBy(id = "frmSipanPessoaFisica:movimentoContaDepositoPoupanca")
	private WebElement propositosCheckBox;
	
	@FindBy(id = "frmSipanPessoaFisica:cmdLnkProximo")
	private WebElement proximoButton;
	
	public PerfilPage(WebDriver driver, EvidenceGenerator evidenceGenerator) {
		super(driver, evidenceGenerator);		
	}
	
	public void preencherdadosDaRenda(String segmento, String gerenteResponsavel) {
		selecionarSegmento(segmento);
		selecionarGerenteResponsavel(gerenteResponsavel);
		clicarConta();
		clicarProximo();
	}

	/**
	* @see [Function]: Seleciona uma opção no campo de Segmento.
	* @param segmento opção a ser escolhida.
	*/
	public void selecionarSegmento(String segmento) {
		waitForElementEnabled(segmentoLabel);
		segmentoLabel.click();
		WebElement segmentoLi = segmentoUl.findElement(By.xpath("//li[@data-label='"+segmento+"']"));
		segmentoLi.click();
	}
	
	/**
	* @see [Function]: Seleciona uma opção no campo de Gerente Responsavél.
	* @param gerenteResponsavel opção a ser escolhida.
	*/
	public void selecionarGerenteResponsavel(String gerenteResponsavel) {
		gerenteResponsavelLabel.click();
		WebElement gerenteResponsavelLi = gerenteResponsavelUl.findElement(By.xpath("//li[@data-label='"+gerenteResponsavel+"']"));
		gerenteResponsavelLi.click();
	}

	/**
	* @see [Function]: Vai a próxima página.
	*/
	public void clicarConta() {
		propositosCheckBox.click();
	}
	
	/**
	* @see [Function]: Vai a próxima página.
	*/
	public void clicarProximo() {
		waitForElementEnabled(proximoButton);
		proximoButton.click();
	}
	
}
