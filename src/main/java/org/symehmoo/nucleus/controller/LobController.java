package org.symehmoo.nucleus.controller;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.symehmoo.nucleus.model.LobDTO;
import org.symehmoo.nucleus.model.LobSaveDTO;
import org.symehmoo.nucleus.service.LobService;

/**
 * Controller to expose lob component get api and post api
 */
@RestController
public class LobController {

	@Autowired
	private LobService lobService;

	/**
	 * API exposed to fetch lob records.
	 */
	@GetMapping("/lob")
	public Collection<LobDTO> getLobData(Sort sort) {
		return lobService.getLobDetails(sort);
	}

	/**
	 * API exposed to add new lob
	 */
	@PostMapping("/addlob")
	public LobDTO saveLob(@RequestBody LobSaveDTO lobSaveDTO) {
		return lobService.save(lobSaveDTO);
	}

}
