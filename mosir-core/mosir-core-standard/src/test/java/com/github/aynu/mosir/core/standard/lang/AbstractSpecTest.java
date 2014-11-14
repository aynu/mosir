// ----------------------------------------------------------------------------
// Copyright (C) Aynu Evolution Laboratory. All rights reserved.
// GNU GENERAL PUBLIC LICENSE Version 3, 29 June 2007
// http://www.gnu.org/licenses/gpl-3.0-standalone.html
// ----------------------------------------------------------------------------
package com.github.aynu.mosir.core.standard.lang;
import static com.github.aynu.mosir.core.standard.lang.SpecHelper.*;
import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;
import org.junit.Test;
import com.github.aynu.mosir.core.testing.CoverageHelper;
/**
 * @see AbstractSpec
 * @see SpecHelper
 * @author nilcy
 */
@SuppressWarnings({ "static-method", "boxing" })
public class AbstractSpecTest {
    /** true specification */
    private final Spec<Object> trueSpec = new AbstractSpec<Object>() {
        @Override
        public boolean isSatisfiedBy(final Object object) {
            return true;
        }
    };
    /** false specification */
    private final Spec<Object> falseSpec = new AbstractSpec<Object>() {
        @Override
        public boolean isSatisfiedBy(final Object object) {
            return false;
        }
    };
    /** 非公開コンストラクタ */
    @Test
    public void testConstructor() {
        CoverageHelper.privateConstructor(SpecHelper.class);
    }
    /** @see AbstractSpec#and(Spec) */
    @Test
    public void testAnd() {
        assertThat(trueSpec.and(trueSpec).isSatisfiedBy(null), is(true));
        assertThat(trueSpec.and(falseSpec).isSatisfiedBy(null), is(false));
        assertThat(falseSpec.and(trueSpec).isSatisfiedBy(null), is(false));
        assertThat(falseSpec.and(falseSpec).isSatisfiedBy(null), is(false));
    }
    /** @see AbstractSpec#or(Spec) */
    @Test
    public void testOr() {
        assertThat(trueSpec.or(trueSpec).isSatisfiedBy(null), is(true));
        assertThat(trueSpec.or(falseSpec).isSatisfiedBy(null), is(true));
        assertThat(falseSpec.or(trueSpec).isSatisfiedBy(null), is(true));
        assertThat(falseSpec.or(falseSpec).isSatisfiedBy(null), is(false));
    }
    /** @see AbstractSpec#xor(Spec) */
    @Test
    public void testXor() {
        assertThat(trueSpec.xor(trueSpec).isSatisfiedBy(null), is(false));
        assertThat(trueSpec.xor(falseSpec).isSatisfiedBy(null), is(true));
        assertThat(falseSpec.xor(trueSpec).isSatisfiedBy(null), is(true));
        assertThat(falseSpec.xor(falseSpec).isSatisfiedBy(null), is(false));
    }
    /** @see AbstractSpec#nand(Spec) */
    @Test
    public void testNand() {
        assertThat(trueSpec.nand(trueSpec).isSatisfiedBy(null), is(false));
        assertThat(trueSpec.nand(falseSpec).isSatisfiedBy(null), is(true));
        assertThat(falseSpec.nand(trueSpec).isSatisfiedBy(null), is(true));
        assertThat(falseSpec.nand(falseSpec).isSatisfiedBy(null), is(true));
    }
    /** @see AbstractSpec#nor(Spec) */
    @Test
    public void testNor() {
        assertThat(trueSpec.nor(trueSpec).isSatisfiedBy(null), is(false));
        assertThat(trueSpec.nor(falseSpec).isSatisfiedBy(null), is(false));
        assertThat(falseSpec.nor(trueSpec).isSatisfiedBy(null), is(false));
        assertThat(falseSpec.nor(falseSpec).isSatisfiedBy(null), is(true));
    }
    /** @see SpecHelper#not(Spec) */
    @Test
    public void testNot() {
        assertThat(not(trueSpec.and(trueSpec)).isSatisfiedBy(null), is(false));
        assertThat(not(trueSpec.and(falseSpec)).isSatisfiedBy(null), is(true));
        assertThat(not(falseSpec.and(trueSpec)).isSatisfiedBy(null), is(true));
        assertThat(not(falseSpec.and(falseSpec)).isSatisfiedBy(null), is(true));
    }
}
