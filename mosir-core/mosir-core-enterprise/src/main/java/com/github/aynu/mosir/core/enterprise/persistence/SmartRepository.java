// ----------------------------------------------------------------------------
// Copyright (C) Aynu Evolution Laboratory. All rights reserved.
// GNU GENERAL PUBLIC LICENSE Version 3, 29 June 2007
// http://www.gnu.org/licenses/gpl-3.0-standalone.html
// ----------------------------------------------------------------------------
package com.github.aynu.mosir.core.enterprise.persistence;
import java.util.Collection;
/**
 * 先進リポジトリI/F
 * @param <R> 基点エンティティ型
 * @param <F> 検索条件オブジェクト型
 * @author nilcy
 */
public interface SmartRepository<R extends Persistable, F> extends SimpleRepository<R> {
    /**
     * 単一検索
     * @param filter 検索条件オブジェクト
     * @return 該当エンティティ
     * @throws PersistenceException 検索の失敗
     */
    R findOne(final F filter) throws PersistenceException;
    /**
     * 複数検索
     * @param filter 検索条件オブジェクト
     * @return 該当エンティティ集合
     * @throws PersistenceException 検索の失敗
     */
    Collection<R> findMany(final F filter) throws PersistenceException;
    /**
     * 複数検索
     * @param filter 検索条件オブジェクト
     * @param first 開始位置
     * @param max 最大件数
     * @return 該当エンティティ集合
     * @throws PersistenceException 検索の失敗
     */
    Collection<R> findMany(final F filter, final int first, final int max)
        throws PersistenceException;
}
