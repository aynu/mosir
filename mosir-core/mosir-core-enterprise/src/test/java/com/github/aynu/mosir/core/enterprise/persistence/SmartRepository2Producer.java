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
        return new SmartRepository2Impl<Testee, TesteeFilter>(Testee.class, manager) {
            @Override
            public Testee findOne(final TesteeFilter filter) throws PersistenceException {
                return null;
            }
            @Override
            public Collection<Testee> findMany(final TesteeFilter filter)
                throws PersistenceException {
                return null;
            }
            @Override
            public Collection<Testee> findMany(final TesteeFilter filter, final int first,
                final int max) throws PersistenceException {
                return null;
            }
        };
    }
}
