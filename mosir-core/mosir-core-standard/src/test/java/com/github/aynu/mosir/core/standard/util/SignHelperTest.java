// ----------------------------------------------------------------------------
// Copyright (C) Aynu Evolution Laboratory. All rights reserved.
// GNU GENERAL PUBLIC LICENSE Version 3, 29 June 2007
// http://www.gnu.org/licenses/gpl-3.0-standalone.html
// ----------------------------------------------------------------------------
package com.github.aynu.mosir.core.standard.util;
import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;
import java.security.KeyPair;
import org.junit.Test;
/**
 * @see SignHelper
 * @author nilcy
 */
@SuppressWarnings({ "static-method", "boxing", "javadoc" })
public class SignHelperTest {
    @Test
    public void test() {
        final KeyPair signKeyPair = SignHelper.createSignKeyPair();
        final byte[] sign = SignHelper.sign(signKeyPair.getPrivate(), "DATA".getBytes());
        assertThat(SignHelper.verify(signKeyPair.getPublic(), sign, "DATA".getBytes()), is(true));
    }
}
