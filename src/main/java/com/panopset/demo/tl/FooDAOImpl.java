package com.panopset.demo.tl;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * For the demo, we'll just use an internal Array.
 *
 */
public class FooDAOImpl implements FooDAO {

    // TODO Replace w/DB.
    private final List<Foo> foos = Collections
            .synchronizedList(new ArrayList<Foo>());

    @Override
    public void insertFoo(Foo foo) {
        foos.add(foo);
    }

    @Override
    public Foo getFoo(String fooName) {
        for (Foo foo : foos) {
            if (foo.getName().equals(fooName)) {
                return foo;
            }
        }
        return null;
    }

    @Override
    public synchronized List<Foo> getFeaturedFoos() {
        if (foos.isEmpty()) {
            insertFoo(new Foo("Item 1..."));
            insertFoo(new Foo("Item 2..."));
            insertFoo(new Foo("Item 3..."));
        }
        return foos;
    }

    @Override
    public void clear() {
        foos.clear();
    }
}
