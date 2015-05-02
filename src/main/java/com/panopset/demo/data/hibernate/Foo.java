package com.panopset.demo.data.hibernate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * Simple database Object Java representation, for demo.
 * @author Karl Dinwiddie.
 *
 */
@Entity
public final class Foo {

    /**
     * @param fooName Foo name.
     */
    public Foo(final String fooName) {
        name = fooName;
    }

    /**
     * @return Foo id.
     */
    public Long getId() {
        return id;
    }

    /**
     * @param value Id value.
     */
    public void setId(final Long value) {
        id = value;
    }
    /**
     * @return Name key.
     */
    public String getName() {
        return name;
    }
    /**
     * Database record id.
     */
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY) 
    private long id;

    /**
     * Foo unique name.
     */
    private final String name;
}
