
package com.panopset.demo.tl;

import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import

org.springframework.context.support.ReloadableResourceBundleMessageSource;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import

org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import

org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.thymeleaf.spring4.SpringTemplateEngine;
import org.thymeleaf.spring4.view.ThymeleafViewResolver;
import org.thymeleaf.templateresolver.ServletContextTemplateResolver;
import org.thymeleaf.templateresolver.TemplateResolver;

import com.panopset.demo.data.FooDAO;
import com.panopset.demo.data.list.FooDAOArrayImpl;

/**
 * MVC Model.
 *
 * @author Karl Dinwiddie
 *
 */
@Configuration
@EnableWebMvc
@ComponentScan(basePackages = { "com.panopset.demo.tl" })
public class HomeModel extends WebMvcConfigurerAdapter {

    /**
     * @return FooDAO implementation.
     */
    @Bean
    public FooDAO storeDAO() {
        return new FooDAOArrayImpl();
    }

    /**
     * This is all we need to supply the value for #{greeting}, and other
     * language property values.
     *
     * @return Message source to resolve National Language translations.
     */
    @Bean
    public MessageSource messageSource() {
        ReloadableResourceBundleMessageSource messageSource

        = new ReloadableResourceBundleMessageSource();
        messageSource.setBasenames("WEB-INF/nls/messages");
        messageSource.setUseCodeAsDefaultMessage(false);
        messageSource.setDefaultEncoding("UTF-8");
        return messageSource;
    }

    /**
     * Define where to look for Thymeleaf template HTML5 pages.
     *
     * @return Template resolver.
     */
    @Bean
    public TemplateResolver templateResolver() {
        ServletContextTemplateResolver templateResolver

        = new ServletContextTemplateResolver();
        templateResolver.setPrefix("/WEB-INF/views/");
        templateResolver.setSuffix(".html");
        templateResolver.setTemplateMode("HTML5");
        return templateResolver;
    }

    /**
     * Associate Thymeleaf ServletContextTemplateResolver with the Thymeleaf
     * Spring template engine.
     *
     * @return Template engine.
     */
    @Bean
    public SpringTemplateEngine templateEngine() {
        SpringTemplateEngine templateEngine = new SpringTemplateEngine();
        templateEngine.setTemplateResolver(templateResolver());
        return templateEngine;
    }

    /**
     * Associate Spring Framework view resolver with Thymeleaf.
     *
     * @return Thymeleaf view resolver.
     */
    @Bean
    public ViewResolver viewResolver() {
        ThymeleafViewResolver viewResolver = new ThymeleafViewResolver();
        viewResolver.setTemplateEngine(templateEngine());
        viewResolver.setOrder(1);
        return viewResolver;
    }

    /**
     * Normally I would put static resources on an apache2 server somewhere,
     * including this only to make this example self contained.
     */
    @Override
    public void addResourceHandlers(final ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/css/**/*").addResourceLocations(
                "/WEB-INF/views/css/");
    }
}
