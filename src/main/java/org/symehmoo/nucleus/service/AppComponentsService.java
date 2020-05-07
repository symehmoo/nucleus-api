package org.symehmoo.nucleus.service;

import java.util.Collection;
import java.util.UUID;

import org.springframework.data.domain.Sort;
import org.symehmoo.nucleus.model.AppComponentsDTO;

public interface AppComponentsService {

	public Collection<AppComponentsDTO> getAppComponentsDetails(Sort sort, UUID mnemonicId);

}
