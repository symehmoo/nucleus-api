package org.symehmoo.nucleus.service;

import java.util.Collection;
import java.util.UUID;

import org.springframework.data.domain.Sort;
import org.symehmoo.nucleus.model.AppComponentsDTO;
import org.symehmoo.nucleus.model.AppComponentsSaveDTO;

public interface AppComponentsService {

	/**
	 * Method to fetch app components details based on mnemonic id and mnemonic
	 * name. Will fetch all records if values for mnemonic id and name is null.
	 * Can be sort using sort criteria
	 * 
	 * @param sort
	 * @param mnemonicId
	 * @param mnemonicsName
	 * @return {@link AppComponentsDTO} collection
	 */
	public Collection<AppComponentsDTO> getAppComponentsDetails(Sort sort, UUID mnemonicId, String mnemonicsName);

	/**
	 * Method to save new app component record
	 * 
	 * @param appComponentsSaveDTO
	 * @return {@link AppComponentsDTO}
	 */
	public AppComponentsDTO save(AppComponentsSaveDTO appComponentsSaveDTO);

}
