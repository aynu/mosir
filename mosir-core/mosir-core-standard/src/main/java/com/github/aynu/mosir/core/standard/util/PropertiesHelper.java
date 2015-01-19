// ----------------------------------------------------------------------------
// Copyright (C) Aynu Evolution Laboratory. All rights reserved.
// GNU GENERAL PUBLIC LICENSE Version 3, 29 June 2007
// http://www.gnu.org/licenses/gpl-3.0-standalone.html
// ----------------------------------------------------------------------------
package com.github.aynu.mosir.core.standard.util;
import java.net.URL;
import java.text.MessageFormat;
import java.util.Collection;
import java.util.Locale;
import java.util.ResourceBundle.Control;
import org.apache.commons.configuration.ConfigurationException;
import org.apache.commons.configuration.PropertiesConfiguration;
import org.apache.commons.lang3.SystemUtils;
import org.apache.commons.lang3.Validate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
/**
 * プロパティヘルパー
 * @author nilcy
 */
public final class PropertiesHelper {
    /** ロガー */
    private static final Logger LOG = LoggerFactory.getLogger(PropertiesHelper.class);
    /** コンフィグ */
    private final PropertiesConfiguration config;
    /**
     * コンストラクタ
     * @param baseName プロパティ定義ベース名
     */
    public PropertiesHelper(final String baseName) {
        config = getPropertiesConfiguration(baseName);
        config.setThrowExceptionOnMissing(true);
    }
    /**
     * テキスト値の取得
     * @param key キー
     * @return テキスト値
     */
    public String getText(final String key) {
        return config.getString(key);
    }
    /**
     * テキスト値の取得
     * @param key キー
     * @param arguments 可変長引数オブジェクト
     * @return テキスト値
     */
    public String getText(final String key, final Object... arguments) {
        final String text = config.getString(key);
        Validate.notNull(text);
        return MessageFormat.format(text, arguments);
    }
    /**
     * テキスト値の取得
     * @param key キー
     * @return テキスト値
     */
    public String[] getTexts(final String key) {
        return config.getStringArray(key);
    }
    /**
     * 数値の取得
     * @param key キー
     * @return 数値
     */
    public int getNumeric(final String key) {
        return config.getInt(key);
    }
    /**
     * プロパティ値の設定
     * @param key キー
     * @param value プロパティ値
     */
    public void setProperty(final String key, final Object value) {
        config.setProperty(key, value);
    }
    /**
     * プロパティの保存
     * @throws ConfigurationException コンフィグ例外
     */
    public void save() throws ConfigurationException {
        config.save();
    }
    /**
     * ファイル名の作成
     * @param baseName ベース名
     * @return ファイル名
     */
    private PropertiesConfiguration getPropertiesConfiguration(final String baseName) {
        final String languageTag = String.format("%s-%s", SystemUtils.USER_LANGUAGE,
            SystemUtils.USER_COUNTRY);
        final Control control = Control.getControl(Control.FORMAT_DEFAULT);
        final Collection<Locale> locales = control.getCandidateLocales("messages",
            Locale.forLanguageTag(languageTag));
        final StringBuilder builder = new StringBuilder();
        for (final Locale locale : locales) {
            final String bundleName = control.toBundleName(baseName, locale);
            final String resourceName = control.toResourceName(bundleName, "properties");
            final URL url = getClass().getResource("/" + resourceName);
            // final URL url = ClassLoader.getSystemResource(resourceName);
            if (url != null) {
                if (builder.length() > 0) {
                    LOG.debug("Resource could not be found ({}).", builder.toString());
                }
                LOG.debug("Resource could be found ({}).", resourceName);
                try {
                    return new PropertiesConfiguration(url);
                } catch (final ConfigurationException e) {
                    throw new RuntimeException(e);
                }
            }
            builder.append(" " + resourceName);
        }
        throw new RuntimeException(String.format("PROPERTY is NOT_FOUND. [baseName=%s]", baseName));
    }
}
