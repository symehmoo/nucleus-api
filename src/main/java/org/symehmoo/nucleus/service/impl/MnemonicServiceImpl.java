package org.symehmoo.nucleus.service.impl;

import java.util.Collection;
import java.util.List;
import java.util.Objects;
import java.util.UUID;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
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

	public Collection<MnemonicDTO> getMnemonicDetails(Sort sort, UUID lobId) {
		Specification<Mnemonic> lobSpecification = null;
		if (Objects.nonNull(lobId)) {
			lobSpecification = mnemonicSpecifications.getEqualSpecification("lob.id", lobId);
		}
		List<Mnemonic> mnemonicDatas = mnemonicRepository.findAll(lobSpecification, sort);
		List<MnemonicDTO> mnemonicDTODtos = mnemonicDatas.stream().map(mnemonic -> {
			MnemonicDTO mnemonicDTO = new MnemonicDTO();
			mnemonicDTO.setId(mnemonic.getId());
			mnemonicDTO.setMnemonicName(mnemonic.getMnemonicsName());
			return mnemonicDTO;
		}).collect(Collectors.toList());
		return mnemonicDTODtos;
	}
}
