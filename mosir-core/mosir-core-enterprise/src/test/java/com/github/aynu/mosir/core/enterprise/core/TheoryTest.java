// ----------------------------------------------------------------------------
// Copyright (C) Aynu Evolution Laboratory. All rights reserved.
// GNU GENERAL PUBLIC LICENSE Version 3, 29 June 2007
// http://www.gnu.org/licenses/gpl-3.0-standalone.html
// ----------------------------------------------------------------------------
package com.github.aynu.mosir.core.enterprise.core;
import org.junit.experimental.theories.DataPoints;
import org.junit.experimental.theories.Theories;
import org.junit.experimental.theories.Theory;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
/**
 * @see Theory
 * @author nilcy
 */
@SuppressWarnings({ "javadoc", "static-method" })
@RunWith(Theories.class)
public class TheoryTest {
    private static final Logger LOG = LoggerFactory.getLogger(TheoryTest.class);
    @DataPoints
    public static String[] VARS = { "foo", "bar", "baz" };
    @Theory
    public void test(final String var) {
        LOG.debug("var : {}", var);
    }
    @Theory
    public void test(final String lhs, final String rhs) {
        LOG.debug("var : {} - {}", lhs, rhs);
    }
}
