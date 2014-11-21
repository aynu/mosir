// ----------------------------------------------------------------------------
// Copyright (C) Aynu Evolution Laboratory. All rights reserved.
// GNU GENERAL PUBLIC LICENSE Version 3, 29 June 2007
// http://www.gnu.org/licenses/gpl-3.0-standalone.html
// ----------------------------------------------------------------------------
package com.github.aynu.mosir.core.enterprise.persistence;
import java.util.Collection;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.github.aynu.mosir.core.enterprise.lang.EnterpriseRuntimeException;
/**
 * 先進リポジトリ
 * @param <R> 基点エンティティ型
 * @param <F> 検索条件オブジェクト型
 * @author nilcy
 */
public class SmartRepositoryImpl<R extends Persistable, F> extends SimpleRepositoryImpl<R>
    implements SmartRepository<R, F> {
    /** ロガー */
    private static final Logger LOG = LoggerFactory.getLogger(SmartRepositoryImpl.class);
    /** 先進リポジトリリスナー */
    private SmartRepositoryListener<R, F> listener;
    /** クライテリアビルダー */
    private CriteriaBuilder builder;
    /** クライテリアクエリー */
    private CriteriaQuery<R> query;
    /** クライテリアルート */
    private Root<R> root;
    /**
     * コンストラクタ
     * @param clazz エンティティクラス
     * @param manager エンティティマネージャ
     */
    public SmartRepositoryImpl(final Class<R> clazz, final EntityManager manager) {
        super(clazz, manager);
        try {
            this.listener = new SmartRepositoryListener<R, F>() {
                @Override
                public CriteriaQuery<R> query(final CriteriaBuilder builder,
                    final CriteriaQuery<R> query, final Root<R> root, final F filter) {
                    return query.select(root);
                }
            };
            reset();
        } catch (final IllegalStateException e) {
            LOG.warn(e.toString(), e);
            throw new EnterpriseRuntimeException(e.toString());
        }
    }
    /**
     * コンストラクタ
     * @param clazz エンティティクラス
     * @param manager エンティティマネージャ
     * @param listener {@link #listener}
     */
    public SmartRepositoryImpl(final Class<R> clazz, final EntityManager manager,
        final SmartRepositoryListener<R, F> listener) {
        this(clazz, manager);
        this.listener = listener;
        // reset();
    }
    public void reset() {
        this.builder = getManager().getCriteriaBuilder();
        this.query = this.builder.createQuery(getEntityClass());
        this.root = query().from(getEntityClass());
    }
    /**
     * クライテリアクエリーの作成
     * @return クライテリアクエリー
     */
    private CriteriaQuery<R> query() {
        // return getManager().getCriteriaBuilder().createQuery(getEntityClass());
        // return this.builder.createQuery(getEntityClass());
        return this.query;
    }
    /**
     * クエリールートの作成
     * @return クエリールート
     */
    private Root<R> root() {
        // return query().from(getEntityClass());
        return this.root;
    }
    /**
     * タイプドクエリーの作成
     * @param filter 検索条件オブジェクト
     * @return タイプドクエリー
     */
    private TypedQuery<R> query(final F filter) {
        // final CriteriaBuilder builder = getManager().getCriteriaBuilder();
        final CriteriaQuery<R> query = listener.query(builder, query(), root(), filter);
        return getManager().createQuery(query);
    }
    /** {@inheritDoc} */
    @Override
    public R findOne(final F filter) throws PersistenceException {
        return query(filter).getSingleResult();
    }
    /** {@inheritDoc} */
    @Override
    public Collection<R> findMany(final F filter) throws PersistenceException {
        return query(filter).getResultList();
    }
    /** {@inheritDoc} */
    @Override
    public Collection<R> findMany(final F filter, final int first, final int max)
        throws PersistenceException {
        return query(filter).setFirstResult(first).setMaxResults(max).getResultList();
    }
}
