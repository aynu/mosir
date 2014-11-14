// ----------------------------------------------------------------------------
// Copyright (C) Aynu Evolution Laboratory. All rights reserved.
// GNU GENERAL PUBLIC LICENSE Version 3, 29 June 2007
// http://www.gnu.org/licenses/gpl-3.0-standalone.html
// ----------------------------------------------------------------------------
package com.github.aynu.mosir.core.enterprise.core;
import java.util.Map;
import javax.ejb.ApplicationException;
/**
 * リトライ例外
 * <dl>
 * <dt>使用条件
 * <dd>{@link EnterpriseException}へ準拠すること。ロールバックなし、継承あり。
 * </dl>
 * @author nilcy
 */
@ApplicationException(rollback = false, inherited = true)
// CHECKSTYLE:OFF
public class RetryableException extends EnterpriseException {
    /** 識別番号 */
    private static final long serialVersionUID = 1620335242611556374L;
    /**
     * コンストラクタ
     * <dl>
     * <dt>使用条件
     * <dd>{@link EnterpriseException#EnterpriseException()}へ委譲されること。
     * </dl>
     */
    public RetryableException() {
    }
    /**
     * コンストラクタ
     * <dl>
     * <dt>使用条件
     * <dd>{@link EnterpriseException#EnterpriseException(String)}へ委譲されること。
     * </dl>
     * @param message メッセージ
     */
    public RetryableException(final String message) {
        super(message);
    }
    /**
     * コンストラクタ
     * <dl>
     * <dt>使用条件
     * <dd>{@link EnterpriseException#EnterpriseException(Throwable)}へ委譲されること。
     * </dl>
     * @param cause 例外オブジェクト
     */
    public RetryableException(final Throwable cause) {
        super(cause);
    }
    /**
     * コンストラクタ
     * <dl>
     * <dt>使用条件
     * <dd>{@link EnterpriseException#EnterpriseException(String, Throwable)}へ委譲されること。
     * </dl>
     * @param message メッセージ
     * @param cause 例外オブジェクト
     */
    public RetryableException(final String message, final Throwable cause) {
        super(message, cause);
    }
    /**
     * コンストラクタ
     * <dl>
     * <dt>使用条件
     * <dd>{@link EnterpriseException#EnterpriseException(String, Throwable, boolean, boolean)}
     * へ委譲されること。
     * </dl>
     * @param message メッセージ
     * @param cause 例外オブジェクト
     * @param enableSuppression 抑制の有無
     * @param writableStackTrace スタックトレース書込の可否
     */
    public RetryableException(final String message, final Throwable cause,
        final boolean enableSuppression, final boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
    /**
     * コンストラクタ
     * <dl>
     * <dt>使用条件
     * <dd>{@link EnterpriseException#EnterpriseException(String, Object...)} へ委譲されること。
     * </dl>
     * @param key キー
     * @param values オブジェクト配列
     */
    public RetryableException(final String key, final Object... values) {
        super(key, values);
    }
    /**
     * コンストラクタ
     * <dl>
     * <dt>使用条件
     * <dd>{@link EnterpriseException#EnterpriseException(Map)} へ委譲されること。
     * </dl>
     * @param messageMap {@link EnterpriseException#getMessageMap() メッセージマップ}
     */
    public RetryableException(final Map<String, Object[]> messageMap) {
        super(messageMap);
    }
}
// CHECKSTYLE:ON
