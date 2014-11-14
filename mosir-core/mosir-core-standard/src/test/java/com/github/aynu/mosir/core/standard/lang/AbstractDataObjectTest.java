// ----------------------------------------------------------------------------
// Copyright (C) Aynu Evolution Laboratory. All rights reserved.
// GNU GENERAL PUBLIC LICENSE Version 3, 29 June 2007
// http://www.gnu.org/licenses/gpl-3.0-standalone.html
// ----------------------------------------------------------------------------
package com.github.aynu.mosir.core.standard.lang;
import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;
import org.junit.Test;
/**
 * @see AbstractDataObject
 * @author nilcy
 */
@SuppressWarnings("javadoc")
public class AbstractDataObjectTest {
    @SuppressWarnings("boxing")
    @Test
    public void test() {
        final TesteeDataObject testee01 = new TesteeDataObject("foo#01");
        final TesteeDataObject testee02 = new TesteeDataObject("foo#02");
        assertThat(testee01, is(not(testee02)));
        assertThat(testee01.hashCode(), is(not(testee02.hashCode())));
        assertThat(testee01.toString(), is("AbstractDataObjectTest.TesteeDataObject[foo=foo#01]"));
        assertThat(testee02.toString(), is("AbstractDataObjectTest.TesteeDataObject[foo=foo#02]"));
    }
    @SuppressWarnings("unused")
    private class TesteeDataObject extends AbstractDataObject<TesteeDataObject> {
        /** 識別番号 */
        private static final long serialVersionUID = 7533112117543810098L;
        /** foo */
        private String foo;
        /**
         * コンストラクタ
         * @param foo {@link #foo}
         */
        public TesteeDataObject(final String foo) {
            this.foo = foo;
        }
        /**
         * {@link #foo} の取得
         * @return {@link #foo}
         */
        public String getFoo() {
            return foo;
        }
        /**
         * {@link #foo} の設定
         * @param foo {@link #foo}
         */
        public void setFoo(final String foo) {
            this.foo = foo;
        }
    }
}
