package org.symehmoo.nucleus.specification;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.data.jpa.domain.Specification;

/**
 * Base class to create specification object for filtering based on field name
 * 
 */
public abstract class BaseSpecification<T> {

	/**
	 * This method will create a specification object for searching based on key
	 * and value. This specification object will be passed to spring data
	 * repository for filtering data. For nested field search keyname will be
	 * like "nestedObject.fieldName"
	 * 
	 * @param key
	 * @param value
	 * @return {@link Specification} object
	 */
	public Specification<T> getEqualSpecification(String key, Object value) {
		return new Specification<T>() {

			private static final long serialVersionUID = 1L;

			@Override
			public Predicate toPredicate(Root<T> root, CriteriaQuery<?> query, CriteriaBuilder builder) {
				if (key.contains(".")) {
					String path[] = key.split("\\.");
					return builder.equal(root.join(path[0]).get(path[1]), value);
				} else {
					return builder.equal(root.get(key), value);
				}
			}
		};
	}
}
