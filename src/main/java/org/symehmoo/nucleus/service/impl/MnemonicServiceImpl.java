package org.symehmoo.nucleus.service.impl;

import java.util.Collection;
import java.util.List;
import java.util.Objects;
import java.util.UUID;
import java.util.function.Function;
import java.util.stream.Collectors;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.symehmoo.nucleus.entity.Lob;
import org.symehmoo.nucleus.entity.Mnemonic;
import org.symehmoo.nucleus.model.MnemonicDTO;
import org.symehmoo.nucleus.model.MnemonicSaveDTO;
import org.symehmoo.nucleus.repository.LobRepository;
import org.symehmoo.nucleus.repository.MnemonicRepository;
import org.symehmoo.nucleus.service.MnemonicService;
import org.symehmoo.nucleus.specification.MnemonicSpecifications;

@Service
public class MnemonicServiceImpl implements MnemonicService {

	private final MnemonicRepository mnemonicRepository;

	private final MnemonicSpecifications mnemonicSpecifications;

	private final LobRepository lobRepository;

	@Autowired
	public MnemonicServiceImpl(MnemonicRepository mnemonicRepository, MnemonicSpecifications mnemonicSpecifications,
			LobRepository lobRepository) {
		this.mnemonicRepository = mnemonicRepository;
		this.mnemonicSpecifications = mnemonicSpecifications;
		this.lobRepository = lobRepository;
	}

	/**
	 * {@inheritDoc}
	 */
	public Collection<MnemonicDTO> getMnemonicDetails(Sort sort, UUID lobId, String lobName) {
		List<Mnemonic> mnemonicDatas = mnemonicRepository
				.findAll(mnemonicSpecifications.createMnemonicSpecification(lobId, lobName), sort);
		List<MnemonicDTO> mnemonicDtos = mnemonicDatas.stream().map(convertToDTOFunc()).collect(Collectors.toList());
		return mnemonicDtos;
	}

	/**
	 * Function to convert Entity object To DTO object
	 * 
	 * @return {@link Function}
	 */
	private Function<Mnemonic, MnemonicDTO> convertToDTOFunc() {
		Function<Mnemonic, MnemonicDTO> convertToDTOFunc = mnemonic -> {
			MnemonicDTO mnemonicDTO = new MnemonicDTO();
			mnemonicDTO.setId(mnemonic.getId());
			mnemonicDTO.setMnemonicName(mnemonic.getMnemonicsName());
			mnemonicDTO.setLobName(mnemonic.getLobName());
			return mnemonicDTO;
		};
		return convertToDTOFunc;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public MnemonicDTO save(MnemonicSaveDTO mnemonicSaveDTO) {
		validateRequest(mnemonicSaveDTO);
		Lob lob = lobRepository.findByLobNameIgnoreCase(mnemonicSaveDTO.getLobName());
		if (Objects.isNull(lob)) {
			throw new RuntimeException("Lob with this name not found");
		}
		Mnemonic mnemonic = mnemonicRepository.findByMnemonicsNameIgnoreCase(mnemonicSaveDTO.getMnemonicName());
		if (Objects.nonNull(mnemonic)) {
			throw new RuntimeException("Mnemonic with this name alreday exist");
		}
		Mnemonic mnemonicToSave = new Mnemonic();
		mnemonicToSave.setLob(lob);
		mnemonicToSave.setMnemonicsName(mnemonicSaveDTO.getMnemonicName());
		mnemonicToSave.setLobName(mnemonicSaveDTO.getLobName());
		mnemonicRepository.save(mnemonicToSave);
		return convertToDTOFunc().apply(mnemonicToSave);
	}

	/**
	 * Method to validate parameters in post request object
	 * 
	 * @param mnemonicSaveDTO
	 */
	private void validateRequest(MnemonicSaveDTO mnemonicSaveDTO) {
		if (StringUtils.isBlank(mnemonicSaveDTO.getLobName())) {
			throw new RuntimeException("Lob name cannot be null");
		}
		if (StringUtils.isBlank(mnemonicSaveDTO.getMnemonicName())) {
			throw new RuntimeException("Mnemonic name cannot be null");
		}
	}
}
