package org.symehmoo.nucleus.service.impl;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.symehmoo.nucleus.entity.Lob;
import org.symehmoo.nucleus.model.LobDTO;
import org.symehmoo.nucleus.repository.LobRepository;
import org.symehmoo.nucleus.service.LobService;

@Service
public class LobServiceImpl implements LobService {

	private final LobRepository lobRepository;

	@Autowired
	public LobServiceImpl(LobRepository lobRepository) {
		this.lobRepository = lobRepository;
	}

	public Collection<LobDTO> getLobDetails(Sort sort) {
		List<Lob> lobDatas = lobRepository.findAll(sort);
		List<LobDTO> lobDtos = lobDatas.stream().map(lob -> {
			LobDTO lobDTO = new LobDTO();
			lobDTO.setId(lob.getId());
			lobDTO.setLobName(lob.getLobName());
			return lobDTO;
		}).collect(Collectors.toList());
		return lobDtos;
	}
}
