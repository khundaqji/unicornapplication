package org.software.unicornapp.service;

import java.util.List;

import org.software.unicornapp.persistence.entity.Zone;
import org.software.unicornapp.persistence.repo.ZoneRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 
 * @author ahmad
 *
 */
@Service
public class ZoneService {

	@Autowired
	private ZoneRepo repo;

	public List<Zone> getAllZones() {
		return this.repo.findAll();
	}

}
