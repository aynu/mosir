// ----------------------------------------------------------------------------
// Copyright (C) Aynu Evolution Laboratory. All rights reserved.
// GNU GENERAL PUBLIC LICENSE Version 3, 29 June 2007
// http://www.gnu.org/licenses/gpl-3.0-standalone.html
// ----------------------------------------------------------------------------
package com.github.aynu.mosir.core.standard.util;
/**
 * コンフィグヘルパー
 * @author nilcy
 */
public final class ConfigHelper {
    /** メッセージ定義のベース名 */
    public static final String MESSAGE_BASENAME;
    /** 例外メッセージ定義のベース名 */
    public static final String ERROR_MESSAGE_BASENAME;
    /** インターネットアドレスの文字セット */
    public static final String INET_ADDRESS_CHARSET;
    /** コンフィグ */
    private static final PropertiesHelper CONFIG = new PropertiesHelper("config");
    static {
        MESSAGE_BASENAME = CONFIG.getText("MESSAGE_BASENAME");
        ERROR_MESSAGE_BASENAME = CONFIG.getText("ERROR_MESSAGE_BASENAME");
        INET_ADDRESS_CHARSET = CONFIG.getText("INET_ADDRESS_CHARSET");
    }
    /** 非公開コンストラクタ */
    private ConfigHelper() {
    }
    /**
     * テキスト値の取得
     * @param key キー
     * @return テキスト値
     */
    public static String getText(final String key) {
        return CONFIG.getText(key);
    }
    /**
     * テキスト値の取得
     * @param key キー
     * @return テキスト値
     */
    public static String[] getTexts(final String key) {
        return CONFIG.getTexts(key);
    }
    /**
     * 数値の取得
     * @param key キー
     * @return 数値
     */
    public static int getNumeric(final String key) {
        return CONFIG.getNumeric(key);
    }
}
