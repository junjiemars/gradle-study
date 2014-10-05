package org.tao.api;

import org.tao.java.Person;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Created by junjie on 5/10/14.
 */
public class Persons implements Iterable<Person> {

    public void add(String name) {
        this.persons.add(new Person(name));
    }

    @Override
    public Iterator<Person> iterator() {
        return persons.iterator();
    }

    private List<Person> persons = new ArrayList<Person>();
}
