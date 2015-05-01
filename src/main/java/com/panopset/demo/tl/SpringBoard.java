
package com.panopset.demo.tl;

import org.springframework.web.servlet.support

.AbstractAnnotationConfigDispatcherServletInitializer;

/**
 * Spring XMLless annotation driven configuration entry point.
 * @author Karl Dinwiddie
 *
 */
public final class SpringBoard extends
        AbstractAnnotationConfigDispatcherServletInitializer {

    @Override
    protected Class<?>[] getRootConfigClasses() {
        return new Class<?>[] {
                HomeModel.class };
    }

    @Override
    protected Class<?>[] getServletConfigClasses() {
        return new Class[] {
                HomeController.class };
    }

    @Override
    protected String[] getServletMappings() {
        return new String[] {
                "/" };
    }
}
