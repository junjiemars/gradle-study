package org.tao.api;

import junit.framework.TestCase;
import org.tao.java.Person;

import java.util.Iterator;

/**
 * Created by junjie on 5/10/14.
 */
public class PersonsTest extends TestCase {

    public void testName() throws Exception {
        Persons persons = new Persons();

        for (int i = 0; i < 3; i++) persons.add(Integer.toString(i));

        for (Person p : persons) {
            assertEquals(p.name(), p.toString());
        }
    }
}
