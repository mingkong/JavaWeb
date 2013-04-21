package com.lysoft.business.web.aes.common.stripes.ext;

import java.util.Arrays;
import java.util.List;
import java.util.Locale;
import java.util.ResourceBundle;

import net.sourceforge.stripes.config.Configuration;
import net.sourceforge.stripes.localization.LocalizationBundleFactory;
import net.sourceforge.stripes.util.StringUtil;

public class CustomLocalizationBundleFactory implements
		LocalizationBundleFactory {
	/**
	 * The Configuration Key which specifies multiple resource bundles.
	 */
	public static final String RESOURCE_BUNDLES_BASE_NAMES = "ResourceBundles.BaseNames";
	private String[] bundles;

	public ResourceBundle getFormFieldBundle(Locale locale) {
		return new MultipleResourceBundle(locale, getBundleNames());
	}

	public ResourceBundle getErrorMessageBundle(Locale locale) {
		return new MultipleResourceBundle(locale, getBundleNames());
	}

	public void init(Configuration config) {
		String bundleNames = config.getBootstrapPropertyResolver().getProperty(
				RESOURCE_BUNDLES_BASE_NAMES);
		bundles = StringUtil.standardSplit(bundleNames);
	}

	public List<String> getBundleNames() {
		return Arrays.asList(bundles);
	}
}