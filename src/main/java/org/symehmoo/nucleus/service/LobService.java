package org.symehmoo.nucleus.service;

import java.util.Collection;

import org.springframework.data.domain.Sort;
import org.symehmoo.nucleus.model.LobDTO;

public interface LobService {

	public Collection<LobDTO> getLobDetails(Sort sort);

}
