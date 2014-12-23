// ----------------------------------------------------------------------------
// Copyright (C) Aynu Evolution Laboratory. All rights reserved.
// GNU GENERAL PUBLIC LICENSE Version 3, 29 June 2007
// http://www.gnu.org/licenses/gpl-3.0-standalone.html
// ----------------------------------------------------------------------------
package com.github.aynu.mosir.core.enterprise.lang;
import javax.ejb.ApplicationException;
import com.github.aynu.mosir.core.standard.lang.StandardRuntimeException;
/**
 * 基幹ランタイム例外
 * <dl>
 * <dt>使用条件
 * <dd>{@link StandardRuntimeException} へ準拠すること。ロールバックあり、継承あり。
 * </dl>
 * @author nilcy
 */
@ApplicationException(rollback = true, inherited = true)
public class EnterpriseRuntimeException extends StandardRuntimeException {
    /** 識別番号 */
    private static final long serialVersionUID = -1011000372434761952L;
    /**
     * コンストラクタ
     * <dl>
     * <dt>使用条件
     * <dd>{@link StandardRuntimeException#StandardRuntimeException()} へ準拠すること。
     * </dl>
     */
    public EnterpriseRuntimeException() {
    }
    /**
     * コンストラクタ
     * <dl>
     * <dt>使用条件
     * <dd>{@link StandardRuntimeException#StandardRuntimeException(String)} へ準拠すること。
     * </dl>
     * @param message メッセージ
     */
    public EnterpriseRuntimeException(final String message) {
        super(message);
    }
    /**
     * コンストラクタ
     * <dl>
     * <dt>使用条件
     * <dd>{@link StandardRuntimeException#StandardRuntimeException(Throwable)} へ準拠すること。
     * </dl>
     * @param cause 例外オブジェクト
     */
    public EnterpriseRuntimeException(final Throwable cause) {
        super(cause);
    }
    /**
     * コンストラクタ
     * <dl>
     * <dt>使用条件
     * <dd>{@link StandardRuntimeException#StandardRuntimeException(String, Throwable)} へ準拠すること。
     * </dl>
     * @param message メッセージ
     * @param cause 例外オブジェクト
     */
    public EnterpriseRuntimeException(final String message, final Throwable cause) {
        super(message, cause);
    }
    /**
     * コンストラクタ
     * <dl>
     * <dt>使用条件
     * <dd>
     * {@link StandardRuntimeException#StandardRuntimeException(String, Throwable, boolean, boolean)}
     * へ準拠すること。
     * </dl>
     * @param message メッセージ
     * @param cause 例外オブジェクト
     * @param enableSuppression 抑制の有無
     * @param writableStackTrace スタックトレース書込の可否
     */
    public EnterpriseRuntimeException(final String message, final Throwable cause,
        final boolean enableSuppression, final boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
