// ----------------------------------------------------------------------------
// Copyright (C) Aynu Evolution Laboratory. All rights reserved.
// GNU GENERAL PUBLIC LICENSE Version 3, 29 June 2007
// http://www.gnu.org/licenses/gpl-3.0-standalone.html
// ----------------------------------------------------------------------------
package com.github.aynu.mosir.core.enterprise.persistence;
import java.util.Map;
import com.github.aynu.mosir.core.enterprise.core.EnterpriseException;
/**
 * 永続化キャッチ例外
 * @author nilcy
 */
public class PersistenceException extends EnterpriseException {
    /** 識別番号 */
    private static final long serialVersionUID = 243374892790020654L;
    /** コンストラクタ */
    public PersistenceException() {
    }
    /**
     * コンストラクタ
     * @param message メッセージ
     */
    public PersistenceException(final String message) {
        super(message);
    }
    /**
     * コンストラクタ
     * @param cause 例外オブジェクト
     */
    public PersistenceException(final Throwable cause) {
        super(cause);
    }
    /**
     * コンストラクタ
     * @param message メッセージ
     * @param cause 例外オブジェクト
     */
    public PersistenceException(final String message, final Throwable cause) {
        super(message, cause);
    }
    /**
     * コンストラクタ
     * @param message メッセージ
     * @param cause 例外オブジェクト
     * @param enableSuppression 抑制の有無
     * @param writableStackTrace スタックトレース書込の可否
     */
    public PersistenceException(final String message, final Throwable cause,
        final boolean enableSuppression, final boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
    /**
     * コンストラクタ
     * @param key キー
     * @param values オブジェクト配列
     */
    public PersistenceException(final String key, final Object... values) {
        super(key, values);
    }
    /**
     * コンストラクタ
     * @param messageMap メッセージマップ
     */
    public PersistenceException(final Map<String, Object[]> messageMap) {
        super(messageMap);
    }
}
