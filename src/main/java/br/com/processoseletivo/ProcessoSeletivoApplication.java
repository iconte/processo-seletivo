package br.com.processoseletivo;

import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@SpringBootApplication
public class ProcessoSeletivoApplication {
	
	@Configuration
	public class ModelMapperConfig {
	  @Bean
	  public ModelMapper modelMapper() {
	    return new ModelMapper();
	  }
	}

	public static void main(String[] args) {
		SpringApplication.run(ProcessoSeletivoApplication.class, args);
	}

}
