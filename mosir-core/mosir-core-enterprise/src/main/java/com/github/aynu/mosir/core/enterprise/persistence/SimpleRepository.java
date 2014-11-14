// ----------------------------------------------------------------------------
// Copyright (C) Aynu Evolution Laboratory. All rights reserved.
// GNU GENERAL PUBLIC LICENSE Version 3, 29 June 2007
// http://www.gnu.org/licenses/gpl-3.0-standalone.html
// ----------------------------------------------------------------------------
package com.github.aynu.mosir.core.enterprise.persistence;
import java.util.Collection;
/**
 * 単純リポジトリI/F
 * @param <R> 基点エンティティ型
 * @author nilcy
 */
interface SimpleRepository<R extends Persistable> extends Repository {
    /**
     * 保存
     * @param <S> エンティティ型
     * @param entity エンティティ
     * @return 保存後エンティティ
     * @throws PersistenceException 保存の失敗
     */
    <S extends R> S save(S entity) throws PersistenceException;
    /**
     * 保存
     * @param <S> エンティティ型
     * @param entities エンティティ集合
     * @return 保存後エンティティ集合
     * @throws PersistenceException 保存の失敗
     */
    <S extends R> Collection<S> save(Iterable<S> entities) throws PersistenceException;
    /**
     * 検索
     * @param id 識別子(ID)
     * @return 該当エンティティ
     */
    R find(Object id);
    /**
     * 削除
     * @param <S> エンティティ型
     * @param entity エンティティ
     * @throws PersistenceException 削除の失敗
     */
    <S extends R> void delete(S entity) throws PersistenceException;
    /**
     * 削除
     * @param <S> エンティティ型
     * @param entities エンティティ
     * @throws PersistenceException 削除の失敗
     */
    <S extends R> void delete(Iterable<S> entities) throws PersistenceException;
    /**
     * 反映
     * @throws PersistenceException 反映の失敗
     */
    void flush() throws PersistenceException;
}
