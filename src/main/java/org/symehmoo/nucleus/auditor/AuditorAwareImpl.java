package org.symehmoo.nucleus.auditor;

import java.util.Optional;

import org.springframework.data.domain.AuditorAware;

/**
 * Addded for user name. For now no use return empty.
 */
public class AuditorAwareImpl implements AuditorAware<String> {

	@Override
	public Optional<String> getCurrentAuditor() {
		return Optional.empty();
	}
}