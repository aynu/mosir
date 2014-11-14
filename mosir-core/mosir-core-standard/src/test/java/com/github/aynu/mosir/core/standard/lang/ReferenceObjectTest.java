// ----------------------------------------------------------------------------
// Copyright (C) Aynu Evolution Laboratory. All rights reserved.
// GNU GENERAL PUBLIC LICENSE Version 3, 29 June 2007
// http://www.gnu.org/licenses/gpl-3.0-standalone.html
// ----------------------------------------------------------------------------
package com.github.aynu.mosir.core.standard.lang;
import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.junit.Test;
/**
 * @see ReferenceObject
 * @author shimokawa4955
 */
@SuppressWarnings({ "javadoc", "boxing" })
public class ReferenceObjectTest {
    @Test
    public void test() {
        final TesteeReferenceObject testee01a = new TesteeReferenceObject(1L);
        final TesteeReferenceObject testee01b = new TesteeReferenceObject(1L);
        final TesteeReferenceObject testee02 = new TesteeReferenceObject(2L);
        assertThat(testee01a, is(not(testee01b)));
        assertThat(testee01a.sameIdentityAs(testee01b), is(true));
        assertThat(testee01a.sameIdentityAs(testee02), is(false));
    }
    @SuppressWarnings({ "serial" })
    private class TesteeReferenceObject implements ReferenceObject<TesteeReferenceObject> {
        /** id */
        private final long id;
        /**
         * コンストラクタ
         * @param id {@link #id}
         */
        public TesteeReferenceObject(final long id) {
            this.id = id;
        }
        /** {@inheritDoc} */
        @Override
        public boolean sameIdentityAs(final TesteeReferenceObject object) {
            return (object != null) && new EqualsBuilder().append(id, object.id).isEquals();
        }
        /** {@inheritDoc} */
        @Override
        public Object identity() {
            return id;
        }
    }
}
