package com.aihairadvise.service;

import com.aihairadvise.model.Advice;
import com.aihairadvise.repository.AdviceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Component
public class RecommendationExtractorServiceImpl implements RecommendationExtractorService {
    private final AdviceRepository adviceRepository;

    @Autowired
    public RecommendationExtractorServiceImpl(AdviceRepository adviceRepository) {
        this.adviceRepository = adviceRepository;
    }

    @Override
    public void extractAndDisplay() {
        StringBuilder fileContent = new StringBuilder();
        try (BufferedReader br = new BufferedReader(new FileReader("src/main/resources/aiRecommendationsAll.txt"))) {
            String line;
            while ((line = br.readLine()) != null) {
                fileContent.append(line).append("\n");
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        String[] recommendations = fileContent.toString().split("\\d+\\.");
        Pattern pattern = Pattern.compile("(?s)For a .*? Overall.*?\\.");

        int counter = 0;
        for (String recommendation : recommendations) {
            Matcher matcher = pattern.matcher(recommendation);
            if (matcher.find()) {
                System.out.println();
                counter++;
                System.out.println(counter);
                System.out.println(matcher.group().trim());
            }
        }
    }

    @Override
    public void extractAndSave() {

        System.out.println();
//        Advice advice2 = adviceRepository.getReferenceById(1L);
        Advice advice3 = adviceRepository.findAdviceById(1L);
        System.out.println();
        System.out.println();
        System.out.println();
//        System.out.println(advice2.toString());
        System.out.println(advice3.toString());
        System.out.println();
        System.out.println();
        System.out.println();

        StringBuilder fileContent = new StringBuilder();
        try (BufferedReader br = new BufferedReader(new FileReader("src/main/resources/aiRecommendationsAll.txt"))) {
            String line;
            while ((line = br.readLine()) != null) {
                fileContent.append(line).append("\n");
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        String[] recommendations = fileContent.toString().split("\\d+\\.");
        Pattern pattern = Pattern.compile("(?s)For a .*? Overall.*?\\.");

        int counter = 0;
        for (String recommendation : recommendations) {
            Matcher matcher = pattern.matcher(recommendation);
            if (matcher.find()) {
                counter++;
//                System.out.println();
//                System.out.println(counter);
                String recommendationSanitized = matcher.group().trim();
//                System.out.println(recommendationSanitized);

                Advice advice = adviceRepository.findAdviceById((long) counter);
                advice.setRecommendation(recommendationSanitized);
                adviceRepository.save(advice);
            }
        }
    }

}
