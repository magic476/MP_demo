package com.wp.Utils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

@Component
@Lazy(false)
public class ApplicationContextUtil implements ApplicationContextAware{
	
	private Logger logger=LoggerFactory.getLogger(this.getClass());

	 private static ApplicationContext APPLICATION_CONTEXT;
	 
	    @Override
	    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
	        APPLICATION_CONTEXT = applicationContext;
	    }
	 
	    public static ApplicationContext getApplicationContext() {
	        return APPLICATION_CONTEXT;
	    }
}
