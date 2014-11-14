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
 * @see ValueObject
 * @see AbstractValueObject
 * @author shimokawa4955
 */
@SuppressWarnings({ "javadoc", "boxing" })
public class AbstractValueObjectTest {
    @Test
    public void test() {
        final TesteeValueObject testee01a = new TesteeValueObject("foo#01", "tmp#01");
        final TesteeValueObject testee01b = new TesteeValueObject("foo#01", "tmp#02");
        final TesteeValueObject testee02 = new TesteeValueObject("foo#02", "tmp#01");
        assertThat(testee01a, is(not(testee01b)));
        assertThat(testee01a.sameValueAs(testee01b), is(true));
        assertThat(testee01a.sameValueAs(testee02), is(false));
    }
    @SuppressWarnings("unused")
    private class TesteeValueObject extends AbstractValueObject<TesteeValueObject> {
        /** 識別番号 */
        private static final long serialVersionUID = 7533112117543810098L;
        /** foo */
        private String foo;
        /** tmp */
        private transient String tmp;
        /**
         * コンストラクタ
         * @param foo {@link #foo}
         * @param tmp {@link #tmp}
         */
        public TesteeValueObject(final String foo, final String tmp) {
            this.foo = foo;
            this.tmp = tmp;
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
        /**
         * {@link #tmp} の取得
         * @return {@link #tmp}
         */
        public String getTmp() {
            return tmp;
        }
        /**
         * {@link #tmp} の設定
         * @param tmp {@link #tmp}
         */
        public void setTmp(final String tmp) {
            this.tmp = tmp;
        }
    }
}
