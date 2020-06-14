package org.symehmoo.nucleus.specification;

import java.util.Objects;
import java.util.UUID;

import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Component;
import org.symehmoo.nucleus.entity.AppComponents;

@Component
public class AppComponentSpecifications extends BaseSpecification<AppComponents> {

	/**
	 * This method will create specification object for filtering data in app
	 * components table on mnemonic id and mnemonics name
	 * 
	 * @param mnemonicId
	 * @param mnemonicsName
	 * @return {@link Specification} object
	 */
	public Specification<AppComponents> createAppComponentsSpecification(UUID mnemonicId, String mnemonicsName) {
		Specification<AppComponents> appComponentsSpecification = null;
		if (Objects.nonNull(mnemonicId)) {
			appComponentsSpecification = getEqualSpecification("mnemonic.id", mnemonicId);
		}
		if (Objects.nonNull(mnemonicsName)) {
			appComponentsSpecification = getEqualSpecification("mnemonic.mnemonicsName", mnemonicsName)
					.and(appComponentsSpecification);
		}
		return appComponentsSpecification;
	}

}
