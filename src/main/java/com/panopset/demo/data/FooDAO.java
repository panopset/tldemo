package com.panopset.demo.data;

import java.util.List;

import com.panopset.demo.data.hibernate.Foo;

/**
 * Foo DAO.
 * @author Karl Dinwiddie
 *
 */
public interface FooDAO {

    /**
     * @param foo Foo to insert.
     */
    void insertFoo(Foo foo);

    /**
     * @param fooName Foo name.
     * @return Foo with the unique name key.
     */
    Foo getFoo(String fooName);

    /**
     * @return Featured Foo objects for display.
     */
    List<Foo> getFeaturedFoos();

    /**
     * Clear out all Foo objects.
     */
    void clear();
}
