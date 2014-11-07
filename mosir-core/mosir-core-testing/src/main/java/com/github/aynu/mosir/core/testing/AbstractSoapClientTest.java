// ----------------------------------------------------------------------------
// Copyright (C) Aynu Evolution Laboratory. All rights reserved.
// GNU GENERAL PUBLIC LICENSE Version 3, 29 June 2007
// http://www.gnu.org/licenses/gpl-3.0-standalone.html
// ----------------------------------------------------------------------------
package com.github.aynu.mosir.core.testing;
import java.net.MalformedURLException;
import java.net.URISyntaxException;
import java.net.URL;
import javax.xml.namespace.QName;
import javax.xml.ws.Service;
/**
 * SOAPクライアント基底テスト
 * @author nilcy
 */
public abstract class AbstractSoapClientTest extends AbstractWsClientTest {
    /** SOAPネームスペース */
    private final String uri;
    /** SOAPサービス名 */
    private final String name;
    /**
     * コンストラクタ
     * @param uri {@link #uri}
     * @param name {@link #name}
     */
    public AbstractSoapClientTest(final String uri, final String name) {
        this.uri = uri;
        this.name = name;
    }
    /**
     * ポートの取得
     * @param <T> エンドポイントI/F型
     * @param endpoint エンドポイントI/F
     * @return ポート
     */
    public <T> T getPort(final Class<T> endpoint) {
        try {
            final URL url = new URL(getBase().toURI() + name + "?wsdl");
            final QName qname = new QName(uri, name);
            final Service service = Service.create(url, qname);
            return service.getPort(endpoint);
        } catch (MalformedURLException | URISyntaxException e) {
            throw new IllegalArgumentException(e);
        }
    }
}
