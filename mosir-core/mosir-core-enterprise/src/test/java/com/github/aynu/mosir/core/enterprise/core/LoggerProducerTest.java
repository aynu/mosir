// ----------------------------------------------------------------------------
// Copyright (C) Aynu Evolution Laboratory. All rights reserved.
// GNU GENERAL PUBLIC LICENSE Version 3, 29 June 2007
// http://www.gnu.org/licenses/gpl-3.0-standalone.html
// ----------------------------------------------------------------------------
package com.github.aynu.mosir.core.enterprise.core;
import static org.hamcrest.Matchers.*;
import static org.junit.Assert.*;
import javax.inject.Inject;
import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.arquillian.junit.Arquillian;
import org.jboss.shrinkwrap.api.Archive;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.asset.EmptyAsset;
import org.jboss.shrinkwrap.api.spec.WebArchive;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import com.github.aynu.mosir.core.enterprise.core.LoggerProducer;
/**
 * @see LoggerProducer
 * @author nilcy
 */
@RunWith(Arquillian.class)
public class LoggerProducerTest {
    /** ロガー */
    @Inject
    private Logger testee;
    /**
     * デプロイ
     * @return JAR
     */
    @Deployment
    public static Archive<?> deploy() {
        return ShrinkWrap.create(WebArchive.class).addPackages(true, "com.github.aynu.mosir")
            .addAsManifestResource(EmptyAsset.INSTANCE, "beans.xml");
    }
    /**
     * @see Logger#trace(String, Object...)
     * @see Logger#debug(String, Object...)
     * @see Logger#info(String, Object...)
     * @see Logger#warn(String, Object...)
     * @see Logger#error(String, Object...)
     */
    @Test
    public final void test() {
        assertThat(testee, is(not(nullValue())));
        testee.trace("[追跡] {},{},{}", "T1", "T2", "T3");
        testee.debug("[検査] {},{},{}", "D1", "D2", "D3");
        testee.info("[情報] {},{},{}", "I1", "I2", "I3");
        testee.warn("[警告] {},{},{}", "W1", "W2", "W3");
        testee.error("[例外] {},{},{}", "E1", "E2", "E3");
    }
}
