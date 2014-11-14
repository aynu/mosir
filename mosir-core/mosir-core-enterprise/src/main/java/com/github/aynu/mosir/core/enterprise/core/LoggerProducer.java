// ----------------------------------------------------------------------------
// Copyright (C) Aynu Evolution Laboratory. All rights reserved.
// GNU GENERAL PUBLIC LICENSE Version 3, 29 June 2007
// http://www.gnu.org/licenses/gpl-3.0-standalone.html
// ----------------------------------------------------------------------------
package com.github.aynu.mosir.core.enterprise.core;
import javax.enterprise.context.Dependent;
import javax.enterprise.inject.Produces;
import javax.enterprise.inject.spi.InjectionPoint;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
/**
 * ロガーのファクトリー
 * <dl>
 * <dt>使用条件
 * <dd><code>@Inject Logger log;</code>のようにDIで使用すること。
 * </dl>
 * @author nilcy
 */
@Dependent
@SuppressWarnings("static-method")
public class LoggerProducer {
    /** コンストラクタ */
    public LoggerProducer() {
    }
    /**
     * ロガーの作成
     * @param point 注入ポイント
     * @return ロガー
     */
    @Produces
    // @Default
    public Logger createLogger(final InjectionPoint point) {
        return LoggerFactory.getLogger(point.getMember().getDeclaringClass());
    }
}
