
package com.panopset.demo.tl.test;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.panopset.demo.data.Foo;
import com.panopset.demo.data.FooDAO;
import com.panopset.demo.data.FooDAOH2Impl;
import com.panopset.demo.data.list.FooDAOArrayImpl;

/**
 *
 * Test the DAO by clearing it, adding a single element, and then retrieving it.
 *
 */
public final class FooDAOtest {

    /**
     * Foo as list entry.
     */
    private FooDAO fooDAOasListEntry;

    /**
     * Foo as H2 record.
     */
    private FooDAO fooDAOasH2Record;


    /**
     * Initialize FooDAOArrayImpl.
     */
    @Before
    public void initArray() {
        fooDAOasListEntry = new FooDAOArrayImpl();
        fooDAOasListEntry.clear();
        fooDAOasListEntry.insertFoo(new Foo(SOME_RANDOM_STRING));
    }

    /**
     * Initialization FooDAOH2Impl.
     */
    @Before
    public void initH2() {
        fooDAOasH2Record = new FooDAOH2Impl();
        fooDAOasH2Record.clear();
        fooDAOasH2Record.insertFoo(new Foo(SOME_RANDOM_STRING));
    }

    /**
     * Simple read test for ArrayList implementation of FooDAO.
     */
    @Test
    public void testArray() {
        Assert.assertTrue(fooDAOasListEntry.getFeaturedFoos().get(0).getName()
                .equals(SOME_RANDOM_STRING));
    }

    /**
     * Simple read test for H2 implementation of FooDAO.
     */
    @Test
    public void testH2() {
        Assert.assertTrue(fooDAOasH2Record.getFeaturedFoos().get(0).getName()
                .equals(SOME_RANDOM_STRING));
    }

    /**
     * Random Foo name for testing, &quot;Item &quot; + Math.random().
     */
    private static final String SOME_RANDOM_STRING = "Item " + Math.random();
}
