package br.gov.caixa.sipan.automacao.core;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class LocalPageFactory extends PageFactory {
	
	  public static <T> T initElements(WebDriver driver, EvidenceGenerator evidenceGenerator, Class<T> pageClassToProxy) {
	    T page = instantiatePage(driver, evidenceGenerator, pageClassToProxy);
	    initElements(driver, page);
	    return page;
	  }
	  
	  private static <T> T instantiatePage(WebDriver driver, EvidenceGenerator evidenceGenerator, Class<T> pageClassToProxy) {
	    try {
	      try {
	        Constructor<T> constructor = pageClassToProxy.getConstructor(WebDriver.class, EvidenceGenerator.class);
	        return constructor.newInstance(driver, evidenceGenerator);
	      } catch (NoSuchMethodException e) {
	        return pageClassToProxy.newInstance();
	      }
	    } catch (InstantiationException e) {
	      throw new RuntimeException(e);
	    } catch (IllegalAccessException e) {
	      throw new RuntimeException(e);
	    } catch (InvocationTargetException e) {
	      throw new RuntimeException(e);
	    }
	  }

}
