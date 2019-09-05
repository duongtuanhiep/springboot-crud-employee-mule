package com.ci1802.springbootemployeemule.searchapi;

import java.io.Serializable;
import java.lang.reflect.Field;
import java.util.List;
import java.util.Map;
import org.springframework.data.jpa.domain.Specification;

import com.ci1802.springbootemployeemule.model.entity.Employee;

public class SpecificationComb implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/* List of specification to be generated and combined */

	public Specification combSpecification(SearchFieldExtractor<?> searchFieldExtractor) {
		int i = 0;
		List<SearchCriteria> holder = searchFieldExtractor.getSearchCriteriaParams();
		if(holder.isEmpty()) System.out.println("bruh");
		Specification specification = Specification.where(null);
		if (!holder.isEmpty()) {
			specification = Specification.where(new UserSpecification(
					new SearchCriteria(holder.get(i).getKey(), ":", holder.get(i).getValue().toString())));
			for (i = 1; i < holder.size(); i++) {
				UserSpecification spec1 = new UserSpecification(
						new SearchCriteria(holder.get(i).getKey(), ":", holder.get(i).getValue().toString()));
				specification = specification.and(spec1);
			}
		}
		return specification;

	}

	public SpecificationComb() {
		super();
		// TODO Auto-generated constructor stub
	}
	/*
	 * public Specification combinedspecifications() { UserSpecification spec1,
	 * spec2, spec3; if (alternativeID != null) { spec1 = new UserSpecification(new
	 * SearchCriteria("alternativeID", ":", alternativeID)); } else { spec1 = null;
	 * } if (firstName != null) { spec2 = new UserSpecification(new
	 * SearchCriteria("firstName", ":", firstName)); } else { spec2 = null; } if
	 * (lastName != null) { spec3 = new UserSpecification(new
	 * SearchCriteria("lastName", ":", lastName)); } else { spec3 = null; } return
	 * Specification.where(spec1).and(spec2).and(spec3); }
	 */
}
