package org.symehmoo.nucleus.controller;

import java.util.Collection;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.lang.Nullable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.symehmoo.nucleus.model.MnemonicDTO;
import org.symehmoo.nucleus.service.MnemonicService;

@RestController
public class MnemonicController {

	@Autowired
	private MnemonicService mnemonicService;

	@GetMapping("/mnemonic")
	public Collection<MnemonicDTO> getMnemonicData(Sort sort, @Nullable @RequestParam UUID lobId) {
		return mnemonicService.getMnemonicDetails(sort, lobId);
	}

}
