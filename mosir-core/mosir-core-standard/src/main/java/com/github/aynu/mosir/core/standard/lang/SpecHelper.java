// ----------------------------------------------------------------------------
// Copyright (C) Aynu Evolution Laboratory. All rights reserved.
// GNU GENERAL PUBLIC LICENSE Version 3, 29 June 2007
// http://www.gnu.org/licenses/gpl-3.0-standalone.html
// ----------------------------------------------------------------------------
package com.github.aynu.mosir.core.standard.lang;
import org.apache.commons.lang3.Validate;
/**
 * 仕様オブジェクトヘルパー
 * <dl>
 * <dt>使用条件
 * <dd>{@link Spec 仕様オブジェクトI/F}のヘルパーとして使用すること。
 * </dl>
 * @author nilcy
 */
public final class SpecHelper {
    /** 非公開コンストラクタ */
    private SpecHelper() {
    }
    /**
     * 否定(NOT)仕様オブジェクトの作成
     * @param <T> 仕様オブジェクトのタイプ
     * @param spec 仕様オブジェクト
     * @return 否定(NOT)仕様オブジェクト
     */
    public static <T> Spec<T> not(final Spec<T> spec) {
        Validate.notNull(spec);
        return new AbstractSpec<T>(spec) {
            /** {@inheritDoc} */
            @Override
            public boolean isSatisfiedBy(final T object) {
                return !getSpec1().isSatisfiedBy(object);
            }
        };
    }
}
