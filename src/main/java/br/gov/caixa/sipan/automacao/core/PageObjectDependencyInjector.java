package br.gov.caixa.sipan.automacao.core;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.LinkedList;
import java.util.List;

import br.gov.caixa.sipan.automacao.annotation.Page;

public class PageObjectDependencyInjector {

    private final PageObjectInstantiator pageObjectInstantiator;

    public PageObjectDependencyInjector(PageObjectInstantiator pageObjectInstantiator) {
        this.pageObjectInstantiator = pageObjectInstantiator;
    }

    public void injectDependenciesInto(Object target) {
        List<Field> pageObjectFields = pageObjectFieldsIn(target);
        for(Field pageObjectField : pageObjectFields) {
            instantiatePageObjectIfNotAssigned(pageObjectField, target);
        }
    }

    @SuppressWarnings("unchecked")
	private void instantiatePageObjectIfNotAssigned(Field pageObjectField, Object target) {
        try {
            pageObjectField.setAccessible(true);
            if (pageObjectField.get(target) == null) {
                Class<BasePage> pageObjectClass = (Class<BasePage>) pageObjectField.getType();
                BasePage newPageObject = pageObjectInstantiator.instantiate(pageObjectClass);
                injectDependenciesInto(newPageObject);
                pageObjectField.set(target, newPageObject);
            }
        } catch (IllegalAccessException e) {
            throw new IllegalArgumentException("Could not instanciate page objects in " + target);
        }
    }

    private List<Field> pageObjectFieldsIn(Object target) {
		LinkedList<Field> allFields = new LinkedList<Field>();

		Class<?> clazz = target.getClass();
        do {
        	LinkedList<Field> fields = new LinkedList<Field>();
            for (Field field : clazz.getDeclaredFields()) {
            	if (isPageObject(field)) {
            		if (Modifier.isStatic(field.getModifiers())) {
            			throw new IllegalStateException("@Page annotations are not supported on static fields");
            		}
            		fields.add(field);
                }
            }
            allFields.addAll(0, fields);
            clazz = clazz.getSuperclass();
        } while (clazz != null && clazz != Object.class);

        return allFields;
    }

    private boolean isPageObject(Field field) {
		return field.isAnnotationPresent(Page.class)
				&& BasePage.class.isAssignableFrom(field.getType());
	}
}
