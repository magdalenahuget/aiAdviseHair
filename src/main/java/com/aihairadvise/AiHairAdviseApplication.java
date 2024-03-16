package com.aihairadvise;

import com.aihairadvise.service.AdvicesGeneratorService;
import com.aihairadvise.service.AdvicesGeneratorServiceImpl;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class AiHairAdviseApplication {

	public static void main(String[] args) {
		SpringApplication.run(AiHairAdviseApplication.class, args);

		AdvicesGeneratorService generatorService = new AdvicesGeneratorServiceImpl();
		generatorService.generateAndDisplayAdvices();
	}

}
