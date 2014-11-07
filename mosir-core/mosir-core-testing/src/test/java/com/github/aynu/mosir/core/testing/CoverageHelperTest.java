// ----------------------------------------------------------------------------
// Copyright (C) Aynu Evolution Laboratory. All rights reserved.
// GNU GENERAL PUBLIC LICENSE Version 3, 29 June 2007
// http://www.gnu.org/licenses/gpl-3.0-standalone.html
// ----------------------------------------------------------------------------
package com.github.aynu.mosir.core.testing;
import static org.junit.Assert.*;
import org.junit.Test;
/**
 * @see CoverageHelper
 * @author nilcy
 */
@SuppressWarnings("static-method")
public class CoverageHelperTest {
    /**
     * @see CoverageHelper#privateConstructor(Class)
     */
    @Test
    public void test() {
        CoverageHelper.privateConstructor(CoverageHelper.class);
        try {
            CoverageHelper.privateConstructor(PrivateTestee.class);
            fail();
        } catch (final RuntimeException e) {
        }
    }
    /** プライベートクラス */
    private class PrivateTestee {
        /** プライベートコンストラクタ */
        private PrivateTestee() {
        }
    }
}
