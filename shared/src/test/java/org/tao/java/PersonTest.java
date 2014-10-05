package org.tao.java;

import junit.framework.TestCase;

/**
 * Created by junjie on 5/10/14.
 */
public class PersonTest extends TestCase {
    public void testName() throws Exception {
        Person p = new Person(PersonTest.class.getName());
        assertEquals(PersonTest.class.getName(), p.name());
    }
}
