package org.symehmoo.nucleus.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;
import org.symehmoo.nucleus.entity.Mnemonic;

/**
 * Repository class to perform crud operation on Mnemonic table
 */
@Repository
public interface MnemonicRepository extends JpaRepository<Mnemonic, UUID>, JpaSpecificationExecutor<Mnemonic> {

	/**
	 * Method to find mnemonic record by mnemonic name
	 * 
	 * @param mnemonicsName
	 * @return {@link Mnemonic}
	 */
	public Mnemonic findByMnemonicsNameIgnoreCase(String mnemonicsName);

}
