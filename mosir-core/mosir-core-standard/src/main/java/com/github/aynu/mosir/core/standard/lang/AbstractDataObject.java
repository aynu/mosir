// ----------------------------------------------------------------------------
// Copyright (C) Aynu Evolution Laboratory. All rights reserved.
// GNU GENERAL PUBLIC LICENSE Version 3, 29 June 2007
// http://www.gnu.org/licenses/gpl-3.0-standalone.html
// ----------------------------------------------------------------------------
package com.github.aynu.mosir.core.standard.lang;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
/**
 * (基底)データオブジェクト
 * <dl>
 * <dt>使用条件
 * <dd>データオブジェクトの基底クラスとすること。
 * </dl>
 * @param <T> データオブジェクト型
 * @author nilcy
 */
public abstract class AbstractDataObject<T extends DataObject<T>> implements DataObject<T> {
    /** 識別番号 */
    private static final long serialVersionUID = 713428173593081041L;
    /** 一時項目の検査 */
    private static final boolean TEST_TRANSIENTS = true;
    /** 一時項目の出力 */
    private static final boolean OUTPUT_TRANSIENTS = true;
    /** コンストラクタ */
    public AbstractDataObject() {
    }
    /**
     * {@inheritDoc}
     * <dl>
     * <dt>使用条件
     * <dd>一時的(transient)な項目を含めて、リフレクションで全項目のハッシュコードが作成されること。。
     * </dl>
     */
    @Override
    public int hashCode() {
        return HashCodeBuilder.reflectionHashCode(this, TEST_TRANSIENTS);
    }
    /**
     * {@inheritDoc}
     * <dl>
     * <dt>使用条件
     * <dd>一時的(transient)な項目を含めて、リフレクションで全項目の同一性が確認されること。。
     * </dl>
     */
    @Override
    public boolean equals(final Object obj) {
        return EqualsBuilder.reflectionEquals(this, obj, TEST_TRANSIENTS);
    }
    /**
     * {@inheritDoc}
     * <dl>
     * <dt>使用条件
     * <dd>一時的(transient)な項目を含めて、リフレクションで全項目のテキスト値が作成されること。
     * </dl>
     */
    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this, ToStringStyle.SHORT_PREFIX_STYLE,
            OUTPUT_TRANSIENTS);
    }
}
