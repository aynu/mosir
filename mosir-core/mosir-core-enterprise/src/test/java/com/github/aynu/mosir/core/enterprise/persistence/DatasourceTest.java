// ----------------------------------------------------------------------------
// Copyright (C) Aynu Evolution Laboratory. All rights reserved.
// GNU GENERAL PUBLIC LICENSE Version 3, 29 June 2007
// http://www.gnu.org/licenses/gpl-3.0-standalone.html
// ----------------------------------------------------------------------------
package com.github.aynu.mosir.core.enterprise.persistence;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.inject.Inject;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;
import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.arquillian.junit.Arquillian;
import org.jboss.arquillian.transaction.api.annotation.TransactionMode;
import org.jboss.arquillian.transaction.api.annotation.Transactional;
import org.jboss.shrinkwrap.api.Archive;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.asset.EmptyAsset;
import org.jboss.shrinkwrap.api.spec.WebArchive;
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
public class DatasourceTest {
    @Inject
    private Logger log;
    @Deployment
    public static Archive<?> deploy() {
        return ShrinkWrap.create(WebArchive.class).addPackages(true, "com.github.aynu.mosir")
            .addAsWebInfResource(EmptyAsset.INSTANCE, "beans.xml")
            .addAsResource("META-INF/persistence.xml").addAsResource("config.properties");
        // .addAsLibraries(
        // Maven.resolver().loadPomFromFile("pom.xml").importCompileAndRuntimeDependencies().resolve()
        // .withTransitivity().asFile());
    }
    @Test
    public final void test() throws NamingException, SQLException {
        final InitialContext ic = new InitialContext();
        final DataSource ds = (DataSource) ic.lookup("java:jboss/datasources/ExampleDS");
        log.debug("DataSource : {}", ds);
        try (final Connection c = ds.getConnection();
            final ResultSet rs = c.createStatement().executeQuery("select count(*) from testee");) {
            log.debug("Connection : {}", c);
            while (rs.next()) {
                log.debug("count : {}", rs.getLong(1));
            }
        }
    }
}
