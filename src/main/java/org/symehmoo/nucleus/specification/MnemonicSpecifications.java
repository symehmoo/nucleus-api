package org.symehmoo.nucleus.specification;

import java.util.Objects;
import java.util.UUID;

import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Component;
import org.symehmoo.nucleus.entity.Mnemonic;

@Component
public class MnemonicSpecifications extends BaseSpecification<Mnemonic> {

	public Specification<Mnemonic> createMnemonicSpecification(UUID lobId, String lobName) {
		Specification<Mnemonic> mnemonicSpecification = null;
		if (Objects.nonNull(lobId)) {
			mnemonicSpecification = this.getEqualSpecification("lob.id", lobId);
		}
		if (Objects.nonNull(lobName)) {
			mnemonicSpecification = this.getEqualSpecification("lob.lobName", lobName).and(mnemonicSpecification);
		}
		return mnemonicSpecification;
	}

}
