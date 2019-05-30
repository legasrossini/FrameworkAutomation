package br.gov.caixa.sipan.automacao.page.pessoaujridica;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import br.gov.caixa.sipan.automacao.core.BasePage;

/**
* @see [Page]: Classe que representa a tela de Faturamento Fiscal.
* @author Douglas Legas Rossini.
* @since 28/03/2019.
*/
public class FaturamentoFiscalPage extends BasePage {
	
	@FindBy(id = "idFormPrincipal:cmbCaracterizacaoReceitaAnual_label")
	private WebElement caracterizacaoAnualLabel;
	
	@FindBy(xpath = "/html/body/div[11]/div/ul")
	private WebElement caracterizacaoAnualUl;
	
	@FindBy(id = "idFormPrincipal:cmbCaracterizacaoReceitaUltimosDozeMeses_label")
	private WebElement caracterizacaoDozeMesesLabel;
	
	@FindBy(xpath = "/html/body/div[13]/div/ul")
	private WebElement caracterizacaoDozeMesesUl;
	
	@FindBy(id = "idFormPrincipal:valorReceitaAnual")
	private WebElement valorReceitaAnualInput;
	
	@FindBy(id = "idFormPrincipal:anoReferenciaReceitaAnual")
	private WebElement anoReferenciaAnualInput;
	
	@FindBy(id = "idFormPrincipal:faturamentoDozeUltimosMeses")
	private WebElement faturamentoDozeUltimosMesesInput;
	
	@FindBy(id = "idFormPrincipal:qtdeMesesUltimosDozeMeses")
	private WebElement quantidadeDeMesesUltimosDozeMesesInput;
	
	@FindBy(id = "idFormPrincipal:cmdLnkSalvarFaturamento")
	private WebElement salvarButton;
	
	@FindBy(id = "idFormPrincipal:cmdLnkProximo")
	private WebElement proximoButton;
		
	public FaturamentoFiscalPage(WebDriver driver) {
		super(driver);
	}
	
	
	public void preencherFaturamentoAnual(String caracterizacaoAnual, String receitaAnual, String anoReferencia) {
		selecionarCaracterizacaoAnual(caracterizacaoAnual);
		logInfo("- Caracterização Anual selecionada: " + caracterizacaoAnual);
		digitarValorReceitaAnual(receitaAnual);
		logInfo("- Valor da Receita Anual preenchido: " + receitaAnual);
		digitarAnoReferenciaAnual(anoReferencia);
		logInfo("- Ano da Receita Anual preenchido: " + anoReferencia);
		clicarSalvar();
		logInfo("- Botao Salvar clicado");
	}
	
	public void preencherFaturamentoDozeMeses(String caracterizacaoDozeMeses, String receitaDozeMeses, String quantidadeMeses) {
		selecionarCaracterizacaoDozeMeses(caracterizacaoDozeMeses);
		logInfo("- Caracterização Doze ultimos meses selecionada: " + caracterizacaoDozeMeses);
		digitarValorFaturamentoDozeUltimosMeses(receitaDozeMeses);
		logInfo("- Faturamento dos Doze ultimos meses preenchido: " + receitaDozeMeses);
		digitarQuantidadeDeMesesUltimosDozeMeses(quantidadeMeses);
		logInfo("- Quantidade de meses dos Doze ultimos meses preenchido: " + quantidadeMeses, true);
		clicarProximo();
	}

	/**
	* @see [Function]: Seleciona uma opção no campo de caracterizacao anual.
	* @param caracterizacaoAnual opção a ser escolhida.
	*/
	public void selecionarCaracterizacaoAnual(String caracterizacaoAnual) {
		caracterizacaoAnualLabel.click();
		WebElement caracterizacaoAnualLi = caracterizacaoAnualUl.findElement(By.xpath("//html/body/div[11]/div/ul/li[@data-label='"+caracterizacaoAnual+"']"));
		caracterizacaoAnualLi.click();
	}
	
	/**
	* @see [Function]: Seleciona uma opção no campo de caracterizacao doze meses.
	* @param caracterizacaoDozeMeses opção a ser escolhida.
	*/
	public void selecionarCaracterizacaoDozeMeses(String caracterizacaoDozeMeses) {
		waitForElementEnabled(caracterizacaoDozeMesesLabel);
		caracterizacaoDozeMesesLabel.click();
		WebElement caracterizacaoDozeMesesLi = caracterizacaoDozeMesesUl.findElement(By.xpath("//html/body/div[13]/div/ul/li[@data-label='"+caracterizacaoDozeMeses+"']"));
		caracterizacaoDozeMesesLi.click();           
	}

	/**
	* @see [Function]: Digita o valor do campo de receita anual.
	* @param valorReceitaAnual a ser digitado.
	*/
	public void digitarValorReceitaAnual(String valorReceitaAnual) {
		waitForElement(valorReceitaAnualInput);
		valorReceitaAnualInput.sendKeys(valorReceitaAnual);
	}
	
	/**
	* @see [Function]: Digita o valor do campo de ano referencia.
	* @param anoReferencia a ser digitado.
	*/	
	public void digitarAnoReferenciaAnual(String anoReferencia) {			
		sendKeysJs(anoReferencia, anoReferenciaAnualInput);
	}
	
	/**
	* @see [Function]: Digita o valor do faturamento doze ultimos meses.
	* @param faturamentoDozeMeses a ser digitado.
	*/	
	public void digitarValorFaturamentoDozeUltimosMeses(String faturamentoDozeMeses) {
		waitForElement(faturamentoDozeUltimosMesesInput);
		faturamentoDozeUltimosMesesInput.sendKeys(faturamentoDozeMeses);
	}
	
	/**
	* @see [Function]: Digita o valor do campo de quantidade de meses dos ultimos doze meses.
	* @param qtdDozeMeses a ser digitado.
	*/	
	public void digitarQuantidadeDeMesesUltimosDozeMeses(String qtdDozeMeses) {
		quantidadeDeMesesUltimosDozeMesesInput.sendKeys(qtdDozeMeses);
	}	
	
	/**
	* @see [Function]: salva os dados preenchidos.
	*/
	public void clicarSalvar() {
		salvarButton.click();
	}	
	
	/**
	* @see [Function]: Vai a próxima página.
	*/
	public void clicarProximo() {
		proximoButton.click();
	}	


}
