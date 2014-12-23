// ----------------------------------------------------------------------------
// Copyright (C) Aynu Evolution Laboratory. All rights reserved.
// GNU GENERAL PUBLIC LICENSE Version 3, 29 June 2007
// http://www.gnu.org/licenses/gpl-3.0-standalone.html
// ----------------------------------------------------------------------------
package com.github.aynu.mosir.core.enterprise.lang;
import static org.hamcrest.Matchers.*;
import static org.junit.Assert.*;
import org.junit.Test;
import com.github.aynu.mosir.core.enterprise.lang.CacheArea;
/**
 * @see CacheArea
 * @author nilcy
 */
@SuppressWarnings("static-method")
public class CacheAreaTest {
    /** @see CacheArea */
    @Test
    public void test() {
        assertThat(CacheArea.APPLICATION.name().toLowerCase(), is("application"));
        assertThat(CacheArea.SESSION.name().toLowerCase(), is("session"));
        assertThat(CacheArea.CONVERSATION.name().toLowerCase(), is("conversation"));
        assertThat(CacheArea.REQUEST.name().toLowerCase(), is("request"));
    }
}
