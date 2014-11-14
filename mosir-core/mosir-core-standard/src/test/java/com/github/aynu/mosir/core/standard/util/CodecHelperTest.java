// ----------------------------------------------------------------------------
// Copyright (C) Aynu Evolution Laboratory. All rights reserved.
// GNU GENERAL PUBLIC LICENSE Version 3, 29 June 2007
// http://www.gnu.org/licenses/gpl-3.0-standalone.html
// ----------------------------------------------------------------------------
package com.github.aynu.mosir.core.standard.util;
import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;
import org.apache.commons.codec.DecoderException;
import org.junit.Test;
/**
 * @see CodecHelper
 * @author nilcy
 */
@SuppressWarnings({ "static-method", "javadoc" })
public class CodecHelperTest {
    /**
     * @see CodecHelper#encodeHex(byte[])
     * @see CodecHelper#decodeHex(char[])
     */
    @Test
    public void testHex() throws DecoderException {
        final String testee = "foo";
        final char[] encoded = CodecHelper.encodeHex(testee.getBytes());
        final byte[] decoded = CodecHelper.decodeHex(encoded);
        assertThat(decoded, is(testee.getBytes()));
    }
    /**
     * @see CodecHelper#encodeBase64(byte[])
     * @see CodecHelper#decodeBase64(byte[])
     */
    @Test
    public void testBase64() {
        final String testee = "foo";
        final byte[] encoded = CodecHelper.encodeBase64(testee.getBytes());
        final byte[] decoded = CodecHelper.decodeBase64(encoded);
        assertThat(decoded, is(testee.getBytes()));
    }
    /**
     * @see CodecHelper#crypt(String)
     * @see CodecHelper#crypt(String, String)
     */
    @Test
    public void testCrypt() {
        final String testee = "foo";
        assertThat(CodecHelper.crypt(testee), is(not(CodecHelper.crypt(testee))));
        final String sha512 = "$6$xxxxxxxx$";
        assertThat(CodecHelper.crypt(testee, sha512), is(CodecHelper.crypt(testee, sha512)));
        final String sha256 = "$5$xxxxxxxx$";
        assertThat(CodecHelper.crypt(testee, sha256), is(CodecHelper.crypt(testee, sha256)));
        assertThat(CodecHelper.crypt(testee, sha256), is(not(CodecHelper.crypt(testee, sha512))));
    }
    /**
     * @see CodecHelper#crypt(String)
     * @see CodecHelper#crypt(String, String)
     */
    @Test
    public void testSha() {
        final String testee = "foo";
        assertThat(CodecHelper.sha1(testee.getBytes()), is(not(nullValue())));
        assertThat(CodecHelper.sha256(testee.getBytes()), is(not(nullValue())));
        assertThat(CodecHelper.sha384(testee.getBytes()), is(not(nullValue())));
        assertThat(CodecHelper.sha512(testee.getBytes()), is(not(nullValue())));
    }
}
