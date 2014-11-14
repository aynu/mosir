// ----------------------------------------------------------------------------
// Copyright (C) Aynu Evolution Laboratory. All rights reserved.
// GNU GENERAL PUBLIC LICENSE Version 3, 29 June 2007
// http://www.gnu.org/licenses/gpl-3.0-standalone.html
// ----------------------------------------------------------------------------
package com.github.aynu.mosir.core.standard.util;
import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.number.IsCloseTo.*;
import static org.junit.Assert.*;
import java.security.KeyPair;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.security.interfaces.RSAPrivateKey;
import java.security.interfaces.RSAPublicKey;
import javax.crypto.SecretKey;
import javax.crypto.spec.IvParameterSpec;
import org.junit.Test;
/**
 * @see SecurityHelper
 * @author nilcy
 */
@SuppressWarnings({ "static-method", "boxing", "javadoc" })
public class SecurityHelperTest {
    /**
     * @throws NoSuchAlgorithmException 該当アルゴリズムなし例外
     * @see SecurityHelper#getSecureRandom()
     */
    @Test
    public void testSecureRandom() throws NoSuchAlgorithmException {
        final SecureRandom testee = SecurityHelper.getSecureRandom();
        assertThat(testee, is(not(nullValue())));
        for (int i = 0; i < 1000; ++i) {
            assertThat(testee.nextDouble(), is(closeTo(0, 1.0)));
        }
    }
    @Test
    public void test() {
        final KeyPair keyPair = SecurityHelper.createKeyPair();
        assertThat(keyPair, is(not(nullValue())));
        final RSAPublicKey publicKey = SecurityHelper.createPublicKey(
            ((RSAPublicKey) keyPair.getPublic()).getModulus(),
            ((RSAPublicKey) keyPair.getPublic()).getPublicExponent());
        final RSAPrivateKey privateKey = SecurityHelper.createPrivateKey(
            ((RSAPrivateKey) keyPair.getPrivate()).getModulus(),
            ((RSAPrivateKey) keyPair.getPrivate()).getPrivateExponent());
        assertThat(publicKey.getEncoded(), is(keyPair.getPublic().getEncoded()));
        final SecretKey secretKey = SecurityHelper.createSecretKey("hello, world!!".toCharArray(),
            new byte[] { 1 });
        assertThat(secretKey, is(not(nullValue())));
        final byte[] encrypted = SecurityHelper.encrypt(publicKey, secretKey.getEncoded());
        final byte[] decrypted = SecurityHelper.decrypt(privateKey, encrypted);
        assertThat(decrypted, is(secretKey.getEncoded()));
        // ----
        final SecretKey secretKey2 = SecurityHelper.createSecretKey("1234567890123456".getBytes());
        final IvParameterSpec iv = new IvParameterSpec("abcdefghijklmnop".getBytes());
        final byte[] encrypted2 = SecurityHelper.encrypt(secretKey2, iv, "BIGDATA".getBytes());
        final byte[] decrypted2 = SecurityHelper.decrypt(secretKey2, iv, encrypted2);
        assertThat(decrypted2, is("BIGDATA".getBytes()));
    }
}
