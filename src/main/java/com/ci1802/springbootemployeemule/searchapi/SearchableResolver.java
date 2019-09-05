package com.ci1802.springbootemployeemule.searchapi;

import java.lang.reflect.ParameterizedType;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Spliterator;
import java.util.Spliterators;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import org.springframework.core.MethodParameter;
import org.springframework.core.convert.ConversionService;
import org.springframework.web.bind.support.WebDataBinderFactory;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.method.support.ModelAndViewContainer;

public class SearchableResolver implements HandlerMethodArgumentResolver {

	private ConversionService conversionService;
	
	public SearchableResolver(ConversionService conversionService) {
		this.conversionService = conversionService;
	}
	

	@Override
	public boolean supportsParameter(MethodParameter parameter) {
		return SearchFieldExtractor.class.equals(parameter.getParameterType());
	}

	@Override
	public Object resolveArgument(MethodParameter methodParameter, ModelAndViewContainer mavContainer,
			NativeWebRequest webRequest, WebDataBinderFactory binderFactory) throws Exception {

		Class<?> domainType = (Class<?>) ((ParameterizedType) methodParameter.getGenericParameterType())
				.getActualTypeArguments()[0];
		SearchFieldExtractor<?> searchFieldExtractor = new SearchFieldExtractor<>(domainType);
		Map<String, Class<?>> searchableFieldMap = searchFieldExtractor.getSearchableFieldMap();
		List<SearchCriteria> searchCriteriaParams = searchFieldExtractor.getSearchCriteriaParams();
		Iterator<String> requestParams = webRequest.getParameterNames();
		List<String> params = StreamSupport.stream(Spliterators.spliteratorUnknownSize(requestParams, Spliterator.ORDERED), false).collect(Collectors.toList());
		for (String param : params) {
			if (searchableFieldMap.containsKey(param)) {
				
				searchCriteriaParams.add(new SearchCriteria(param,":", convertToFieldType(webRequest.getParameterValues(param)[0].toString(), searchableFieldMap.get(param))));
			}
		}
		return searchFieldExtractor;
	}
    /**
     * Convert to field type.
     * @param value the value
     * @param type the type
     * @return the object
     */
    private Object convertToFieldType(String value, Class<? extends Object> type) {
        return this.conversionService.convert(value, type);
    }
}