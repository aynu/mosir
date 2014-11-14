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
 * @see MessageHelper
 * @author nilcy
 */
@SuppressWarnings({ "static-method", "boxing" })
public class MessageHelperTest {
    /**
     * @see MessageHelper#createMessage(String, Object...)
     * @see MessageHelper#templateMessage(String, Object...)
     */
    @Test
    public void test() {
        CoverageHelper.privateConstructor(MessageHelper.class);
        assertThat(MessageHelper.createMessage("国を保存しました。(ID={0})", 1), is("国を保存しました。(ID=1)"));
        assertThat(MessageHelper.templateMessage("Country.SAVED_detail", 1), is("国を保存しました。(ID=1)"));
        assertThat(MessageHelper.templateMessage("Country.SAVED"), is("国を保存しました。"));
    }
}
