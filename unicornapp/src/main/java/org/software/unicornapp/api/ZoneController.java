package org.software.unicornapp.api;

import java.util.List;

import org.software.unicornapp.persistence.entity.Zone;
import org.software.unicornapp.service.ZoneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * 
 * @author ahmad
 *
 */
@RestController
@RequestMapping("/api/zone")
public class ZoneController {

	@Autowired
	private ZoneService service;

	/**
	 * 
	 * Gets all the unicorns stored into the system
	 * 
	 * @return
	 */
	@RequestMapping(value = "/list", method = RequestMethod.GET, produces = { "application/json" })
	@ResponseBody
	public ResponseEntity<List<Zone>> getAll() {

		List<Zone> allUnicorns = this.service.getAllZones();

		return new ResponseEntity<>(allUnicorns, HttpStatus.OK);
	}

}
