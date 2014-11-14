// ----------------------------------------------------------------------------
// Copyright (C) Aynu Evolution Laboratory. All rights reserved.
// GNU GENERAL PUBLIC LICENSE Version 3, 29 June 2007
// http://www.gnu.org/licenses/gpl-3.0-standalone.html
// ----------------------------------------------------------------------------
package com.github.aynu.mosir.core.enterprise.core;
import static org.hamcrest.Matchers.*;
import static org.junit.Assert.*;
import java.util.LinkedHashMap;
import java.util.Map;
import org.junit.Test;
import com.github.aynu.mosir.core.enterprise.core.SkippableException;
/**
 * @see SkippableException
 * @author nilcy
 */
@SuppressWarnings("static-method")
public class SkippableExceptionTest {
    /**
     * @see SkippableException#SkippableException()
     * @see SkippableException#SkippableException(String)
     * @see SkippableException#SkippableException(Throwable)
     * @see SkippableException#SkippableException(String, Throwable)
     * @see SkippableException#SkippableException(String, Throwable, boolean, boolean)
     * @see SkippableException#SkippableException(String, Object...)
     * @see SkippableException#SkippableException(Map)
     * @see SkippableException#getApplicationMessage()
     */
    @Test
    public final void test() {
        try {
            throw new SkippableException();
        } catch (final SkippableException e) {
            assertThat(e.getApplicationMessage(), is(nullValue()));
        }
        try {
            throw new SkippableException("testee");
        } catch (final SkippableException e) {
            assertThat(e.getApplicationMessage(), is("testee"));
        }
        try {
            throw new SkippableException(new UnsupportedOperationException());
        } catch (final SkippableException e) {
            assertThat(e.getApplicationMessage(), is("java.lang.UnsupportedOperationException"));
        }
        try {
            throw new SkippableException("testee", new UnsupportedOperationException());
        } catch (final SkippableException e) {
            assertThat(e.getApplicationMessage(), is("testee"));
        }
        try {
            throw new SkippableException("testee", new UnsupportedOperationException(), true, true);
        } catch (final SkippableException e) {
            assertThat(e.getApplicationMessage(), is("testee"));
        }
        try {
            throw new SkippableException("Country.UK_code", "81");
        } catch (final SkippableException e) {
            assertThat(e.getApplicationMessage(), is("一意キー制約の違反です。国[国コード=81]"));
        }
        try {
            final Map<String, Object[]> messageMap = new LinkedHashMap<>();
            messageMap.put("Country.UK_code", new Object[] { "81" });
            messageMap.put("Country.UK_name", new Object[] { "Japan" });
            throw new SkippableException(messageMap);
        } catch (final SkippableException e) {
            assertThat(e.getApplicationMessage(),
                is("一意キー制約の違反です。国[国コード=81]\t一意キー制約の違反です。国[国名=Japan]"));
        }
    }
}
