// ----------------------------------------------------------------------------
// Copyright (C) Aynu Evolution Laboratory. All rights reserved.
// GNU GENERAL PUBLIC LICENSE Version 3, 29 June 2007
// http://www.gnu.org/licenses/gpl-3.0-standalone.html
// ----------------------------------------------------------------------------
package com.github.aynu.mosir.core.enterprise.persistence;
import java.lang.reflect.InvocationTargetException;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import org.apache.commons.beanutils.PropertyUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.github.aynu.mosir.core.enterprise.core.EnterpriseRuntimeException;
/**
 * 標準リポジトリ
 * @param <R> 基点エンティティ型
 * @author nilcy
 */
public class StandardRepositoryImpl<R extends Persistable> extends SimpleRepositoryImpl<R>
implements StandardRepository<R> {
    /** ロガー */
    private static final Logger LOG = LoggerFactory.getLogger(StandardRepositoryImpl.class);
    /**
     * コンストラクタ
     * @param clazz エンティティクラス
     * @param manager エンティティマネージャ
     */
    public StandardRepositoryImpl(final Class<R> clazz, final EntityManager manager) {
        super(clazz, manager);
    }
    /** {@inheritDoc} */
    @Override
    public R findOne(final String name, final R object, final String... fields)
        throws PersistenceException {
        try {
            final TypedQuery<R> query = getManager().createNamedQuery(name, getEntityClass());
            for (final Entry<String, Object> entry : filter(object, fields).entrySet()) {
                query.setParameter(entry.getKey(), entry.getValue());
            }
            return query.getSingleResult();
        } catch (final IllegalArgumentException | IllegalStateException
            | javax.persistence.PersistenceException e) {
            LOG.warn(e.toString(), e);
            throw new PersistenceException(e);
        }
    }
    /** {@inheritDoc} */
    @Override
    public Collection<R> findMany(final Object filter) throws PersistenceException {
        return null;
    }
    /**
     * 検索条件の作成
     * @param object 検索オブジェクト
     * @param fields 検索フィールド配列
     * @return 検索条件
     */
    protected Map<String, Object> filter(final R object, final String... fields) {
        final Map<String, Object> filter = new HashMap<>();
        for (final String field : fields) {
            try {
                filter.put(field, PropertyUtils.getSimpleProperty(object, field));
            } catch (IllegalAccessException | InvocationTargetException | NoSuchMethodException e) {
                throw new EnterpriseRuntimeException(e.getLocalizedMessage());
            }
        }
        return filter;
    }
}
