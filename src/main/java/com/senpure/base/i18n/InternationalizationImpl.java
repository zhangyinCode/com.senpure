package com.senpure.base.i18n;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.text.MessageFormat;
import java.util.List;
import java.util.Locale;
import java.util.MissingResourceException;
import java.util.ResourceBundle;


/**
 * 
 *如果key值不存在，返回key值
 *
 */


public class InternationalizationImpl implements Internationalization {
	//private static  final Logger LOG = Logger.getLogger(InternationalizationImpl.class);
	private static final Logger LOG= LogManager.getLogger(InternationalizationImpl.class);
	
	
	@Override
	public void refreshProperties() {
	
		ResourceBundle.clearCache();
	}

	@Override
	public String getText(String baseName, Locale locale, String key) {
	
		try {
		
		return 	ResourceBundle.getBundle(baseName, locale).getString(key);
		} 
		catch (NullPointerException e) {
			LOG.warn("资源不存在baseName(" +baseName + ")，返回key值:"+key);
			
		}catch (MissingResourceException e) {
		
			LOG.warn("资源baseName(" +baseName + ")没有找到key值(" + key + ")，返回key值");
		}
		
		return key;
	}
	/*
	 * 去掉检查警告提示
	 */
	private Object[] argsToArray(String... args) {
		return args;
	}
	@Override
	public String getText(String baseName, Locale locale, String key,
			String... args) {
	
		return MessageFormat.format(getText(baseName, locale, key),argsToArray(args));
	}

	@Override
	public String getText(String baseName, Locale locale, String key,
			List<?> args) {
	
		return MessageFormat.format(getText(baseName, locale, key),args);
	}

	@Override
	public String getText(String baseName, Locale locale, String key,
			Object[] args) {
		
		return MessageFormat.format(getText(baseName, locale, key),args);
	}

	public static void main(String[] args) {

		System.out.println(ResourceBundle.getBundle("i18n/result/result").getString("account.not.login.message"));
	}
}
