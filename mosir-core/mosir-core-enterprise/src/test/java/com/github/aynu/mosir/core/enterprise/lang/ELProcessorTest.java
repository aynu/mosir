// ----------------------------------------------------------------------------
// Copyright (C) Aynu Evolution Laboratory. All rights reserved.
// GNU GENERAL PUBLIC LICENSE Version 3, 29 June 2007
// http://www.gnu.org/licenses/gpl-3.0-standalone.html
// ----------------------------------------------------------------------------
package com.github.aynu.mosir.core.enterprise.lang;
import static org.hamcrest.Matchers.*;
import static org.junit.Assert.*;
import java.util.List;
import java.util.Map;
import javax.el.ELProcessor;
import org.junit.Test;
/**
 * @see ELProcessor
 * @author nilcy
 */
@SuppressWarnings({ "javadoc", "boxing", "unchecked" })
public class ELProcessorTest {
    ELProcessor testee = new ELProcessor();
    @Test
    public final void test() {
        assertThat((String) testee.eval("'Hello, world!'"), is("Hello, world!"));
        assertThat((Boolean) testee.eval("Boolean.TRUE"), is(true));
        assertThat((Integer) testee.eval("Integer.numberOfTrailingZeros(16)"), is(4));
        assertThat((String) testee.eval("10 += 11"), is("1011"));
        assertThat((Long) testee.eval("xx = 100; yy = 11; xx+yy"), is(111L));
        assertThat((Long) testee.eval("(x->x+1)(10)"), is(11L));
        assertThat((Long) testee.eval("fact = n->n==0? 1: n*fact(n-1); fact(5)"), is(120L));
        assertThat((List<String>) testee.eval("['eenie', 'meenie', 'miney', 'moe']"),
            hasItems("eenie", "meenie", "miney", "moe"));
        final Map<String, Long> mapActual = (Map<String, Long>) testee
            .eval("{'one':10, 'two':20, 'three':300}");
        assertThat(mapActual, hasEntry("one", 10L));
        assertThat(mapActual, hasEntry("two", 20L));
        assertThat(mapActual, hasEntry("three", 300L));
        assertThat(
            (List<Long>) testee
                .eval("[1,2,3,4,5,6,7,8].stream().filter(i->i%2 == 0).map(i->i*10).toList()"),
            hasItems(20L, 40L, 60L, 80L));
        assertThat(
            (List<Long>) testee.eval("[1,5,3,7,4,2,8].stream().sorted((i,j)->j-i).toList()"),
            hasItems(8L, 7L, 5L, 4L, 3L, 2L, 1L));
    }
}
