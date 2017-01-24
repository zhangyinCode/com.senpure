package com.senpure.base.i18n;

import java.util.List;
import java.util.Locale;

public class I18N {

	private static Internationalization i18n = new InternationalizationImpl();

	public static void refreshProperties() {
		i18n.refreshProperties();
	}

	public static String getText(String baseName, Locale locale, String key) {
		return i18n.getText(baseName, locale, key);
	}

	public static String getText(String baseName, Locale locale, String key, String... args) {
		return i18n.getText(baseName, locale, key, args);
	}

	public static String getText(String baseName, Locale locale, String key, List<?> args) {
		return i18n.getText(baseName, locale, key, args);

	}

	public static String getText(String baseName, Locale locale, String key, Object[] args) {

		return i18n.getText(baseName, locale, key, args);
	}
}
