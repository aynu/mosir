// ----------------------------------------------------------------------------
// Copyright (C) Aynu Evolution Laboratory. All rights reserved.
// GNU GENERAL PUBLIC LICENSE Version 3, 29 June 2007
// http://www.gnu.org/licenses/gpl-3.0-standalone.html
// ----------------------------------------------------------------------------
package com.github.aynu.mosir.core.enterprise.core;
import static org.hamcrest.Matchers.*;
import static org.junit.Assert.*;
import javax.cache.Cache;
import org.junit.Test;
import com.github.aynu.mosir.core.enterprise.core.CacheService;
/**
 * @see CacheService
 * @author nilcy
 */
@SuppressWarnings("static-method")
public class CacheServiceTest {
    /**
     * @see CacheService#getCache(String)
     * @see CacheService#createCache(String)
     */
    @Test
    public void test() {
        final CacheService<String, String> testee = new CacheService<>();
        assertThat(testee, is(not(nullValue())));
        Cache<String, String> var = testee.getCache("var");
        assertThat(var, is(nullValue()));
        var = testee.createCache("var");
        assertThat(var, is(not(nullValue())));
        var.put("foo", "foo#01");
        assertThat(var.get("foo"), is("foo#01"));
    }
}
