// ----------------------------------------------------------------------------
// Copyright (C) Aynu Evolution Laboratory. All rights reserved.
// GNU GENERAL PUBLIC LICENSE Version 3, 29 June 2007
// http://www.gnu.org/licenses/gpl-3.0-standalone.html
// ----------------------------------------------------------------------------
package com.github.aynu.mosir.core.enterprise.core;
import java.util.logging.Logger;
import javax.annotation.Resource;
import javax.ejb.SessionContext;
import javax.interceptor.AroundInvoke;
import javax.interceptor.Interceptor;
import javax.interceptor.InvocationContext;
import com.github.aynu.mosir.core.standard.util.MessageHelper;
/**
 * 追跡子インターセプタ
 * <dl>
 * <dt>使用条件
 * <dd>
 * <ol>
 * <li>CDI定義(beans.xml)の interceptors->class へ指定すること。</li>
 * <li>メソッドI/Oログを出力するとき、該当クラス/メソッドへ{@link Tracer 追跡子}を指定すること。</li>
 * </ol>
 * </dl>
 * @author nilcy
 */
@Interceptor
@Tracer
public class TracerInterceptor {
    /** セッションコンテキスト */
    @Resource
    private SessionContext sessionContext;
    /** コンストラクタ */
    public TracerInterceptor() {
    }
    /**
     * メソッドI/Oログの出力
     * <dl>
     * <dt>使用条件
     * <dd>
     * <ol>
     * <li>メソッドが開始するとき、{@link Logger#entering(String, String, Object[])}へ委譲されること。</li>
     * <li>メソッドが正常終了のとき、{@link Logger#exiting(String, String, Object)}へ委譲されること。</li>
     * <li>メソッドが異常終了のとき、{@link Logger#warning(String)}へ委譲されること。</li>
     * </ol>
     * </dl>
     * @param context コンテキスト
     * @return 処理結果
     * @throws Exception 処理例外
     */
    @AroundInvoke
    public Object traceLog(final InvocationContext context) throws Exception {
        final String sourceClass = context.getMethod().getDeclaringClass().getName();
        final Logger log = Logger.getLogger(sourceClass);
        if (sessionContext != null) {
            log.fine(MessageHelper.createMessage("caller principal is [{0}]",
                sessionContext.getCallerPrincipal()));
        }
        final String sourceMethod = context.getMethod().getName();
        log.entering(sourceClass, sourceMethod, context.getParameters());
        try {
            final Object result = context.proceed();
            log.exiting(sourceClass, sourceMethod, result);
            return result;
        } catch (final Exception e) {
            // Ok to catch Exception here
            log.warning(e.getLocalizedMessage());
            throw e;
        }
    }
}
