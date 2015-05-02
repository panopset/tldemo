package com.panopset.demo.data.repo;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.panopset.demo.data.hibernate.Foo;

/**
 * Foo repository.
 * @author Karl Dinwiddie
 *
 */
@Repository
public interface FooRepository extends CrudRepository<Foo, Long> {

}
