// ----------------------------------------------------------------------------
// Copyright (C) Aynu Evolution Laboratory. All rights reserved.
// GNU GENERAL PUBLIC LICENSE Version 3, 29 June 2007
// http://www.gnu.org/licenses/gpl-3.0-standalone.html
// ----------------------------------------------------------------------------
package com.github.aynu.mosir.core.enterprise.persistence;
import java.util.Collection;
/**
 * 標準リポジトリI/F
 * @param <R> 基点エンティティ型
 * @author nilcy
 */
public interface StandardRepository<R extends Persistable> extends SimpleRepository<R> {
    /**
     * 単一検索
     * @param name クエリ名
     * @param object 検索オブジェクト
     * @param fields 検索フィールド配列
     * @return 該当エンティティ
     * @throws PersistenceException 検索の失敗
     */
    R findOne(final String name, final R object, final String... fields)
        throws PersistenceException;
    /**
     * 複数検索
     * @param filter 検索条件
     * @return 該当エンティティ集合
     * @throws PersistenceException 検索の失敗
     */
    Collection<R> findMany(Object filter) throws PersistenceException;
}
