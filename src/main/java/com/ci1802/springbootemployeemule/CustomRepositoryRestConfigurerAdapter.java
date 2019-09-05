package com.ci1802.springbootemployeemule;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.data.rest.RepositoryRestProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;
import org.springframework.data.rest.webmvc.config.RepositoryRestConfigurerAdapter;

import com.ci1802.springbootemployeemule.model.entity.Employee;


/**
 * The Class CustomRepositoryRestConfigurerAdapter. Add more configuration such as changing max page site, register new resolvers,..
 */
@Configuration
public class CustomRepositoryRestConfigurerAdapter extends RepositoryRestConfigurerAdapter {

    /* The Constant MAX_PAGE_SIZE. */
    private static final int MAX_PAGE_SIZE = 100;

    /* The Constant DEFAULT_PAGE_SIZE. */
    private static final int DEFAULT_PAGE_SIZE = 10;

    /* The Constant ORDER_BY. */
    public static final String ORDER_BY = "orderBy";

    /* The Constant PAGE_SIZE. */
    public static final String PAGE_SIZE = "pageSize";

    /* The Constant PAGE_NUMBER. */
    public static final String PAGE_NUMBER = "pageNumber";

    /* The properties. */
    @Autowired
    private RepositoryRestProperties properties;

    @Override
    public void configureRepositoryRestConfiguration(RepositoryRestConfiguration config) {
        // apply configuration from properties file
        this.properties.applyTo(config);
        super.configureRepositoryRestConfiguration(config);
        config.setDefaultPageSize(DEFAULT_PAGE_SIZE);
        config.setMaxPageSize(MAX_PAGE_SIZE);
        config.setPageParamName(PAGE_NUMBER);
        config.setLimitParamName(PAGE_SIZE);
        config.setSortParamName(ORDER_BY);
        config.exposeIdsFor(Employee.class);
    }

}