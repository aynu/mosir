// ----------------------------------------------------------------------------
// Copyright (C) Aynu Evolution Laboratory. All rights reserved.
// GNU GENERAL PUBLIC LICENSE Version 3, 29 June 2007
// http://www.gnu.org/licenses/gpl-3.0-standalone.html
// ----------------------------------------------------------------------------
package com.github.aynu.mosir.core.enterprise;
import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;
import org.junit.Test;
import com.github.aynu.mosir.core.enterprise.HelloWorld;
/**
 * {@link HelloWorld} のユニットテスト
 * @author nilcy
 */
@SuppressWarnings({ "static-method", "javadoc" })
public class HelloWorldTest {
    @Test
    public void test() {
        assertThat(new HelloWorld().say(), is("Hello world!"));
    }
}
