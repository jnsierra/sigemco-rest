package co.com.codesoftware.configuration;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ConfigurationBean {

	@Bean
	public ModelMapper getModelMapper() {
		return new ModelMapper();
	}

}
