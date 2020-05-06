package org.symehmoo.nucleus.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.symehmoo.nucleus.entity.Mnemonic;

@Repository
public interface MnemonicRepository extends JpaRepository<Mnemonic, String> {

}
