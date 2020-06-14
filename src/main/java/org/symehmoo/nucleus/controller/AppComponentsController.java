package org.symehmoo.nucleus.controller;

import java.util.Collection;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.symehmoo.nucleus.model.AppComponentsDTO;
import org.symehmoo.nucleus.model.AppComponentsSaveDTO;
import org.symehmoo.nucleus.service.AppComponentsService;

/**
 * Controller to expose app component get api and post api
 */
@RestController
public class AppComponentsController {

	@Autowired
	private AppComponentsService appComponentsService;

	/**
	 * API exposed to fetch app components records. Filtering can be applied on
	 * mnemonic id and name
	 */
	@GetMapping("/appcomponents")
	public Collection<AppComponentsDTO> getAppComponentsData(Sort sort, @RequestParam(required = false) UUID mnemonicId,
			@RequestParam(required = false) String mnemonicsName) {
		return appComponentsService.getAppComponentsDetails(sort, mnemonicId, mnemonicsName);
	}

	/**
	 * API exposed to add new app component
	 */
	@PostMapping("/addapplicationComponent")
	public AppComponentsDTO saveAppComponents(@RequestBody AppComponentsSaveDTO appComponentsSaveDTO) {
		return appComponentsService.save(appComponentsSaveDTO);
	}
}
