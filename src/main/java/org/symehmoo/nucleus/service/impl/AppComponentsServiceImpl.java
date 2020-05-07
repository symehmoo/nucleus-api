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
import org.symehmoo.nucleus.entity.AppComponents;
import org.symehmoo.nucleus.model.AppComponentsDTO;
import org.symehmoo.nucleus.repository.AppComponentsRepository;
import org.symehmoo.nucleus.service.AppComponentsService;
import org.symehmoo.nucleus.specification.AppComponentSpecifications;

@Service
public class AppComponentsServiceImpl implements AppComponentsService {

	private final AppComponentsRepository appComponentsRepository;

	private final AppComponentSpecifications appComponentSpecifications;

	@Autowired
	public AppComponentsServiceImpl(AppComponentsRepository appComponentsRepository,
			AppComponentSpecifications appComponentSpecifications) {
		this.appComponentsRepository = appComponentsRepository;
		this.appComponentSpecifications = appComponentSpecifications;
	}

	public Collection<AppComponentsDTO> getAppComponentsDetails(Sort sort, UUID mnemonicId) {
		Specification<AppComponents> mnemonicSpecification = null;
		if (Objects.nonNull(mnemonicId)) {
			mnemonicSpecification = appComponentSpecifications.getEqualSpecification("mnemonic.id", mnemonicId);
		}
		List<AppComponents> appComponentsDatas = appComponentsRepository.findAll(mnemonicSpecification, sort);
		List<AppComponentsDTO> appComponentsDtos = appComponentsDatas.stream().map(appComponents -> {
			AppComponentsDTO appComponentsDTO = new AppComponentsDTO();
			appComponentsDTO.setId(appComponents.getId());
			appComponentsDTO.setAppComponentsName(appComponents.getAppComponentsName());
			return appComponentsDTO;
		}).collect(Collectors.toList());
		return appComponentsDtos;
	}
}
