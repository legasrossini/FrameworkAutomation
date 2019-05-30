package br.gov.caixa.sipan.automacao.core;

import org.junit.runners.BlockJUnit4ClassRunner;
import org.junit.runners.model.FrameworkMethod;
import org.junit.runners.model.Statement;
import org.openqa.selenium.WebDriver;

/**
 * Classe Runner para instanciamento automatico das classes de page.
 *
 * @author Alexssandro Alves dos Reis <alexssandro.reis@novaconsultoria.com.br> *
 */
public class SeleniumPageRunner extends BlockJUnit4ClassRunner {

	/**
	 *
	 * @param clazz
	 * @throws Exception
	 */
	public SeleniumPageRunner(Class<?> clazz) throws Exception {
		super(clazz);
	}

	@Override
	protected Statement methodInvoker(FrameworkMethod method, Object test) {
		try {
			createPageObjects(test);
		} catch (Exception e) {
			throw new RuntimeException("Error creating page objects in test: " + method.getName(), e);
		}

		return super.methodInvoker(method, test);
	}

	private void createPageObjects(Object test) throws Exception {

		if (!(test instanceof BaseIntegrationTest)) {
			return;
		}
		WebDriver driver = ((BaseIntegrationTest) test).getDriver();

		PageObjectDependencyInjector injector = new PageObjectDependencyInjector(
				new PageObjectInstantiator(driver));
		injector.injectDependenciesInto(test);
	}

}
