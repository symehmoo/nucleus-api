package org.symehmoo.nucleus.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;
import org.symehmoo.nucleus.entity.Lob;

/**
 * Repository class to perform crud operation on Lob table
 */
@Repository
public interface LobRepository extends JpaRepository<Lob, String>, JpaSpecificationExecutor<Lob> {

	/**
	 * Method to find lob record by lob name
	 * 
	 * @param lobName
	 * @return {@link Lob}
	 */
	public Lob findByLobNameIgnoreCase(String lobName);

}
