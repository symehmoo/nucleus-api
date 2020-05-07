package org.symehmoo.nucleus.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;
import org.symehmoo.nucleus.entity.AppComponents;
import org.symehmoo.nucleus.entity.Mnemonic;

@Repository
public interface AppComponentsRepository
		extends JpaRepository<AppComponents, String>, JpaSpecificationExecutor<AppComponents> {

}
