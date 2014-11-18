// ----------------------------------------------------------------------------
// Copyright (C) Aynu Evolution Laboratory. All rights reserved.
// GNU GENERAL PUBLIC LICENSE Version 3, 29 June 2007
// http://www.gnu.org/licenses/gpl-3.0-standalone.html
// ----------------------------------------------------------------------------
package com.github.aynu.mosir.core.enterprise.persistence;
import static org.hamcrest.Matchers.*;
import static org.junit.Assert.*;
import javax.inject.Inject;
import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.arquillian.junit.Arquillian;
import org.jboss.arquillian.transaction.api.annotation.TransactionMode;
import org.jboss.arquillian.transaction.api.annotation.Transactional;
import org.jboss.shrinkwrap.api.Archive;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.asset.EmptyAsset;
import org.jboss.shrinkwrap.api.spec.WebArchive;
import org.jboss.shrinkwrap.resolver.api.maven.Maven;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
/**
 * @see SmartRepository
 * @see SmartRepositoryImpl
 * @author nilcy
 */
@RunWith(Arquillian.class)
@Transactional(value = TransactionMode.ROLLBACK)
@SuppressWarnings({ "javadoc", "boxing" })
public class SmartRepositoryImplTest {
    @Inject
    private SmartRepository<Testee, TesteeFilter> testee;
    @Inject
    private Logger log;
    @Deployment
    public static Archive<?> deploy() {
        return ShrinkWrap
            .create(WebArchive.class)
            .addPackages(true, "com.github.aynu.mosir")
            .addAsWebInfResource(EmptyAsset.INSTANCE, "beans.xml")
            .addAsResource("META-INF/persistence.xml")
            .addAsResource("config.properties")
            .addAsResource("error-messages.properties")
            .addAsLibraries(
                Maven.resolver().loadPomFromFile("pom.xml").importCompileAndRuntimeDependencies().resolve()
                    .withTransitivity().asFile());
    }
    @Test
    public final void testSimpleRepository() throws PersistenceException {
        assertThat(testee, is(not(nullValue())));
        // 追加してID発番,永続管理ができることを確認する。
        Testee entity = new Testee("code#01", "name#01");
        log.debug("entity : {}", entity);
        entity = testee.save(entity);
        testee.flush();
        assertThat(entity, is(not(nullValue())));
        assertThat(entity.getId(), is(not(nullValue())));
        assertThat(entity.isPersisted(), is(true));
        // 検索して追加内容と比較する。
        entity = testee.find(entity.identity());
        assertThat(entity, is(not(nullValue())));
        assertThat(entity.getCode(), is("code#01"));
        assertThat(entity.getName(), is("name#01"));
        // 変更する。
        entity.setName("name#02");
        entity = testee.save(entity);
        // 検索して追加内容と比較する。
        entity = testee.find(entity.identity());
        assertThat(entity, is(not(nullValue())));
        assertThat(entity.getName(), is("name#02"));
        // 削除して該当データなしを確認する。
        testee.delete(entity);
        entity = testee.find(entity.identity());
        assertThat(entity, is(nullValue()));
    }
    @Test
    @Ignore("TesteeTest#test2")
    public final void testSmartRepository() throws PersistenceException {
        testee.save(new Testee("code#91", "name#91"));
        final TesteeFilter filter = new TesteeFilter("code#91", "name", "code");
        final Testee entity = testee.findOne(filter);
        assertThat(entity.getCode(), is("code#91"));
        assertThat(entity.getName(), is("name#91"));
        log.debug("entity : {}", entity);
        testee.delete(entity);
    }
    @Test
    @Ignore("TesteeTest#test2")
    public final void testOrders() throws PersistenceException {
        testee.save(new Testee("code#81", "name#81"));
        testee.save(new Testee("code#82", "name#82"));
        testee.save(new Testee("code#83", "name#83"));
        testee.flush();
        final TesteeFilter filter = new TesteeFilter(null, "code desc");
        final Testee entity = testee.findMany(filter).iterator().next();
        assertThat(entity.getCode(), is("code#83"));
        log.debug("entity : {}", entity);
        testee.delete(entity);
    }
}
