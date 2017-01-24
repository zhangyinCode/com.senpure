package com.senpure.base.i18n;

import java.util.List;
import java.util.Locale;

public interface Internationalization {
	void refreshProperties();
	String getText(String baseName, Locale locale, String key);
	
	String getText(String baseName, Locale locale, String key, String... args);
	String getText(String baseName, Locale locale, String key, List<?> args);
	String getText(String baseName, Locale locale, String key, Object[] args);

}
