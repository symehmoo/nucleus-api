package org.symehmoo.nucleus.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.symehmoo.nucleus.entity.Lob;

@Repository
public interface LobRepository extends JpaRepository<Lob, String> {

}
