// ----------------------------------------------------------------------------
// Copyright (C) Aynu Evolution Laboratory. All rights reserved.
// GNU GENERAL PUBLIC LICENSE Version 3, 29 June 2007
// http://www.gnu.org/licenses/gpl-3.0-standalone.html
// ----------------------------------------------------------------------------
package com.github.aynu.mosir.core.standard.lang;
import org.apache.commons.lang3.builder.EqualsBuilder;
/**
 * (基底)値オブジェクト
 * <dl>
 * <dt>使用条件
 * <dd>値オブジェクトの基底クラスとすること。
 * </dl>
 * @param <T> データオブジェクト型
 * @author nilcy
 */
public abstract class AbstractValueObject<T extends ValueObject<T>> extends AbstractDataObject<T>
implements ValueObject<T> {
    /** 識別番号 */
    private static final long serialVersionUID = -8215359956960310982L;
    /** 一時項目の検査 */
    private static final boolean TEST_TRANSIENTS = false;
    /** コンストラクタ */
    public AbstractValueObject() {
    }
    /**
     * {@inheritDoc}
     * <dl>
     * <dt>使用条件
     * <dd>一時的(transient)な項目を除外して、リフレクションで全項目の同一性が確認されること。。
     * </dl>
     */
    @Override
    public boolean sameValueAs(final T object) {
        return EqualsBuilder.reflectionEquals(this, object, TEST_TRANSIENTS);
    }
}
