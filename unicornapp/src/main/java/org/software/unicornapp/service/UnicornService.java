package org.software.unicornapp.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.software.unicornapp.persistence.entity.Unicorn;
import org.software.unicornapp.persistence.entity.Zone;
import org.software.unicornapp.persistence.repo.UnicornRepo;
import org.software.unicornapp.persistence.repo.ZoneRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UnicornService {

	@Autowired
	private UnicornRepo repo;

	@Autowired
	private ZoneRepo zoneRepo;

	/**
	 * 
	 * Returns all
	 * 
	 * @return
	 */
	public List<Unicorn> getAllUnicorns() {

		List<Unicorn> all = new ArrayList<>();

		all = this.repo.findAll();

		return all;
	}

	/**
	 * 
	 * Finds a specific unicorn
	 * 
	 * @param unicorn
	 * @return
	 */
	public Optional<Unicorn> getUnicornById(Integer unicornId) {

		return this.repo.findById(unicornId);
	}

	/**
	 * 
	 * @param unicorn
	 * @param newZoneId
	 * @return
	 */
	@Transactional
	public Boolean changeZone(Integer unicornId, Integer newZoneId) {

		if (newZoneId == 0 || null == unicornId) {
			return Boolean.FALSE;
		}

		Optional<Unicorn> unicornById = this.getUnicornById(unicornId);
		if (null != unicornById.get()) {
			Optional<Zone> zone = this.zoneRepo.findById(newZoneId);
			if (null != zone.get()) {
				unicornById.get().setZoneId(zone.get());
			}
			this.repo.save(unicornById.get());
			return Boolean.TRUE;
		}

		return Boolean.FALSE;
	}

}
