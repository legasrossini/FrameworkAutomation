package br.gov.caixa.sipan.automacao.page.pessoaujridica;

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
public class DadosCadastraisPage extends BasePage {

	@FindBy(id = "idFormPrincipal:cmbRegimeTributario_label")
	private WebElement regimeTributarioLabel;
	
	@FindBy(xpath = "/html/body/div[7]/div/ul")
	private WebElement regimeTributarioUl;
	
	@FindBy(id = "idFormPrincipal:cmbFinalidadeEmpresa_label")
	private WebElement finalidadeEmpresaLabel;
	
	@FindBy(xpath = "/html/body/div[8]/div/ul")
	private WebElement finalidadeEmpresUl;

	@FindBy(id = "idFormPrincipal:cmbFranquia_label")
	private WebElement franquiaLabel;
	
	@FindBy(xpath = "/html/body/div[9]/div/ul")
	private WebElement franquiaUl;
	
	@FindBy(id = "idFormPrincipal:cmdLnkProximo")
	private WebElement proximoButton;	

	public DadosCadastraisPage(WebDriver driver, EvidenceGenerator evidenceGenerator) {
		super(driver, evidenceGenerator);		
	}
	
	public void preencherDadosCadastrias(String regimeTributario, String finalidadeEmpresa, String franquia) {
		selecionarRegimeTributario(regimeTributario);
		logInfo("- Regime Tributario preenchido: " + regimeTributario);
		selecionarFinalidadeEmpresa(finalidadeEmpresa);
		logInfo("- Finalidade da Empresa selecionada: " + finalidadeEmpresa);
		selecionarFranquia(franquia );
		logInfo("- Franquia selecionada: " + franquia, true);
		clicarProximo();
	}

	/**
	* @see [Function]: Seleciona uma opção no campo de regime tributario.
	* @param regimeTributario opção a ser escolhida.
	*/
	public void selecionarRegimeTributario(String regimeTributario) {
		regimeTributarioLabel.click();
		WebElement regimeTributarioLi = regimeTributarioUl.findElement(By.xpath("//li[@data-label='"+regimeTributario+"']"));
		regimeTributarioLi.click();
	}
	
	/**
	* @see [Function]: Seleciona uma opção no campo de finalidade da empresa.
	* @param finalidadeEmpresa opção a ser escolhida.
	*/
	public void selecionarFinalidadeEmpresa(String finalidadeEmpresa) {
		finalidadeEmpresaLabel.click();
		WebElement finalidadeEmpresLi = finalidadeEmpresUl.findElement(By.xpath("//li[@data-label='"+finalidadeEmpresa+"']"));
		finalidadeEmpresLi.click();
	}
	
	/**
	* @see [Function]: Seleciona uma opção no campo franquia.
	* @param finalidadeEmpresa opção a ser escolhida.
	*/
	public void selecionarFranquia(String franquia) {
		franquiaLabel.click();
		WebElement franquiaLi = franquiaUl.findElement(By.xpath("//li[@data-label='"+franquia+"']"));
		franquiaLi.click();
	}
	
	/**
	* @see [Function]: Vai a próxima página.
	*/
	public void clicarProximo() {
		proximoButton.click();
	}

}
