// ----------------------------------------------------------------------------
// Copyright (C) Aynu Evolution Laboratory. All rights reserved.
// GNU GENERAL PUBLIC LICENSE Version 3, 29 June 2007
// http://www.gnu.org/licenses/gpl-3.0-standalone.html
// ----------------------------------------------------------------------------
package com.github.aynu.mosir.core.standard.util;
import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;
import org.junit.Test;
import com.github.aynu.mosir.core.testing.CoverageHelper;
/**
 * @see ConfigHelper
 * @author nilcy
 */
@SuppressWarnings("static-method")
public class ConfigHelperTest {
    /**
     * @see ConfigHelper#getText(String)
     * @see ConfigHelper#getTexts(String)
     */
    @Test
    public final void testSimple() {
        CoverageHelper.privateConstructor(ConfigHelper.class);
        assertThat(ConfigHelper.MESSAGE_BASENAME, is("messages"));
        assertThat(ConfigHelper.ERROR_MESSAGE_BASENAME, is("error-messages"));
        assertThat(ConfigHelper.INET_ADDRESS_CHARSET, is("UTF-8"));
        assertThat(ConfigHelper.getText("testee.var"), is("#FFFFFF"));
        assertArrayEquals(ConfigHelper.getTexts("testee.vars"),
            new Object[] { "foo", "bar", "baz" });
    }
}
