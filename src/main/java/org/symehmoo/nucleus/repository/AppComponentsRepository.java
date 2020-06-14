package org.symehmoo.nucleus.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;
import org.symehmoo.nucleus.entity.AppComponents;

/**
 * Repository class to perform crud operation on AppComponents table
 */
@Repository
public interface AppComponentsRepository
		extends JpaRepository<AppComponents, String>, JpaSpecificationExecutor<AppComponents> {

	/**
	 * Method to find app component record by mnemonic id and app component name
	 * 
	 * @param mnemonicId
	 * @param appComponentsName
	 * @return {@link AppComponents}
	 */
	public AppComponents findByMnemonic_IdAndAppComponentsNameIgnoreCase(UUID mnemonicId, String appComponentsName);

}
