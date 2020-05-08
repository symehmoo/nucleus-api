package org.symehmoo.nucleus.controller;

import java.util.Collection;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.lang.Nullable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.symehmoo.nucleus.model.AppComponentsDTO;
import org.symehmoo.nucleus.service.AppComponentsService;

@RestController
public class AppComponentsController {

	@Autowired
	private AppComponentsService appComponentsService;

	@GetMapping("/appcomponents")
	public Collection<AppComponentsDTO> getAppComponentsData(Sort sort, @Nullable @RequestParam UUID mnemonicId,
			@Nullable @RequestParam String mnemonicsName) {
		return appComponentsService.getAppComponentsDetails(sort, mnemonicId, mnemonicsName);
	}
}
