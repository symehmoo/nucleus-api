package org.symehmoo.nucleus.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.symehmoo.nucleus.entity.AppComponents;

@Repository
public interface AppComponentsRepository extends JpaRepository<AppComponents, String> {

}
