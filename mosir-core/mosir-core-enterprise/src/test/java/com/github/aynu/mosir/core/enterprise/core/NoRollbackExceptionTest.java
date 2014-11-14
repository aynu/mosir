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
import com.github.aynu.mosir.core.enterprise.core.NoRollbackException;
/**
 * @see NoRollbackException
 * @author nilcy
 */
@SuppressWarnings("static-method")
public class NoRollbackExceptionTest {
    /**
     * @see NoRollbackException#NoRollbackException()
     * @see NoRollbackException#NoRollbackException(String)
     * @see NoRollbackException#NoRollbackException(Throwable)
     * @see NoRollbackException#NoRollbackException(String, Throwable)
     * @see NoRollbackException#NoRollbackException(String, Throwable, boolean, boolean)
     * @see NoRollbackException#NoRollbackException(String, Object...)
     * @see NoRollbackException#NoRollbackException(Map)
     * @see NoRollbackException#getApplicationMessage()
     */
    @Test
    public final void test() {
        try {
            throw new NoRollbackException();
        } catch (final NoRollbackException e) {
            assertThat(e.getApplicationMessage(), is(nullValue()));
        }
        try {
            throw new NoRollbackException("testee");
        } catch (final NoRollbackException e) {
            assertThat(e.getApplicationMessage(), is("testee"));
        }
        try {
            throw new NoRollbackException(new UnsupportedOperationException());
        } catch (final NoRollbackException e) {
            assertThat(e.getApplicationMessage(), is("java.lang.UnsupportedOperationException"));
        }
        try {
            throw new NoRollbackException("testee", new UnsupportedOperationException());
        } catch (final NoRollbackException e) {
            assertThat(e.getApplicationMessage(), is("testee"));
        }
        try {
            throw new NoRollbackException("testee", new UnsupportedOperationException(), true, true);
        } catch (final NoRollbackException e) {
            assertThat(e.getApplicationMessage(), is("testee"));
        }
        try {
            throw new NoRollbackException("Country.UK_code", "81");
        } catch (final NoRollbackException e) {
            assertThat(e.getApplicationMessage(), is("一意キー制約の違反です。国[国コード=81]"));
        }
        try {
            final Map<String, Object[]> messageMap = new LinkedHashMap<>();
            messageMap.put("Country.UK_code", new Object[] { "81" });
            messageMap.put("Country.UK_name", new Object[] { "Japan" });
            throw new NoRollbackException(messageMap);
        } catch (final NoRollbackException e) {
            assertThat(e.getApplicationMessage(),
                is("一意キー制約の違反です。国[国コード=81]\t一意キー制約の違反です。国[国名=Japan]"));
        }
    }
}
