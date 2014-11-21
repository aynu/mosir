// ----------------------------------------------------------------------------
// Copyright (C) Aynu Evolution Laboratory. All rights reserved.
// GNU GENERAL PUBLIC LICENSE Version 3, 29 June 2007
// http://www.gnu.org/licenses/gpl-3.0-standalone.html
// ----------------------------------------------------------------------------
package com.github.aynu.mosir.core.enterprise.persistence;
import java.util.Collection;
import javax.enterprise.inject.Produces;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import org.apache.commons.lang3.StringUtils;
/**
 * @see SmartRepository
 * @see SmartRepositoryImpl
 * @author nilcy
 */
public class SmartRepository2Producer {
    /** エンティティマネージャ */
    @Inject
    private EntityManager manager;
    /** コンストラクタ */
    public SmartRepository2Producer() {
    }
    /**
     * 先進リポジトリの作成
     * @return 先進リポジトリ(テストエンティティ)
     */
    @Produces
    public SmartRepository2<Testee, TesteeFilter> createTestee() {
        return new AbstractSmartRepositoryImpl<Testee, TesteeFilter>(Testee.class, manager) {
            @Override
            public Testee findOne(final TesteeFilter filter) throws PersistenceException {
                final CriteriaBuilder builder = builder();
                final CriteriaQuery<Testee> query = query(builder);
                final Root<Testee> root = root(query);
                query.select(root);
                if (StringUtils.isNotEmpty(filter.getCode())) {
                    query.where(builder.equal(root.get("code"), filter.getCode()));
                }
                return getManager().createQuery(query).getSingleResult();
            }
            @Override
            public Collection<Testee> findMany(final TesteeFilter filter)
                throws PersistenceException {
                final CriteriaBuilder builder = builder();
                final CriteriaQuery<Testee> query = query(builder);
                final Root<Testee> root = root(query);
                query.select(root);
                if (StringUtils.isNotEmpty(filter.getCode())) {
                    query.where(builder.equal(root.get("code"), filter.getCode()));
                }
                return getManager().createQuery(query).getResultList();
            }
            @Override
            public Collection<Testee> findMany(final TesteeFilter filter, final int first,
                final int max) throws PersistenceException {
                final CriteriaBuilder builder = builder();
                final CriteriaQuery<Testee> query = query(builder);
                final Root<Testee> root = root(query);
                query.select(root);
                if (StringUtils.isNotEmpty(filter.getCode())) {
                    query.where(builder.equal(root.get("code"), filter.getCode()));
                }
                return getManager().createQuery(query).setFirstResult(first).setMaxResults(max)
                    .getResultList();
            }
        };
    }
}
