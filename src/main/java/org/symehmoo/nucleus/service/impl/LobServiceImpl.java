package org.symehmoo.nucleus.service.impl;

import java.util.Collection;
import java.util.List;
import java.util.Objects;
import java.util.function.Function;
import java.util.stream.Collectors;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.symehmoo.nucleus.entity.Lob;
import org.symehmoo.nucleus.model.LobDTO;
import org.symehmoo.nucleus.model.LobSaveDTO;
import org.symehmoo.nucleus.repository.LobRepository;
import org.symehmoo.nucleus.service.LobService;

@Service
public class LobServiceImpl implements LobService {

	private final LobRepository lobRepository;

	@Autowired
	public LobServiceImpl(LobRepository lobRepository) {
		this.lobRepository = lobRepository;
	}

	/**
	 * {@inheritDoc}
	 */
	public Collection<LobDTO> getLobDetails(Sort sort) {
		List<Lob> lobDatas = lobRepository.findAll(sort);
		List<LobDTO> lobDtos = lobDatas.stream().map(convertToDTOFunc()).collect(Collectors.toList());
		return lobDtos;
	}

	/**
	 * Function to convert Entity object To DTO object
	 * 
	 * @return {@link Function}
	 */
	private Function<Lob, LobDTO> convertToDTOFunc() {
		Function<Lob, LobDTO> convertToDTOFunc = lob -> {
			LobDTO lobDTO = new LobDTO();
			lobDTO.setId(lob.getId());
			lobDTO.setLobName(lob.getLobName());
			return lobDTO;
		};
		return convertToDTOFunc;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public LobDTO save(LobSaveDTO lobSaveDTO) {
		validateRequest(lobSaveDTO);
		Lob lob = new Lob();
		lob.setLobName(lobSaveDTO.getLobName());
		lobRepository.save(lob);
		return convertToDTOFunc().apply(lob);
	}

	/**
	 * Method to validate parameters in post request object
	 * 
	 * @param lobSaveDTO
	 */
	private void validateRequest(LobSaveDTO lobSaveDTO) {
		if (StringUtils.isBlank(lobSaveDTO.getLobName())) {
			throw new RuntimeException("Lob name cannot be null");
		}
		Lob lob = lobRepository.findByLobNameIgnoreCase(lobSaveDTO.getLobName());
		if (Objects.nonNull(lob)) {
			throw new RuntimeException("Lob with this name already exist");
		}
	}
}
