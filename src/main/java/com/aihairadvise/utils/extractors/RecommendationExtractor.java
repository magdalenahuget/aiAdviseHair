package com.aihairadvise.utils.extractors;

import com.sun.tools.javac.Main;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;

public class RecommendationExtractor {

    public static void main(String[] args) {
        try {
            String[] descriptions = extractAndSplitDescriptions("src/main/resources/aiAnswersSecondPart.txt");
//            printArray(descriptions);
            System.out.println(Arrays.toString(descriptions));
            System.out.println(">>>>>>>>>>>>>>");
            System.out.println(descriptions[2]);
            System.out.println(">>>>>>>>>>>>>>");


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

    public static void printArray(String[] arr) {
        for (String s : arr) {
            System.out.println("Give your most" + s);
            System.out.println("=============");
        }
    }
}
