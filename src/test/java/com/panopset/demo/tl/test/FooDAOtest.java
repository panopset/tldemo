package com.panopset.demo.tl.test;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.panopset.demo.data.Foo;
import com.panopset.demo.data.FooDAO;
import com.panopset.demo.data.FooDAOImpl;

/**
 * 
 * Test the DAO by clearing it, adding a single element, and then retrieving it.
 *
 */
public class FooDAOtest {

    FooDAO fooDAO;

    @Before
    public void init() {
        fooDAO = new FooDAOImpl();
        fooDAO.clear();
        fooDAO.insertFoo(new Foo(SOME_RANDOM_STRING));
    }

    @Test
    public void test() {
        Assert.assertTrue(fooDAO.getFeaturedFoos().get(0).getName()
                .equals(SOME_RANDOM_STRING));
    }

    private static final String SOME_RANDOM_STRING = "Item " + Math.random();
}
