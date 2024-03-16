package com.aihairadvise.utils.extractors;

import java.io.*;
import java.util.Arrays;

public class RecommendationExtractor {

    public static void main(String[] args) {
        try {
//            String[] descriptions = extractAndSplitDescriptions("src/main/resources/aiRecommendationsPart2.txt");
            String[] descriptions = extractAndSplitDescriptions("src/main/resources/aiRecommendationsPart1.txt");

            for (String description : descriptions) {
                String textAfterChatGPT = extractTextAfterChatGPT(description);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static String[] extractAndSplitDescriptions(String filePath) throws Exception {
        StringBuilder fileContent = new StringBuilder();
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = br.readLine()) != null) {
                fileContent.append(line).append("\n");
            }
        }

        String[] descriptions = fileContent.toString().split("Give your most");
        // Remove the empty first element if present
        if (descriptions.length > 0 && descriptions[0].isEmpty()) {
            descriptions = Arrays.copyOfRange(descriptions, 1, descriptions.length);
        }
        return descriptions;
    }


    public static String extractTextAfterChatGPT(String recommendation) {
        String[] recommendationSplit = recommendation.split("ChatGPT");
        if (recommendationSplit.length > 1) {
            // REMEMBER! First number is not printed. It starts with 180, but it isn't displayed.

            String recommendationExtracted = recommendationSplit[1];
            // TODO: remember to check/fix last and first one
            recommendationExtracted = recommendationExtracted.substring(0, recommendationExtracted.length() - 5).trim();

            System.out.println(">>>>>>>>>>>>>>" + recommendationExtracted + "<<<<<<<<<<<<<<<<<<");

            return recommendationSplit[1];

        }
        return "empty";
    }
}
