package org.software.unicornapp.persistence.repo;

import org.software.unicornapp.persistence.entity.Unicorn;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * 
 * @author ahmad
 *
 */
public interface UnicornRepo extends JpaRepository<Unicorn, Integer> {

}
