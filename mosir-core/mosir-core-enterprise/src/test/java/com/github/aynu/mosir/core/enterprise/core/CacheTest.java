// ----------------------------------------------------------------------------
// Copyright (C) Aynu Evolution Laboratory. All rights reserved.
// GNU GENERAL PUBLIC LICENSE Version 3, 29 June 2007
// http://www.gnu.org/licenses/gpl-3.0-standalone.html
// ----------------------------------------------------------------------------
package com.github.aynu.mosir.core.enterprise.core;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import net.sf.ehcache.CacheManager;
/**
 * @see CacheManager
 * @author nilcy
 */
@SuppressWarnings("static-method")
public class CacheTest {
    /** ロガー */
    private static final Logger LOG = LoggerFactory.getLogger(CacheTest.class);
    /** @see CacheManager#getInstance() */
    @Test
    public void test() {
        for (final String name : CacheManager.getInstance().getCacheNames()) {
            LOG.debug("name={}", name);
        }
    }
}
