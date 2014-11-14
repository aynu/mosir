// ----------------------------------------------------------------------------
// Copyright (C) Aynu Evolution Laboratory. All rights reserved.
// GNU GENERAL PUBLIC LICENSE Version 3, 29 June 2007
// http://www.gnu.org/licenses/gpl-3.0-standalone.html
// ----------------------------------------------------------------------------
package com.github.aynu.mosir.core.standard.lang;
/**
 * 標準ランタイム例外
 * <dl>
 * <dt>使用条件
 * <dd>{@link RuntimeException} へ準拠すること。
 * </dl>
 * @author nilcy
 */
public class StandardRuntimeException extends RuntimeException {
    /** 識別番号 */
    private static final long serialVersionUID = -1011000372434761952L;
    /**
     * コンストラクタ
     * <dl>
     * <dt>使用条件
     * <dd>{@link RuntimeException#RuntimeException()} へ準拠すること。
     * </dl>
     */
    public StandardRuntimeException() {
    }
    /**
     * コンストラクタ
     * <dl>
     * <dt>使用条件
     * <dd>{@link RuntimeException#RuntimeException(String)} へ準拠すること。
     * </dl>
     * @param message メッセージ
     */
    public StandardRuntimeException(final String message) {
        super(message);
    }
    /**
     * コンストラクタ
     * <dl>
     * <dt>使用条件
     * <dd>{@link RuntimeException#RuntimeException(Throwable)} へ準拠すること。
     * </dl>
     * @param cause 例外オブジェクト
     */
    public StandardRuntimeException(final Throwable cause) {
        super(cause);
    }
    /**
     * コンストラクタ
     * <dl>
     * <dt>使用条件
     * <dd>{@link RuntimeException#RuntimeException(String, Throwable)} へ準拠すること。
     * </dl>
     * @param message メッセージ
     * @param cause 例外オブジェクト
     */
    public StandardRuntimeException(final String message, final Throwable cause) {
        super(message, cause);
    }
    /**
     * コンストラクタ
     * <dl>
     * <dt>使用条件
     * <dd>{@link RuntimeException#RuntimeException(String, Throwable, boolean, boolean)} へ準拠すること。
     * </dl>
     * @param message メッセージ
     * @param cause 例外オブジェクト
     * @param enableSuppression 抑制の有無
     * @param writableStackTrace スタックトレース書込の可否
     */
    public StandardRuntimeException(final String message, final Throwable cause,
        final boolean enableSuppression, final boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
