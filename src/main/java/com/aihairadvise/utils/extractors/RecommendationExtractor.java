package com.aihairadvise.utils.extractors;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

public class RecommendationExtractor {
    public static void main(String[] args) {
        try {
            String[] descriptions = extractDescriptions("src/main/resources/aiAnswersSecondPart.txt");
            System.out.println(Arrays.toString(descriptions));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static String[] extractDescriptions(String filename) throws IOException {
        ArrayList<String> descriptionsList = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(filename))) {
            String line;
            StringBuilder description = new StringBuilder();
            while ((line = br.readLine()) != null) {
                if (line.startsWith("Give your most")) {
                    if (description.length() > 0) {
                        descriptionsList.add(description.toString());
                        description = new StringBuilder();
                    }
                    description.append(line);
                } else {
                    description.append(line);
                }
            }
            // Add the last description
            if (description.length() > 0) {
                descriptionsList.add(description.toString());
            }
        }
        return descriptionsList.toArray(new String[0]);
    }

    public static void printArray(String[] arr) {
        for (String s : arr) {
            System.out.println(s);
            System.out.println();
        }
    }
}
