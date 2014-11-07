// ----------------------------------------------------------------------------
// Copyright (C) Aynu Evolution Laboratory. All rights reserved.
// GNU GENERAL PUBLIC LICENSE Version 3, 29 June 2007
// http://www.gnu.org/licenses/gpl-3.0-standalone.html
// ----------------------------------------------------------------------------
package com.github.aynu.mosir.core.testing;
import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;
import org.jboss.shrinkwrap.api.Archive;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.spec.WebArchive;
import org.junit.Test;
/**
 * @see ArchiveHelper
 * @author nilcy
 */
public class ArchiveHelperTest {
    /**
     * @see ArchiveHelper#trace(org.jboss.shrinkwrap.api.Archive)
     */
    @SuppressWarnings({ "static-method", "boxing" })
    @Test
    public void test() {
        CoverageHelper.privateConstructor(ArchiveHelper.class);
        final Archive<?> archive = ShrinkWrap.create(WebArchive.class).addPackages(true,
            "com.github.aynu.mosir");
        final String trace = ArchiveHelper.trace(archive);
        assertThat(trace, is(not(nullValue())));
        assertThat(trace.startsWith("/WEB-INF/"), is(true));
        assertThat(trace.endsWith(".class\n"), is(true));
    }
}
