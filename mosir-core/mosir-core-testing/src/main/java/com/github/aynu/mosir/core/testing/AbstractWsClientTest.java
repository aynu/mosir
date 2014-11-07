// ----------------------------------------------------------------------------
// Copyright (C) Aynu Evolution Laboratory. All rights reserved.
// GNU GENERAL PUBLIC LICENSE Version 3, 29 June 2007
// http://www.gnu.org/licenses/gpl-3.0-standalone.html
// ----------------------------------------------------------------------------
package com.github.aynu.mosir.core.testing;
import java.net.URL;
import org.jboss.arquillian.test.api.ArquillianResource;
/**
 * WSクライアント基底テスト
 * @author nilcy
 */
abstract class AbstractWsClientTest {
    /** 基点URL */
    @ArquillianResource
    private URL base;
    /** コンストラクタ */
    public AbstractWsClientTest() {
    }
    /**
     * {@link #base} の取得
     * @return {@link #base}
     */
    public URL getBase() {
        return base;
    }
}
