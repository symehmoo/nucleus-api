package org.symehmoo.nucleus.service;

import java.util.Collection;
import java.util.UUID;

import org.springframework.data.domain.Sort;
import org.symehmoo.nucleus.model.MnemonicDTO;
import org.symehmoo.nucleus.model.MnemonicSaveDTO;

public interface MnemonicService {

	/**
	 * Method to fetch mnemonic details based on lob id and lob name. Will fetch
	 * all records if values for lob id and lob name is null. Can be sort using
	 * sort criteria
	 * 
	 * @param sort
	 * @param lob
	 * @param lobName
	 * @return {@link MnemonicDTO} collection
	 */
	public Collection<MnemonicDTO> getMnemonicDetails(Sort sort, UUID lobId, String lobName);

	/**
	 * Method to save new mnemonic record
	 * 
	 * @param mnemonicSaveDTO
	 * @return {@link MnemonicSaveDTO}
	 */
	public MnemonicDTO save(MnemonicSaveDTO mnemonicSaveDTO);

}
