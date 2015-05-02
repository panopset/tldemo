
package com.panopset.demo.tl.test;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.support.AnnotationConfigContextLoader;

import com.panopset.demo.data.FooSampleData;
import com.panopset.demo.data.hibernate.Foo;
import com.panopset.demo.data.repo.FooRepository;
import com.panopset.demo.tl.DatabaseConfig;

/**
 * Foo repository test.
 * @author Karl Dinwiddie
 *
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = { DatabaseConfig.class },

        loader = AnnotationConfigContextLoader.class)
public final class FooRepoTest {

    /**
     * Foo repository.
     */
    @Autowired
    private FooRepository fooRepo;
    
    /**
     * Sample data.
     */
    private Foo[] sampleData;

    /**
     * Initialization.
     */
    @Before
    public void init() {
        sampleData = new FooSampleData().getArray();
    }
    /**
     * Simple test.
     */
    @Test
    public void test() {
        for (Foo foo : sampleData) {
            fooRepo.save(foo);
        }
        Assert.assertTrue(fooRepo.count() == sampleData.length);
    }

}
