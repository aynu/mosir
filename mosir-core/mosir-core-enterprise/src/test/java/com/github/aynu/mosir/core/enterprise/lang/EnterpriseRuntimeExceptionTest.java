// ----------------------------------------------------------------------------
// Copyright (C) Aynu Evolution Laboratory. All rights reserved.
// GNU GENERAL PUBLIC LICENSE Version 3, 29 June 2007
// http://www.gnu.org/licenses/gpl-3.0-standalone.html
// ----------------------------------------------------------------------------
package com.github.aynu.mosir.core.enterprise.lang;
import static org.hamcrest.Matchers.*;
import static org.junit.Assert.*;
import org.junit.Test;
import com.github.aynu.mosir.core.enterprise.lang.EnterpriseRuntimeException;
/**
 * @see EnterpriseRuntimeException
 * @author nilcy
 */
@SuppressWarnings("static-method")
public class EnterpriseRuntimeExceptionTest {
    /**
     * @see EnterpriseRuntimeException#EnterpriseRuntimeException()
     * @see EnterpriseRuntimeException#EnterpriseRuntimeException(String)
     * @see EnterpriseRuntimeException#EnterpriseRuntimeException(Throwable)
     * @see EnterpriseRuntimeException#EnterpriseRuntimeException(String, Throwable)
     * @see EnterpriseRuntimeException#EnterpriseRuntimeException(String, Throwable, boolean,
     *      boolean)
     */
    @Test
    public final void test() {
        try {
            throw new EnterpriseRuntimeException();
        } catch (final EnterpriseRuntimeException e) {
            assertThat(e.getLocalizedMessage(), is(nullValue()));
        }
        try {
            throw new EnterpriseRuntimeException("testee");
        } catch (final EnterpriseRuntimeException e) {
            assertThat(e.getLocalizedMessage(), is("testee"));
        }
        try {
            throw new EnterpriseRuntimeException(new UnsupportedOperationException());
        } catch (final EnterpriseRuntimeException e) {
            assertThat(e.getLocalizedMessage(), is("java.lang.UnsupportedOperationException"));
        }
        try {
            throw new EnterpriseRuntimeException("testee", new UnsupportedOperationException());
        } catch (final EnterpriseRuntimeException e) {
            assertThat(e.getLocalizedMessage(), is("testee"));
        }
        try {
            throw new EnterpriseRuntimeException("testee", new UnsupportedOperationException(),
                true, true);
        } catch (final EnterpriseRuntimeException e) {
            assertThat(e.getLocalizedMessage(), is("testee"));
        }
    }
}
