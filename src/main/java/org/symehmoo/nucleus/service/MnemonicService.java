package org.symehmoo.nucleus.service;

import java.util.Collection;
import java.util.UUID;

import org.springframework.data.domain.Sort;
import org.symehmoo.nucleus.model.MnemonicDTO;

public interface MnemonicService {

	public Collection<MnemonicDTO> getMnemonicDetails(Sort sort, UUID lobId, String lobName);

}
