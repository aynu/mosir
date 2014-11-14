// ----------------------------------------------------------------------------
// Copyright (C) Aynu Evolution Laboratory. All rights reserved.
// GNU GENERAL PUBLIC LICENSE Version 3, 29 June 2007
// http://www.gnu.org/licenses/gpl-3.0-standalone.html
// ----------------------------------------------------------------------------
package com.github.aynu.mosir.core.standard.lang;
import java.io.Serializable;
/**
 * 基底データオブジェクトI/F
 * <dl>
 * <dt>使用条件
 * <dd>全データオブジェクトの基底クラスのI/Fとすること。
 * </dl>
 * @param <T> データオブジェクト型
 * @author nilcy
 */
public interface DataObject<T extends DataObject<T>> extends Serializable {
}
