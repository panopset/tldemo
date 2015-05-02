
package com.panopset.demo.data;

import com.panopset.demo.data.hibernate.Foo;

/**
 * Supply sample data for this example.
 * @author Karl Dinwiddie
 *
 */
public final class FooSampleData {

    /**
     * @return Sample data as simple array.
     */
    public Foo[] getArray() {
        return new Foo[] {
                new Foo("item 1..."),
                new Foo("item 2..."),
                new Foo("item 3...") };
    }
}
