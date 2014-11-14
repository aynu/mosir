// ----------------------------------------------------------------------------
// Copyright (C) Aynu Evolution Laboratory. All rights reserved.
// GNU GENERAL PUBLIC LICENSE Version 3, 29 June 2007
// http://www.gnu.org/licenses/gpl-3.0-standalone.html
// ----------------------------------------------------------------------------
package com.github.aynu.mosir.core.standard.util;
import org.apache.commons.codec.DecoderException;
import org.apache.commons.codec.binary.Base64;
import org.apache.commons.codec.binary.Hex;
import org.apache.commons.codec.digest.Crypt;
import org.apache.commons.codec.digest.DigestUtils;
/**
 * コーデックヘルパー
 * <dl>
 * <dt>使用条件
 * <dd>コーデック関連の操作に使用すること。
 * </dl>
 * @author nilcy
 */
public final class CodecHelper {
    /** 非公開コンストラクタ */
    private CodecHelper() {
    }
    /**
     * Hex(16進数)エンコード
     * <dl>
     * <dt>使用条件
     * <dd>Hex(16進数)エンコードに使用すること。
     * </dl>
     * @param data 対象データ
     * @return Hex(16進数)エンコード後データ
     */
    public static char[] encodeHex(final byte[] data) {
        return Hex.encodeHex(data);
    }
    /**
     * Hex(16進数)デコード
     * <dl>
     * <dt>使用条件
     * <dd>Hex(16進数)デコードに使用すること。
     * </dl>
     * @param data 対象データ
     * @return Hex(16進数)デコード後データ
     * @throws DecoderException デコード例外
     */
    public static byte[] decodeHex(final char[] data) throws DecoderException {
        return Hex.decodeHex(data);
    }
    /**
     * Base64エンコード
     * <dl>
     * <dt>使用条件
     * <dd>Base64エンコードに使用すること。
     * </dl>
     * @param data 対象データ
     * @return Base64エンコード後データ
     */
    public static byte[] encodeBase64(final byte[] data) {
        return Base64.encodeBase64(data);
    }
    /**
     * Base64デコード
     * <dl>
     * <dt>使用条件
     * <dd>Base64デコードに使用すること。
     * </dl>
     * @param data 対象データ
     * @return Base64デコード後データ
     */
    public static byte[] decodeBase64(final byte[] data) {
        return Base64.decodeBase64(data);
    }
    /**
     * crypt互換ハッシュ
     * <dl>
     * <dt>使用条件
     * <dd>GNU libc crypt(3) compatible hash method.
     * </dl>
     * @param key キー
     * @return ハッシュ化したデータ
     */
    public static String crypt(final String key) {
        return Crypt.crypt(key);
    }
    /**
     * crypt互換ハッシュ
     * <dl>
     * <dt>使用条件
     * <dd>GNU libc crypt(3) compatible hash method.
     * </dl>
     * @param key キー
     * @param salt ソルト
     * @return ハッシュ化したデータ
     */
    public static String crypt(final String key, final String salt) {
        return Crypt.crypt(key, salt);
    }
    /**
     * MD2ダイジェスト
     * <dl>
     * <dt>使用条件
     * <dd>MD2ダイジェストの計算に使用すること。
     * </dl>
     * @param data 対象データ
     * @return ダイジェスト化したデータ
     */
    public static byte[] md2(final byte[] data) {
        return DigestUtils.md2(data);
    }
    /**
     * MD5ダイジェスト
     * <dl>
     * <dt>使用条件
     * <dd>MD5ダイジェストの計算に使用すること。
     * </dl>
     * @param data 対象データ
     * @return ダイジェスト化したデータ
     */
    public static byte[] md5(final byte[] data) {
        return DigestUtils.md5(data);
    }
    /**
     * SHA-1ダイジェスト
     * <dl>
     * <dt>使用条件
     * <dd>SHA-1ダイジェストの計算に使用すること。
     * </dl>
     * @param data 対象データ
     * @return ダイジェスト化したデータ
     */
    public static byte[] sha1(final byte[] data) {
        return DigestUtils.sha1(data);
    }
    /**
     * SHA-256ダイジェスト
     * <dl>
     * <dt>使用条件
     * <dd>SHA-256ダイジェストの計算に使用すること。
     * </dl>
     * @param data 対象データ
     * @return ダイジェスト化したデータ
     */
    public static byte[] sha256(final byte[] data) {
        return DigestUtils.sha256(data);
    }
    /**
     * SHA-384ダイジェスト
     * <dl>
     * <dt>使用条件
     * <dd>SHA-384ダイジェストの計算に使用すること。
     * </dl>
     * @param data 対象データ
     * @return ダイジェスト化したデータ
     */
    public static byte[] sha384(final byte[] data) {
        return DigestUtils.sha384(data);
    }
    /**
     * SHA-512ダイジェスト
     * <dl>
     * <dt>使用条件
     * <dd>SHA-512ダイジェストの計算に使用すること。
     * </dl>
     * @param data 対象データ
     * @return ダイジェスト化したデータ
     */
    public static byte[] sha512(final byte[] data) {
        return DigestUtils.sha512(data);
    }
}
