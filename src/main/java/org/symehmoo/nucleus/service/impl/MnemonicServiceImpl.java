package org.symehmoo.nucleus.service.impl;

import java.util.Collection;
import java.util.List;
import java.util.UUID;
import java.util.function.Function;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.symehmoo.nucleus.entity.Mnemonic;
import org.symehmoo.nucleus.model.MnemonicDTO;
import org.symehmoo.nucleus.repository.MnemonicRepository;
import org.symehmoo.nucleus.service.MnemonicService;
import org.symehmoo.nucleus.specification.MnemonicSpecifications;

@Service
public class MnemonicServiceImpl implements MnemonicService {

	private final MnemonicRepository mnemonicRepository;

	private final MnemonicSpecifications mnemonicSpecifications;

	@Autowired
	public MnemonicServiceImpl(MnemonicRepository mnemonicRepository, MnemonicSpecifications mnemonicSpecifications) {
		this.mnemonicRepository = mnemonicRepository;
		this.mnemonicSpecifications = mnemonicSpecifications;
	}

	public Collection<MnemonicDTO> getMnemonicDetails(Sort sort, UUID lobId, String lobName) {
		List<Mnemonic> mnemonicDatas = mnemonicRepository
				.findAll(mnemonicSpecifications.createMnemonicSpecification(lobId, lobName), sort);
		List<MnemonicDTO> mnemonicDtos = mnemonicDatas.stream().map(convertToDTOFunc()).collect(Collectors.toList());
		return mnemonicDtos;
	}

	private Function<Mnemonic, MnemonicDTO> convertToDTOFunc() {
		Function<Mnemonic, MnemonicDTO> convertToDTOFunc = mnemonic -> {
			MnemonicDTO mnemonicDTO = new MnemonicDTO();
			mnemonicDTO.setId(mnemonic.getId());
			mnemonicDTO.setMnemonicName(mnemonic.getMnemonicsName());
			return mnemonicDTO;
		};
		return convertToDTOFunc;
	}
}
