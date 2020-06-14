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
import org.symehmoo.nucleus.entity.AppComponents;
import org.symehmoo.nucleus.entity.Mnemonic;
import org.symehmoo.nucleus.model.AppComponentsDTO;
import org.symehmoo.nucleus.model.AppComponentsSaveDTO;
import org.symehmoo.nucleus.repository.AppComponentsRepository;
import org.symehmoo.nucleus.repository.MnemonicRepository;
import org.symehmoo.nucleus.service.AppComponentsService;
import org.symehmoo.nucleus.specification.AppComponentSpecifications;

@Service
public class AppComponentsServiceImpl implements AppComponentsService {

	private final AppComponentsRepository appComponentsRepository;

	private final AppComponentSpecifications appComponentSpecifications;

	private final MnemonicRepository mnemonicRepository;

	@Autowired
	public AppComponentsServiceImpl(AppComponentsRepository appComponentsRepository,
			AppComponentSpecifications appComponentSpecifications, MnemonicRepository mnemonicRepository) {
		this.appComponentsRepository = appComponentsRepository;
		this.appComponentSpecifications = appComponentSpecifications;
		this.mnemonicRepository = mnemonicRepository;
	}

	/**
	 * {@inheritDoc}
	 */
	public Collection<AppComponentsDTO> getAppComponentsDetails(Sort sort, UUID mnemonicId, String mnemonicsName) {
		List<AppComponents> appComponentsDatas = appComponentsRepository
				.findAll(appComponentSpecifications.createAppComponentsSpecification(mnemonicId, mnemonicsName), sort);
		List<AppComponentsDTO> appComponentsDtos = appComponentsDatas.stream().map(convertToDTOFunc())
				.collect(Collectors.toList());
		return appComponentsDtos;

	}

	/**
	 * Function to convert Entity object To DTO object
	 * 
	 * @return {@link Function}
	 */
	private Function<AppComponents, AppComponentsDTO> convertToDTOFunc() {
		Function<AppComponents, AppComponentsDTO> convertToDTOFunc = appComponents -> {
			AppComponentsDTO appComponentsDTO = new AppComponentsDTO();
			appComponentsDTO.setId(appComponents.getId());
			appComponentsDTO.setAppComponentsName(appComponents.getAppComponentsName());
			if (Objects.nonNull(appComponents.getMnemonic())) {
				appComponentsDTO.setMnemonicName(appComponents.getMnemonic().getMnemonicsName());
			}
			return appComponentsDTO;
		};
		return convertToDTOFunc;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public AppComponentsDTO save(AppComponentsSaveDTO appComponentsSaveDTO) {
		validateRequest(appComponentsSaveDTO);
		Mnemonic mnemonic = mnemonicRepository.findByMnemonicsNameIgnoreCase(appComponentsSaveDTO.getMnemonicName());
		if (Objects.isNull(mnemonic)) {
			throw new RuntimeException("Mnemonic with this name not found");
		}
		AppComponents appComponents = appComponentsRepository.findByMnemonic_IdAndAppComponentsNameIgnoreCase(
				mnemonic.getId(), appComponentsSaveDTO.getAppComponentsName());
		if (Objects.nonNull(appComponents)) {
			throw new RuntimeException("App components with this name alreday exist");
		}
		AppComponents appComponentsToSave = new AppComponents();
		appComponentsToSave.setMnemonic(mnemonic);
		appComponentsToSave.setAppComponentsName(appComponentsSaveDTO.getAppComponentsName());
		appComponentsRepository.save(appComponentsToSave);
		return convertToDTOFunc().apply(appComponentsToSave);
	}

	/**
	 * Method to validate parameters in post request object
	 * 
	 * @param appComponentsSaveDTO
	 */
	private void validateRequest(AppComponentsSaveDTO appComponentsSaveDTO) {
		if (StringUtils.isBlank(appComponentsSaveDTO.getMnemonicName())) {
			throw new RuntimeException("Mnemonic name cannot be null");
		}
		if (StringUtils.isBlank(appComponentsSaveDTO.getAppComponentsName())) {
			throw new RuntimeException("App components name cannot be null");
		}
	}
}
