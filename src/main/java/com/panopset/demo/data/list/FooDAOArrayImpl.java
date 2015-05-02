package com.panopset.demo.data.list;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import com.panopset.demo.data.FooDAO;
import com.panopset.demo.data.FooSampleData;
import com.panopset.demo.data.hibernate.Foo;

/**
 * For the demo, we'll just use an internal Array.
 *
 */
public final class FooDAOArrayImpl implements FooDAO {

    /**
     * Store Foo objects in an ArrayList.
     */
    private final List<Foo> foos = Collections
            .synchronizedList(new ArrayList<Foo>());

    @Override
    public void insertFoo(final Foo foo) {
        foos.add(foo);
    }

    @Override
    public Foo getFoo(final String fooName) {
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
            for (Foo foo : new FooSampleData().getArray()) {
                insertFoo(foo);
            }
        }
        return foos;
    }

    @Override
    public void clear() {
        foos.clear();
    }
}
