// ----------------------------------------------------------------------------
// Copyright (C) Aynu Evolution Laboratory. All rights reserved.
// GNU GENERAL PUBLIC LICENSE Version 3, 29 June 2007
// http://www.gnu.org/licenses/gpl-3.0-standalone.html
// ----------------------------------------------------------------------------
package com.github.aynu.mosir.core.testing;
import java.net.URISyntaxException;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
/**
 * RESTクライアント基底テスト
 * @author nilcy
 */
public abstract class AbstractRestClientTest extends AbstractWsClientTest {
    /** RESTパス */
    private final String path;
    /** RESTクライアント */
    private Client client;
    /** RESTルート */
    private WebTarget root;
    /**
     * コンストラクタ
     * @param path {@link #path}
     */
    public AbstractRestClientTest(final String path) {
        this.path = path;
    }
    /**
     * {@link #client}の取得
     * @return {@link #client}
     */
    protected synchronized Client client() {
        if (client == null) {
            client = ClientBuilder.newClient();
        }
        return client;
    }
    /**
     * {@link #root}の取得
     * @return {@link #root}
     * @throws URISyntaxException URI構文例外
     */
    protected synchronized WebTarget root() throws URISyntaxException {
        if (root == null) {
            root = client().target(getBase().toURI() + path);
        }
        return root;
    }
}
