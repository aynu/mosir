// ----------------------------------------------------------------------------
// Copyright (C) Aynu Evolution Laboratory. All rights reserved.
// GNU GENERAL PUBLIC LICENSE Version 3, 29 June 2007
// http://www.gnu.org/licenses/gpl-3.0-standalone.html
// ----------------------------------------------------------------------------
package com.github.aynu.mosir.core.standard.util;
import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;
import java.awt.Dimension;
import org.apache.commons.configuration.ConfigurationException;
import org.junit.Test;
/**
 * @see PropertiesHelper
 * @author nilcy
 */
@SuppressWarnings({ "static-method", "javadoc", "unused" })
public class PropertiesHelperTest {
    @Test
    public void testSimple() {
        try {
            new PropertiesHelper("xxxx");
            fail();
        } catch (final RuntimeException e) {
        }
        final PropertiesHelper testee = new PropertiesHelper("usergui");
        assertThat(testee, is(not(nullValue())));
        assertThat(testee.getText("colors.background"), is("#FFFFFF"));
        assertThat(testee.getText("colors.foreground"), is("#000080"));
        assertThat(
            new Dimension(testee.getNumeric("window.width"), testee.getNumeric("window.height")),
            is(not(nullValue())));
        testee.setProperty("colors.foreground", "#000000");
        assertThat(testee.getText("colors.foreground"), is("#000000"));
        // testee.save();
        assertThat(testee.getText("key"), is("This \n string \t contains , escaped \\ characters"));
    }
    @Test
    public final void testVariable() throws ConfigurationException {
        final PropertiesHelper testee = new PropertiesHelper("application");
        assertThat(testee, is(not(nullValue())));
        assertThat(testee.getText("application.title"), is("Yukar Framework 0.0.1-SNAPSHOT"));
        assertArrayEquals(testee.getTexts("vars"), new Object[] { "foo", "bar", "baz" });
        testee.save();
        testee.setProperty("vars", "fuga,hoge");
        assertArrayEquals(testee.getTexts("vars"), new Object[] { "fuga", "hoge" });
    }
    @Test
    public final void testMessage() {
        final PropertiesHelper testee = new PropertiesHelper("error-messages");
        assertThat(testee, is(not(nullValue())));
        assertThat(testee.getText("UK", "設定", "name=日本,key=国番号"),
            is("一意キー制約の違反です。設定[name=日本,key=国番号]"));
    }
}
