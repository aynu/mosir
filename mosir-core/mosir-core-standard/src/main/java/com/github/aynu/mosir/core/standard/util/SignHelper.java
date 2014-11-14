// ----------------------------------------------------------------------------
// Copyright (C) Aynu Evolution Laboratory. All rights reserved.
// GNU GENERAL PUBLIC LICENSE Version 3, 29 June 2007
// http://www.gnu.org/licenses/gpl-3.0-standalone.html
// ----------------------------------------------------------------------------
package com.github.aynu.mosir.core.standard.util;
import java.security.InvalidKeyException;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.NoSuchAlgorithmException;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.Signature;
import java.security.SignatureException;
import com.github.aynu.mosir.core.standard.lang.StandardRuntimeException;
/**
 * 署名ヘルパー
 * <dl>
 * <dt>使用条件
 * <dd>署名の操作に使用すること。
 * </dl>
 * @author nilcy
 */
public final class SignHelper {
    /** 署名アルゴリズム */
    private static final String ALGORITHM = "NONEwithECDSA";
    /** 非公開コンストラクタ */
    private SignHelper() {
    }
    /**
     * 署名鍵ペアの作成
     * <dl>
     * <dt>使用条件
     * <dd>ECの鍵ペア生成器を作成し、256ビット長の鍵ペアを作成すること。
     * </dl>
     * @return 鍵ペア(公開鍵と秘密鍵)
     */
    public static KeyPair createSignKeyPair() {
        try {
            final KeyPairGenerator keyPairGenerator = KeyPairGenerator.getInstance("EC");
            keyPairGenerator.initialize(256);
            return keyPairGenerator.generateKeyPair();
        } catch (final NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }
    }
    /**
     * 署名の作成
     * <dl>
     * <dt>使用条件
     * <dd>NONEwithECDSAの署名生成器を作成し、引数をもとに署名を作成すること。
     * </dl>
     * @param key 秘密鍵
     * @param data データ
     * @return 署名
     */
    public static byte[] sign(final PrivateKey key, final byte[] data) {
        try {
            final Signature sign = Signature.getInstance(ALGORITHM);
            sign.initSign(key);
            sign.update(data);
            return sign.sign();
        } catch (final NoSuchAlgorithmException | InvalidKeyException | SignatureException e) {
            throw new StandardRuntimeException(e);
        }
    }
    /**
     * 署名の検証
     * <dl>
     * <dt>使用条件
     * <dd>NONEwithECDSAの署名生成器を作成し、引数をもとに署名を検証すること。
     * </dl>
     * @param publicKey 公開鍵
     * @param message メッセージ
     * @param signature 署名
     * @return 検証結果
     */
    public static boolean verify(final PublicKey publicKey, final byte[] signature,
        final byte[] message) {
        try {
            final Signature sign = Signature.getInstance(ALGORITHM);
            sign.initVerify(publicKey);
            sign.update(message);
            return sign.verify(signature);
        } catch (final NoSuchAlgorithmException | InvalidKeyException | SignatureException e) {
            throw new StandardRuntimeException(e);
        }
    }
}
