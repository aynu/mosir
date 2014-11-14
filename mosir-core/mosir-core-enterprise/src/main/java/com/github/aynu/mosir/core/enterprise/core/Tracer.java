// ----------------------------------------------------------------------------
// Copyright (C) Aynu Evolution Laboratory. All rights reserved.
// GNU GENERAL PUBLIC LICENSE Version 3, 29 June 2007
// http://www.gnu.org/licenses/gpl-3.0-standalone.html
// ----------------------------------------------------------------------------
package com.github.aynu.mosir.core.enterprise.core;
import static java.lang.annotation.ElementType.*;
import static java.lang.annotation.RetentionPolicy.*;
import java.lang.annotation.Inherited;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;
import javax.interceptor.InterceptorBinding;
/**
 * 追跡子
 * <dl>
 * <dt>使用条件
 * <dd>
 * <ol>
 * <li>処理を追跡するための印付けに使用すること。</li>
 * <li>印付けがあるとき、{@link TracerInterceptor 追跡子インターセプタ}が実行されること。</li>
 * </ol>
 * </dl>
 * @author nilcy
 */
@Inherited
@InterceptorBinding
@Retention(RUNTIME)
@Target({ METHOD, TYPE })
public @interface Tracer {
}
