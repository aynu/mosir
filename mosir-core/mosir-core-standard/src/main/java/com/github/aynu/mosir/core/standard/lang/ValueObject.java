// ----------------------------------------------------------------------------
// Copyright (C) Aynu Evolution Laboratory. All rights reserved.
// GNU GENERAL PUBLIC LICENSE Version 3, 29 June 2007
// http://www.gnu.org/licenses/gpl-3.0-standalone.html
// ----------------------------------------------------------------------------
package com.github.aynu.mosir.core.standard.lang;
/**
 * 値オブジェクトI/F
 * <dl>
 * <dt>使用条件
 * <dd>
 * <ol>
 * <li>値オブジェクトは本I/Fを実装すること。</li>
 * <li>{@link DataObject データオブジェクトI/F} を実装すること。</li>
 * </ol>
 * </dl>
 * @param <VO> 値オブジェクト型
 * @author nilcy
 */
public interface ValueObject<VO extends ValueObject<VO>> extends DataObject<VO> {
    /**
     * 同一性の確認
     * <dl>
     * <dt>使用条件
     * <dd>値をもとに同一性が確認されること。
     * </dl>
     * @param object 比較対象オブジェクト
     * @return 同一なときTRUE。
     */
    boolean sameValueAs(VO object);
}
