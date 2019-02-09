package org.software.unicornapp.persistence.repo;

import org.software.unicornapp.persistence.entity.Zone;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ZoneRepo extends JpaRepository<Zone, Integer> {

}
