// ----------------------------------------------------------------------------
// Copyright (C) Aynu Evolution Laboratory. All rights reserved.
// GNU GENERAL PUBLIC LICENSE Version 3, 29 June 2007
// http://www.gnu.org/licenses/gpl-3.0-standalone.html
// ----------------------------------------------------------------------------
package com.github.aynu.mosir.core.enterprise.persistence;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import javax.persistence.EntityExistsException;
import javax.persistence.EntityManager;
import javax.persistence.TransactionRequiredException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
/**
 * 単純リポジトリ
 * @param <R> 基点エンティティ型
 * @author nilcy
 */
public class SimpleRepositoryImpl<R extends Persistable> implements SimpleRepository<R> {
    /** ロガー */
    private static final Logger LOG = LoggerFactory.getLogger(SimpleRepositoryImpl.class);
    /** エンティティクラス */
    private final Class<R> clazz;
    /** エンティティマネージャ */
    private final EntityManager manager;
    /**
     * コンストラクタ
     * @param clazz {@link #clazz エンティティクラス}
     * @param manager {@link #manager エンティティマネージャ}
     */
    public SimpleRepositoryImpl(final Class<R> clazz, final EntityManager manager) {
        this.clazz = clazz;
        this.manager = manager;
    }
    /** {@inheritDoc} */
    @Override
    public <S extends R> S save(final S entity) throws PersistenceException {
        beforeSave(entity);
        try {
            if (!entity.isPersisted()) {
                manager.persist(entity);
            } else {
                manager.merge(entity);
            }
        } catch (EntityExistsException | IllegalArgumentException | TransactionRequiredException e) {
            LOG.warn(e.toString(), e);
            throw new PersistenceException(e);
        }
        return entity;
    }
    /** {@inheritDoc} */
    @Override
    public <S extends R> Collection<S> save(final Iterable<S> entities) throws PersistenceException {
        final List<S> results = new ArrayList<>();
        for (final S entity : entities) {
            results.add(save(entity));
        }
        return results;
    }
    /** {@inheritDoc} */
    @Override
    public R find(final Object id) {
        return manager.find(clazz, id);
    }
    /** {@inheritDoc} */
    @Override
    public <S extends R> void delete(final S entity) throws PersistenceException {
        final S merged = manager.merge(entity);
        beforeDelete(merged);
        manager.remove(merged);
    }
    /** {@inheritDoc} */
    @Override
    public <S extends R> void delete(final Iterable<S> entities) throws PersistenceException {
        for (final S entity : entities) {
            delete(entity);
        }
    }
    /** {@inheritDoc} */
    @Override
    public void flush() throws PersistenceException {
        manager.flush();
    }
    /**
     * 保存前処理
     * @param <S> エンティティ型
     * @param entity エンティティ
     * @throws PersistenceException 保存の失敗
     */
    protected <S extends R> void beforeSave(final S entity) throws PersistenceException {
    }
    /**
     * 削除前処理
     * @param <S> エンティティ型
     * @param entity エンティティ
     * @throws PersistenceException 削除の失敗
     */
    protected <S extends R> void beforeDelete(final S entity) throws PersistenceException {
    }
    /**
     * {@link #clazz} の取得
     * @return {@link #clazz}
     */
    protected final Class<R> getEntityClass() {
        return clazz;
    }
    /**
     * {@link #manager} の取得
     * @return {@link #manager}
     */
    protected final EntityManager getManager() {
        return manager;
    }
}
