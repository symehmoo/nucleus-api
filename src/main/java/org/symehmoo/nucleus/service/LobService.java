package org.symehmoo.nucleus.service;

import java.util.Collection;

import org.springframework.data.domain.Sort;
import org.symehmoo.nucleus.model.LobDTO;
import org.symehmoo.nucleus.model.LobSaveDTO;

public interface LobService {

	/**
	 * Method to fetch lob details based. Can be sort using sort criteria
	 * 
	 * @param sort
	 * @return {@link LobDTO} collection
	 */
	public Collection<LobDTO> getLobDetails(Sort sort);

	/**
	 * Method to save new lob record
	 * 
	 * @param lobSaveDTO
	 * @return {@link LobDTO}
	 */
	public LobDTO save(LobSaveDTO lobSaveDTO);

}
