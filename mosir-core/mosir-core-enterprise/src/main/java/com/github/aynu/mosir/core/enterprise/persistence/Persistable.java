// ----------------------------------------------------------------------------
// Copyright (C) Aynu Evolution Laboratory. All rights reserved.
// GNU GENERAL PUBLIC LICENSE Version 3, 29 June 2007
// http://www.gnu.org/licenses/gpl-3.0-standalone.html
// ----------------------------------------------------------------------------
package com.github.aynu.mosir.core.enterprise.persistence;
import java.io.Serializable;
/**
 * (永続可能)エンティティI/F
 * <dl>
 * <dt>使用条件
 * <dd>
 * <ol>
 * <li>(永続可能)エンティティは本I/Fを実装すること。</li>
 * <li>{@link Serializable} を実装すること。</li>
 * </ol>
 * </dl>
 * @author nilcy
 */
public interface Persistable extends Serializable, Cloneable {
    /**
     * 識別子(ID)
     * @return 識別子(ID)
     */
    Object identity();
    /**
     * 永続管理チェック
     * @return TRUE:管理中,FALSE:未管理
     */
    boolean isPersisted();
}
