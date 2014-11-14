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
import com.github.aynu.mosir.core.enterprise.core.RetryableException;
/**
 * @see RetryableException
 * @author nilcy
 */
@SuppressWarnings("static-method")
public class RetryableExceptionTest {
    /**
     * @see RetryableException#RetryableException()
     * @see RetryableException#RetryableException(String)
     * @see RetryableException#RetryableException(Throwable)
     * @see RetryableException#RetryableException(String, Throwable)
     * @see RetryableException#RetryableException(String, Throwable, boolean, boolean)
     * @see RetryableException#RetryableException(String, Object...)
     * @see RetryableException#RetryableException(Map)
     * @see RetryableException#getApplicationMessage()
     */
    @Test
    public final void test() {
        try {
            throw new RetryableException();
        } catch (final RetryableException e) {
            assertThat(e.getApplicationMessage(), is(nullValue()));
        }
        try {
            throw new RetryableException("testee");
        } catch (final RetryableException e) {
            assertThat(e.getApplicationMessage(), is("testee"));
        }
        try {
            throw new RetryableException(new UnsupportedOperationException());
        } catch (final RetryableException e) {
            assertThat(e.getApplicationMessage(), is("java.lang.UnsupportedOperationException"));
        }
        try {
            throw new RetryableException("testee", new UnsupportedOperationException());
        } catch (final RetryableException e) {
            assertThat(e.getApplicationMessage(), is("testee"));
        }
        try {
            throw new RetryableException("testee", new UnsupportedOperationException(), true, true);
        } catch (final RetryableException e) {
            assertThat(e.getApplicationMessage(), is("testee"));
        }
        try {
            throw new RetryableException("Country.UK_code", "81");
        } catch (final RetryableException e) {
            assertThat(e.getApplicationMessage(), is("一意キー制約の違反です。国[国コード=81]"));
        }
        try {
            final Map<String, Object[]> messageMap = new LinkedHashMap<>();
            messageMap.put("Country.UK_code", new Object[] { "81" });
            messageMap.put("Country.UK_name", new Object[] { "Japan" });
            throw new RetryableException(messageMap);
        } catch (final RetryableException e) {
            assertThat(e.getApplicationMessage(),
                is("一意キー制約の違反です。国[国コード=81]\t一意キー制約の違反です。国[国名=Japan]"));
        }
    }
}
