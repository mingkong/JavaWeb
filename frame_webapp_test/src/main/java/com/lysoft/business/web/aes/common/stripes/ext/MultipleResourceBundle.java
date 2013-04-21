package com.lysoft.business.web.aes.common.stripes.ext;

import java.util.Enumeration;
import java.util.List;
import java.util.Locale;
import java.util.MissingResourceException;
import java.util.ResourceBundle;

import net.sourceforge.stripes.localization.DefaultLocalizationBundleFactory;

public class MultipleResourceBundle extends ResourceBundle {
    private Locale locale;
    private List<String> bundleNames;

    public MultipleResourceBundle(Locale locale, List<String> bundleNames) {
        this.locale = locale;
        this.bundleNames = bundleNames;
    }

    @Override
    public Enumeration<String> getKeys() {
        return null;
    }

    @Override
    protected Object handleGetObject(String key) {
        Object result = null;
        if (bundleNames != null) {
            // Look in each configured bundle
            for (String bundleName : bundleNames) {
                if (bundleName != null) {
                    result = getFromBundle(locale, bundleName, key);
                    if (result != null) {
                        break;
                    }
                }
            }
        }
        if (result == null) {
            // Try the application's default bundle
            String bundleName = DefaultLocalizationBundleFactory.BUNDLE_NAME;
            result = getFromBundle(locale, bundleName, key);
        }
        return result;
    }

    /**
     * Returns null if the bundle or key is not found. No exceptions thrown.
     */
    private String getFromBundle(Locale loc, String bundleName, String key) {
        String result = null;
        ResourceBundle bundle = ResourceBundle.getBundle(bundleName, loc);
        if (bundle != null) {
            try {
                result = bundle.getString(key);
            } catch (MissingResourceException exc) {
            }
        }
        return result;
    }
}