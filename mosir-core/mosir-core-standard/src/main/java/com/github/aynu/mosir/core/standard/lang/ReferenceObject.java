// ----------------------------------------------------------------------------
// Copyright (C) Aynu Evolution Laboratory. All rights reserved.
// GNU GENERAL PUBLIC LICENSE Version 3, 29 June 2007
// http://www.gnu.org/licenses/gpl-3.0-standalone.html
// ----------------------------------------------------------------------------
package com.github.aynu.mosir.core.standard.lang;
/**
 * 参照オブジェクトI/F
 * <dl>
 * <dt>使用条件
 * <dd>
 * <ol>
 * <li>参照オブジェクトは本I/Fを実装すること。</li>
 * <li>{@link DataObject データオブジェクトI/F} を実装すること。</li>
 * </ol>
 * </dl>
 * @param <RO> 参照オブジェクト型
 * @author nilcy
 */
public interface ReferenceObject<RO extends ReferenceObject<RO>> extends DataObject<RO> {
    /**
     * 同一性の確認
     * <dl>
     * <dt>使用条件
     * <dd>識別子(ID)をもとに同一性が確認されること。
     * </dl>
     * @param object 比較対象オブジェクト
     * @return 同一なときTRUE。同一でないときFALSE。
     */
    boolean sameIdentityAs(RO object);
    /**
     * 識別子(ID)
     * @return 識別子(ID)
     */
    Object identity();
}
