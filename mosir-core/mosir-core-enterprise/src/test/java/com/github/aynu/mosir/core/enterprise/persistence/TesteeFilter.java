// ----------------------------------------------------------------------------
// Copyright (C) Aynu Evolution Laboratory. All rights reserved.
// GNU GENERAL PUBLIC LICENSE Version 3, 29 June 2007
// http://www.gnu.org/licenses/gpl-3.0-standalone.html
// ----------------------------------------------------------------------------
package com.github.aynu.mosir.core.enterprise.persistence;
import com.github.aynu.mosir.core.standard.lang.AbstractValueObject;
/**
 * テストエンティティ検索条件
 * @author nilcy
 */
public class TesteeFilter extends AbstractValueObject<TesteeFilter> implements SortableFilter {
    /** 識別番号 */
    private static final long serialVersionUID = 5270677421769642756L;
    /** 整列条件 */
    private final String[] orders;
    /** コード */
    private final String code;
    /**
     * コンストラクタ
     * @param code {@link #code}
     * @param orders {@link #orders}
     */
    public TesteeFilter(final String code, final String... orders) {
        this.code = code;
        this.orders = orders;
    }
    /**
     * {@link #orders} の取得
     * @return {@link #orders}
     */
    @Override
    public String[] getOrders() {
        return orders;
    }
    /**
     * {@link #code} の取得
     * @return {@link #code}
     */
    public final String getCode() {
        return code;
    }
}
