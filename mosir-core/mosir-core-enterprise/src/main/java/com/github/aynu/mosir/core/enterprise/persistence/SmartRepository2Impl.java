// ----------------------------------------------------------------------------
// Copyright (C) Aynu Evolution Laboratory. All rights reserved.
// GNU GENERAL PUBLIC LICENSE Version 3, 29 June 2007
// http://www.gnu.org/licenses/gpl-3.0-standalone.html
// ----------------------------------------------------------------------------
package com.github.aynu.mosir.core.enterprise.persistence;
import java.util.Collection;
import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
/**
 * 先進リポジトリ
 * @param <R> 基点エンティティ型
 * @param <F> 検索条件オブジェクト型
 * @author nilcy
 */
public abstract class SmartRepository2Impl<R extends Persistable, F> extends
SimpleRepositoryImpl<R> implements SmartRepository2<R, F> {
    /**
     * コンストラクタ
     * @param clazz エンティティクラス
     * @param manager エンティティマネージャ
     */
    public SmartRepository2Impl(final Class<R> clazz, final EntityManager manager) {
        super(clazz, manager);
    }
    /**
     * クライテリアビルダーの作成
     * @return クライテリアビルダー
     */
    protected CriteriaBuilder builder() {
        return getManager().getCriteriaBuilder();
    }
    /**
     * クライテリアクエリーの作成
     * @return クライテリアクエリー
     */
    protected CriteriaQuery<R> query() {
        return builder().createQuery(getEntityClass());
    }
    /**
     * クエリールートの作成
     * @return クエリールート
     */
    protected Root<R> root() {
        return query().from(getEntityClass());
    }
    /** {@inheritDoc} */
    @Override
    public abstract R findOne(final F filter) throws PersistenceException;
    /** {@inheritDoc} */
    @Override
    public abstract Collection<R> findMany(final F filter) throws PersistenceException;
    /** {@inheritDoc} */
    @Override
    public abstract Collection<R> findMany(final F filter, final int first, final int max)
        throws PersistenceException;
}
