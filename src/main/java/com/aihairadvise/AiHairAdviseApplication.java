package com.aihairadvise;

import com.aihairadvise.service.AdvicesGeneratorService;
import com.aihairadvise.service.AdvicesGeneratorServiceImpl;
import com.aihairadvise.service.RecommendationExtractorService;
import com.aihairadvise.service.RecommendationExtractorServiceImpl;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication(scanBasePackages = {"com.aihairadvise"})
public class AiHairAdviseApplication {

	public static void main(String[] args) {
		SpringApplication.run(AiHairAdviseApplication.class, args);
	}

	// Needed to generate base data - all advices are generated and saved in database
//	public static void main(String[] args) {
//		ConfigurableApplicationContext context = SpringApplication.run(AiHairAdviseApplication.class, args);
//
//		AdvicesGeneratorService generatorService = context.getBean(AdvicesGeneratorService.class);
//		generatorService.generateAndSaveAdvices();
//	}

	// Needed to update recommendations base data - all recommendations advices are being updated and saved in database
//	public static void main(String[] args) {
//		ConfigurableApplicationContext context = SpringApplication.run(AiHairAdviseApplication.class, args);
//
//		RecommendationExtractorService recommendationExtractorService = context.getBean(RecommendationExtractorServiceImpl.class);
//		recommendationExtractorService.extractAndSave();
//	}
}
