package br.gov.caixa.sipan.automacao.core;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class PageObjectInstantiator {

	private WebDriver driver;

	public PageObjectInstantiator(WebDriver driver) {
		this.driver = driver;
	}

	@SuppressWarnings("unchecked")
	public <T> T instantiate(Class<BasePage> pageObjectClass) {
		return (T) PageFactory.initElements(driver, pageObjectClass);
	}

}
