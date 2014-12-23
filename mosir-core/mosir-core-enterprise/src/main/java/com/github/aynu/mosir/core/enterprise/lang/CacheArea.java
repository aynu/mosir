// ----------------------------------------------------------------------------
// Copyright (C) Aynu Evolution Laboratory. All rights reserved.
// GNU GENERAL PUBLIC LICENSE Version 3, 29 June 2007
// http://www.gnu.org/licenses/gpl-3.0-standalone.html
// ----------------------------------------------------------------------------
package com.github.aynu.mosir.core.enterprise.lang;
/**
 * キャッシュエリア
 * @author nilcy
 */
public enum CacheArea {
    /** アプリケーションスコープ */
    APPLICATION,
    /** セッションスコープ */
    SESSION,
    /** カンバセーションスコープ */
    CONVERSATION,
    /** リクエストスコープ */
    REQUEST;
}