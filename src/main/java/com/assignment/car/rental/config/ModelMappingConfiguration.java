package com.assignment.car.rental.config;

import org.modelmapper.ModelMapper;
import org.modelmapper.config.Configuration.AccessLevel;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Configs related to mapping of models
 *
 * @author Shashi Ranjan
 *
 */
@Configuration
public class ModelMappingConfiguration {

	@Bean
	public ModelMapper modelMapper() {
		final var modelMapper = new ModelMapper();
		modelMapper.getConfiguration().setFieldMatchingEnabled(true).setFieldAccessLevel(AccessLevel.PRIVATE);
		return modelMapper;
	}

}
