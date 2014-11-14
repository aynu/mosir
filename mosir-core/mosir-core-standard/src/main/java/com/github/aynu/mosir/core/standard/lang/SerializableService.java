// ----------------------------------------------------------------------------
// Copyright (C) Aynu Evolution Laboratory. All rights reserved.
// GNU GENERAL PUBLIC LICENSE Version 3, 29 June 2007
// http://www.gnu.org/licenses/gpl-3.0-standalone.html
// ----------------------------------------------------------------------------
package com.github.aynu.mosir.core.standard.lang;
import java.io.Serializable;
/**
 * 直列化可能サービスI/F
 * <dl>
 * <dt>使用条件
 * <dd>
 * <ol>
 * <li>直列化可能サービスは本I/Fを実装すること。</li>
 * <li>{@link Service サービスI/F} と {@link Serializable} を実装すること。</li>
 * </ol>
 * </dl>
 * @author nilcy
 */
public interface SerializableService extends Service, Serializable {
}
