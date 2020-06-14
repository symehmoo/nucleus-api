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
import org.symehmoo.nucleus.model.MnemonicDTO;
import org.symehmoo.nucleus.model.MnemonicSaveDTO;
import org.symehmoo.nucleus.service.MnemonicService;

/**
 * Controller to expose menmonic get api and post api
 */
@RestController
public class MnemonicController {

	@Autowired
	private MnemonicService mnemonicService;

	/**
	 * API exposed to fetch mnemonic records. Filtering can be applied on lob id
	 * and name
	 */
	@GetMapping("/mnemonic")
	public Collection<MnemonicDTO> getMnemonicData(Sort sort, @RequestParam(required = false) UUID lobId,
			@RequestParam(required = false) String lobName) {
		return mnemonicService.getMnemonicDetails(sort, lobId, lobName);
	}

	/**
	 * API exposed to add new mnemonic
	 */
	@PostMapping("/addmnemonic")
	public MnemonicDTO saveMnemonic(@RequestBody MnemonicSaveDTO mnemonicSaveDTO) {
		return mnemonicService.save(mnemonicSaveDTO);
	}
}
