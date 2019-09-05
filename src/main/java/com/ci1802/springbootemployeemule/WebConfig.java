package com.ci1802.springbootemployeemule;

import java.util.List;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.ci1802.springbootemployeemule.searchapi.SearchableResolver;

import org.springframework.format.support.DefaultFormattingConversionService;

@Configuration
public class WebConfig implements WebMvcConfigurer {

	// ...

	@Override
	public void addArgumentResolvers(List<HandlerMethodArgumentResolver> argumentResolvers) {
		DefaultFormattingConversionService conversionService = new DefaultFormattingConversionService();
		argumentResolvers.add(new SearchableResolver(conversionService));
	}
	
}