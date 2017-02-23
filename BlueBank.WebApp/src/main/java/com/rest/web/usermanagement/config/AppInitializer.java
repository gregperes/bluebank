package com.rest.web.usermanagement.config;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

/**
 * Classe para inicialização das configrações da aplicação
 * 
 * 
 * @author emersonmuraro
 *
 */
public class AppInitializer extends AbstractAnnotationConfigDispatcherServletInitializer{
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	@Override
	protected Class[] getRootConfigClasses() {
		return new Class[] { AppConfig.class };
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	@Override
	protected Class[] getServletConfigClasses() {
		return null;
	}

	@Override
	protected String[] getServletMappings() {
		return new String[] { "/" };
	}
}
