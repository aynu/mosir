// ----------------------------------------------------------------------------
// Copyright (C) Aynu Evolution Laboratory. All rights reserved.
// GNU GENERAL PUBLIC LICENSE Version 3, 29 June 2007
// http://www.gnu.org/licenses/gpl-3.0-standalone.html
// ----------------------------------------------------------------------------
package com.github.aynu.mosir.core.enterprise.persistence;
import static org.hamcrest.Matchers.*;
import static org.junit.Assert.*;
import org.junit.Test;
/**
 * @see TesteeFilter
 * @author nilcy
 */
@SuppressWarnings({ "static-method", "javadoc" })
public class TesteeFilterTest {
    @Test
    public final void test() {
        final TesteeFilter testee = new TesteeFilter("code#01");
        assertThat(testee.getCode(), is("code#01"));
    }
}
