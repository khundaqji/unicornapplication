package org.software.unicornapp.api;

import java.util.List;

import org.software.unicornapp.api.request.UnicornRequest;
import org.software.unicornapp.persistence.entity.Unicorn;
import org.software.unicornapp.service.UnicornService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.Assert;
import org.springframework.web.bind.annotation.RequestBody;
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
@RequestMapping("/api/unicorn")
public class ApiController {

	@Autowired
	private UnicornService service;

	/**
	 * 
	 * Gets all the unicorns stored into the system
	 * 
	 * @return
	 */
	@RequestMapping(value = "/list", method = RequestMethod.GET, produces = { "application/json" })
	@ResponseBody
	public ResponseEntity<List<Unicorn>> getAll() {

		List<Unicorn> allUnicorns = this.service.getAllUnicorns();

		return new ResponseEntity<>(allUnicorns, HttpStatus.OK);
	}

	/**
	 * 
	 * Changes the zone of the given unicorn
	 * 
	 * @param unicorn
	 * @return
	 */
	@RequestMapping(value = "/changezone", method = RequestMethod.POST, produces = { "application/json" }, consumes = {
			"application/json" })
	@ResponseBody
	public ResponseEntity<Boolean> changeZone(@RequestBody UnicornRequest unicorn) {

		Assert.notNull(unicorn, "Unicorn cannot be empty");
		Assert.notNull(unicorn.getZoneId(), "Unicorn new ZoneId cannot be empty");

		Boolean reuslt = this.service.changeZone(unicorn.getId(), unicorn.getZoneId());

		return new ResponseEntity<>(reuslt, HttpStatus.OK);
	}

}