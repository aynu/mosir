// ----------------------------------------------------------------------------
// Copyright (C) Aynu Evolution Laboratory. All rights reserved.
// GNU GENERAL PUBLIC LICENSE Version 3, 29 June 2007
// http://www.gnu.org/licenses/gpl-3.0-standalone.html
// ----------------------------------------------------------------------------
package com.github.aynu.mosir.core.standard.lang;
/**
 * 仕様オブジェクトI/F
 * <dl>
 * <dt>使用条件
 * <dd>
 * <ol>
 * <li>仕様オブジェクトは本I/Fを実装すること。</li>
 * </ol>
 * </dl>
 * @param <T> 仕様オブジェクトのタイプ
 * @author nilcy
 */
public interface Spec<T> {
    /**
     * 仕様チェック
     * @param object 対象オブジェクト
     * @return {@code object} が仕様を満たすとき {@code true}
     */
    boolean isSatisfiedBy(T object);
    /**
     * 論理積(AND)仕様オブジェクトの作成
     * @param spec 仕様オブジェクト
     * @return 論理積(AND)仕様オブジェクト
     */
    Spec<T> and(Spec<T> spec);
    /**
     * 論理和(OR)仕様オブジェクトの作成
     * @param spec 仕様オブジェクト
     * @return 論理和(OR)仕様オブジェクト
     */
    Spec<T> or(Spec<T> spec);
    /**
     * 排他的論理和(XOR)仕様オブジェクトの作成
     * @param spec 仕様オブジェクト
     * @return 排他的論理和(XOR)仕様オブジェクト
     */
    Spec<T> xor(Spec<T> spec);
    /**
     * 否定論理積(NAND)仕様オブジェクトの作成
     * @param spec 仕様オブジェクト
     * @return 否定論理積(NAND)仕様オブジェクト
     */
    Spec<T> nand(Spec<T> spec);
    /**
     * 否定論理和(NOR)仕様オブジェクトの作成
     * @param spec 仕様オブジェクト
     * @return 否定論理和(NOR)仕様オブジェクト
     */
    Spec<T> nor(Spec<T> spec);
}
