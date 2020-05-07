package org.symehmoo.nucleus.specification;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.data.jpa.domain.Specification;

public abstract class BaseSpecification<T> {

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
