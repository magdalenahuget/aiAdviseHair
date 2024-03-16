package com.aihairadvise;

import com.aihairadvise.service.AdvicesGeneratorService;
import com.aihairadvise.service.AdvicesGeneratorServiceImpl;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class AiHairAdviseApplication {

	public static void main(String[] args) {
		SpringApplication.run(AiHairAdviseApplication.class, args);
	}

	// Needed to generate base data
//	public static void main(String[] args) {
//		ConfigurableApplicationContext context = SpringApplication.run(AiHairAdviseApplication.class, args);
//
//		AdvicesGeneratorService generatorService = context.getBean(AdvicesGeneratorService.class);
//		generatorService.generateAndSaveAdvices();
//	}
}
