// ----------------------------------------------------------------------------
// Copyright (C) Aynu Evolution Laboratory. All rights reserved.
// GNU GENERAL PUBLIC LICENSE Version 3, 29 June 2007
// http://www.gnu.org/licenses/gpl-3.0-standalone.html
// ----------------------------------------------------------------------------
package com.github.aynu.mosir.core.standard.lang;
import org.apache.commons.lang3.Validate;
/**
 * 仕様オブジェクト基底クラス
 * <dl>
 * <dt>使用条件
 * <dd>
 * <ol>
 * <li>{@link Spec 仕様オブジェクトI/F} が実装されること。</li>
 * <li>仕様オブジェクトの数に応じたコンストラクタでインスタンス化すること。</li>
 * <li>仕様オブジェクトは本クラスを継承して実装すること。</li>
 * </ol>
 * </dl>
 * @param <T> 仕様オブジェクトのタイプ
 * @author nilcy
 */
public abstract class AbstractSpec<T> implements Spec<T> {
    /** 仕様オブジェクト#1 */
    private final Spec<T> spec1;
    /** 仕様オブジェクト#2 */
    private final Spec<T> spec2;
    /**
     * コンストラクタ
     * <dl>
     * <dt>使用条件
     * <dd>仕様オブジェクトを使わないとき使用する。
     * </dl>
     */
    public AbstractSpec() {
        this.spec1 = null;
        this.spec2 = null;
    }
    /**
     * コンストラクタ
     * <dl>
     * <dt>使用条件
     * <dd>1つの仕様オブジェクトを使うとき使用する。(NOTなど)
     * </dl>
     * @param spec1 仕様オブジェクト#1
     */
    public AbstractSpec(final Spec<T> spec1) {
        Validate.notNull(spec1);
        this.spec1 = spec1;
        this.spec2 = null;
    }
    /**
     * コンストラクタ
     * <dl>
     * <dt>使用条件
     * <dd>2つの仕様オブジェクトを使うとき使用する。(AND/OR/XOR/NAND/NORなど)
     * </dl>
     * @param spec1 仕様オブジェクト#1
     * @param spec2 仕様オブジェクト#2
     */
    public AbstractSpec(final Spec<T> spec1, final Spec<T> spec2) {
        Validate.notNull(spec1);
        Validate.notNull(spec2);
        this.spec1 = spec1;
        this.spec2 = spec2;
    }
    /** {@inheritDoc} */
    @Override
    public abstract boolean isSatisfiedBy(T object);
    /** {@inheritDoc} */
    @Override
    public final Spec<T> and(final Spec<T> spec) {
        Validate.notNull(spec);
        return new AbstractSpec<T>(this, spec) {
            /** {@inheritDoc} */
            @Override
            public boolean isSatisfiedBy(final T object) {
                return getSpec1().isSatisfiedBy(object) && getSpec2().isSatisfiedBy(object);
            }
        };
    }
    /** {@inheritDoc} */
    @Override
    public final Spec<T> or(final Spec<T> spec) {
        Validate.notNull(spec);
        return new AbstractSpec<T>(this, spec) {
            /** {@inheritDoc} */
            @Override
            public boolean isSatisfiedBy(final T object) {
                return getSpec1().isSatisfiedBy(object) || getSpec2().isSatisfiedBy(object);
            }
        };
    }
    /** {@inheritDoc} */
    @Override
    public final Spec<T> xor(final Spec<T> spec) {
        Validate.notNull(spec);
        return new AbstractSpec<T>(this, spec) {
            /** {@inheritDoc} */
            @Override
            public boolean isSatisfiedBy(final T object) {
                return (getSpec1().isSatisfiedBy(object) && !getSpec2().isSatisfiedBy(object))
                    || (!getSpec1().isSatisfiedBy(object) && getSpec2().isSatisfiedBy(object));
            }
        };
    }
    /** {@inheritDoc} */
    @Override
    public final Spec<T> nand(final Spec<T> spec) {
        Validate.notNull(spec);
        return new AbstractSpec<T>(this, spec) {
            /** {@inheritDoc} */
            @Override
            public boolean isSatisfiedBy(final T object) {
                return !(getSpec1().isSatisfiedBy(object) && getSpec2().isSatisfiedBy(object));
            }
        };
    }
    /** {@inheritDoc} */
    @Override
    public final Spec<T> nor(final Spec<T> spec) {
        Validate.notNull(spec);
        return new AbstractSpec<T>(this, spec) {
            /** {@inheritDoc} */
            @Override
            public boolean isSatisfiedBy(final T object) {
                return !(getSpec1().isSatisfiedBy(object) || getSpec2().isSatisfiedBy(object));
            }
        };
    }
    /**
     * {@link #spec1} の取得
     * @return {@link #spec1}
     */
    final Spec<T> getSpec1() {
        return spec1;
    }
    /**
     * {@link #spec2} の取得
     * @return {@link #spec2}
     */
    final Spec<T> getSpec2() {
        return spec2;
    }
}
