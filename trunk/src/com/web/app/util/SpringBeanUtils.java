package com.web.app.util;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

public class SpringBeanUtils implements ApplicationContextAware {
	private static ApplicationContext applicationContext;

	public SpringBeanUtils() {

	}

	@Override
	public void setApplicationContext(ApplicationContext arg0)
			throws BeansException {
		// TODO Auto-generated method stub
		applicationContext = arg0;
	}

	public static ApplicationContext getContext() {
		return applicationContext;
	}

	public final static Object getBean(String beanName) {
		return applicationContext.getBean(beanName);
	}

	public final static Object getBean(String beanName, Class<?> requiredType) {
		return applicationContext.getBean(beanName, requiredType);
	}

}
