package org.tao.java;

/**
 * Created by junjie on 5/10/14.
 */
public class Person {
    public Person(String name) {
        this.name = name;
    }

    public String name() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return this.name;
    }

    private String name;
}
