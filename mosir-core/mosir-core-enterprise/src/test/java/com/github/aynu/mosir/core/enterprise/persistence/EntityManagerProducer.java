// ----------------------------------------------------------------------------
// Copyright (C) Aynu Evolution Laboratory. All rights reserved.
// GNU GENERAL PUBLIC LICENSE Version 3, 29 June 2007
// http://www.gnu.org/licenses/gpl-3.0-standalone.html
// ----------------------------------------------------------------------------
package com.github.aynu.mosir.core.enterprise.persistence;
import javax.enterprise.inject.Produces;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
/**
 * @see EntityManager
 * @author nilcy
 */
public class EntityManagerProducer {
    /** エンティティマネージャ */
    @PersistenceContext(unitName = "primary")
    @Produces
    private EntityManager manager;
    /**
     * {@link #manager} の取得
     * @return {@link #manager}
     */
    public EntityManager getManager() {
        System.out.println("-------- nilcy --------");
        System.out.println("manager is " + manager);
        return manager;
    }
}
