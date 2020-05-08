package org.symehmoo.nucleus.service.impl;

import java.util.Collection;
import java.util.List;
import java.util.UUID;
import java.util.function.Function;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
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

	public Collection<AppComponentsDTO> getAppComponentsDetails(Sort sort, UUID mnemonicId, String mnemonicsName) {
		List<AppComponents> appComponentsDatas = appComponentsRepository
				.findAll(appComponentSpecifications.createAppComponentsSpecification(mnemonicId, mnemonicsName), sort);
		List<AppComponentsDTO> appComponentsDtos = appComponentsDatas.stream().map(convertToDTOFunc())
				.collect(Collectors.toList());
		return appComponentsDtos;

	}

	private Function<AppComponents, AppComponentsDTO> convertToDTOFunc() {
		Function<AppComponents, AppComponentsDTO> convertToDTOFunc = appComponents -> {
			AppComponentsDTO appComponentsDTO = new AppComponentsDTO();
			appComponentsDTO.setId(appComponents.getId());
			appComponentsDTO.setAppComponentsName(appComponents.getAppComponentsName());
			return appComponentsDTO;
		};
		return convertToDTOFunc;
	}
}
