// ----------------------------------------------------------------------------
// Copyright (C) Aynu Evolution Laboratory. All rights reserved.
// GNU GENERAL PUBLIC LICENSE Version 3, 29 June 2007
// http://www.gnu.org/licenses/gpl-3.0-standalone.html
// ----------------------------------------------------------------------------
package com.github.aynu.mosir.core.standard.lang;
import java.lang.reflect.ParameterizedType;
/**
 * データオブジェクトのファクトリ
 * <p>
 * データオブジェクトのファクトリ基本クラス。データオブジェクト固有のファクトリは本クラスを継承することで標準コンストラクタの呼出しが共通化される。
 * </p>
 * @param <T> データオブジェクト型
 * @author nilcy
 */
public abstract class AbstractFactory<T extends DataObject<T>> {
    /** コンストラクタ */
    protected AbstractFactory() {
    }
    /**
     * インスタンスの作成
     * @return インスタンス
     */
    @SuppressWarnings("unchecked")
    public T create() {
        try {
            return ((Class<T>) ((ParameterizedType) getClass().getGenericSuperclass())
                .getActualTypeArguments()[0]).newInstance();
        } catch (final InstantiationException e) {
            throw new StandardRuntimeException(e);
        } catch (final IllegalAccessException e) {
            throw new StandardRuntimeException(e);
        }
    }
}
