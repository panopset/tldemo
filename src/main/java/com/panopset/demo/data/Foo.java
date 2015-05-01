package com.panopset.demo.data;

/**
 * Simple database Object Java representation, for demo.
 * @author Karl Dinwiddie.
 *
 */
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
    public int getId() {
        return id;
    }

    /**
     * @return Name key.
     */
    public String getName() {
        return name;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + id;
        result = prime * result;
        if (name != null) {
            result += name.hashCode();
        }
        return result;
    }

    @Override
    public boolean equals(final Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        Foo other = (Foo) obj;
        if (id != other.id) {
            return false;
        }
        if (name == null) {
            if (other.name != null) {
                return false;
            }
        } else if (!name.equals(other.name)) {
            return false;
        }
        return true;
    }

    /**
     * Database record id.
     */
    private int id;

    /**
     * Foo unique name.
     */
    private final String name;
}
