package com.panopset.demo.data;

import java.util.List;

public interface FooDAO {
    void insertFoo(Foo foo);

    Foo getFoo(String fooName);

    List<Foo> getFeaturedFoos();

    void clear();
}
