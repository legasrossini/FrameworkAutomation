package br.gov.caixa.sipan.automacao.core;

import org.openqa.selenium.WebDriver;


public class PageObjectInstantiator {

	private WebDriver driver;
	private EvidenceGenerator evidenceGenerator;

	public PageObjectInstantiator(WebDriver driver, EvidenceGenerator evidenceGenerator) {
		this.driver = driver;
		this.evidenceGenerator = evidenceGenerator;
	}

	@SuppressWarnings("unchecked")
	public <T> T instantiate(Class<BasePage> pageObjectClass) {
		return (T) LocalPageFactory.initElements(driver, evidenceGenerator, pageObjectClass);
	}

}
