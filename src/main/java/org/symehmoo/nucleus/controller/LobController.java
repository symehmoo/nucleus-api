package org.symehmoo.nucleus.controller;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.symehmoo.nucleus.model.LobDTO;
import org.symehmoo.nucleus.service.LobService;

@RestController
public class LobController {

	@Autowired
	private LobService lobService;

	@GetMapping("/lob")
	public Collection<LobDTO> getLobData(Sort sort) {
		return lobService.getLobDetails(sort);
	}

}
