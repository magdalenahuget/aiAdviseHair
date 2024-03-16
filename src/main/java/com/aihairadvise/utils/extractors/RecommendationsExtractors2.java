package com.aihairadvise.utils.extractors;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RecommendationsExtractors2 {
    public static void main(String[] args) {
        String data = "1. Give your most recommended hairstyle based on the following human characteristics: SQUARE face shape, HIGH forehead height, LARGE nose size, FULL lipfullness, BLUE eye color, FEMALE gender. The description should be in 10 sentences and maximum of 150 words without mentioning consulting with a specialist. Make sure to have at least summarizing 2 sentences\n" +
                "ChatGPT\n" +
                "For a female with a square face shape, high forehead, large nose size, full lips, and blue eyes, a flattering hairstyle would be a layered shoulder-length cut with side-swept bangs. This style helps soften the angles of a square face, while side-swept bangs reduce the prominence of a high forehead and draw attention to the eyes. Layers add movement and texture to the hair, enhancing its natural volume. Soft waves or curls can further soften the overall look and complement facial features. Keeping the hair length around the shoulders maintains femininity while offering versatility in styling. It's crucial to avoid hairstyles that accentuate the squareness of the face, opting instead for styles that create balance and harmony. Overall, this recommended hairstyle aims to enhance the individual's natural beauty while achieving a stylish and flattering look suitable for various occasions.\n" +
                "\n" +
                "2. Give your most recommended hairstyle based on the following human characteristics: SQUARE face shape, HIGH forehead height, LARGE nose size, FULL lipfullness, BLUE eye color, MALE gender. The description should be in 10 sentences and maximum of 150 words without mentioning consulting with a specialist. Make sure to have at least summarizing 2 sentences\n" +
                "ChatGPT\n" +
                "For a male with a square face shape, high forehead, large nose size, full lips, and blue eyes, a suitable hairstyle would involve softening the angular features while maintaining a masculine appearance. A medium-length haircut with layers can help to reduce the squareness of the jawline and balance out facial proportions. Incorporating side-swept or textured bangs can minimize the appearance of a high forehead and draw attention to the eyes. Keeping the hair length around the ears and neck can create a clean and polished look. Adding subtle waves or texture to the hair can enhance softness while maintaining a masculine edge. It's important to avoid hairstyles that accentuate the squareness of the face, opting instead for styles that create a harmonious balance. Overall, this recommended hairstyle aims to enhance the individual's natural features while achieving a stylish and confident look suitable for various occasions.\n" +
                "\n" +
                "3. Give your most recommended hairstyle based on the following human characteristics: SQUARE face shape, HIGH forehead height, LARGE nose size, FULL lipfullness, BROWN eye color, FEMALE gender. The description should be in 10 sentences and maximum of 150 words without mentioning consulting with a specialist. Make sure to have at least summarizing 2 sentences\n" +
                "ChatGPT\n" +
                "For a female with a square face shape, high forehead, large nose size, full lips, and brown eyes, a flattering hairstyle would involve softening the angular features while enhancing the natural beauty of the eyes. A shoulder-length haircut with layers can help to soften the sharp angles of a square face while adding movement and texture to the hair. Side-swept bangs can minimize the appearance of a high forehead and draw attention to the eyes, enhancing their depth and warmth. Soft waves or curls can further soften the overall look and add femininity to the hairstyle. Keeping the hair length around the shoulders maintains versatility in styling while complementing facial features. It's essential to avoid hairstyles that emphasize the squareness of the face, opting instead for styles that create balance and harmony. Overall, this recommended hairstyle aims to enhance the individual's natural beauty while achieving a chic and sophisticated look suitable for various occasions.\n" +
                "\n" +
                "4. Give your most recommended hairstyle based on the following human characteristics: SQUARE face shape, HIGH forehead height, LARGE nose size, FULL lipfullness, BROWN eye color, MALE gender. The description should be in 10 sentences and maximum of 150 words without mentioning consulting with a specialist. Make sure to have at least summarizing 2 sentences\n" +
                "ChatGPT\n" +
                "For a male with a square face shape, high forehead, large nose size, full lips, and brown eyes, a suitable hairstyle would aim to soften the angular features while maintaining a masculine appearance. A medium-length haircut with layers can help to reduce the prominence of the square jawline and balance out facial proportions. Incorporating side-swept or textured bangs can minimize the appearance of a high forehead while adding interest to the hairstyle. Keeping the hair length around the ears and neck can create a polished look while allowing for easy maintenance. Adding subtle waves or texture to the hair can enhance softness while preserving a masculine edge. It's important to avoid hairstyles that accentuate the squareness of the face, opting instead for styles that create a harmonious balance. Overall, this recommended hairstyle aims to enhance the individual's natural features while achieving a stylish and confident look suitable for various occasions.\n" +
                "\n" +
                "5. Give your most recommended hairstyle based on the following human characteristics: SQUARE face shape, HIGH forehead height, LARGE nose size, FULL lipfullness, GREEN eye color, FEMALE gender. The description should be in 10 sentences and maximum of 150 words without mentioning consulting with a specialist. Make sure to have at least summarizing 2 sentences. Please start summarise with word \"Overall\"\n" +
                "ChatGPT\n" +
                "For a female with a square face shape, high forehead, large nose size, full lips, and green eyes, a flattering hairstyle would focus on softening the angular features while accentuating the captivating eye color. A shoulder-length haircut with soft layers can help to diminish the squareness of the jawline and add movement to the hair. Incorporating side-swept bangs can reduce the appearance of a high forehead and draw attention to the eyes, enhancing their beauty. Soft waves or curls can further soften the overall look and add a touch of femininity. Maintaining the hair length around the shoulders allows for versatility in styling while complementing facial features. It's important to avoid hairstyles that emphasize the squareness of the face, opting instead for styles that create balance and harmony. Overall, this recommended hairstyle aims to enhance the individual's natural beauty while achieving an elegant and sophisticated look suitable for various occasions.";

        StringBuilder fileContent = new StringBuilder();
//        try (BufferedReader br = new BufferedReader(new FileReader("src/main/resources/aiRecommendationsFirst5.txt"))) {
        try (BufferedReader br = new BufferedReader(new FileReader("src/main/resources/aiRecommendationsAll.txt"))) {
            String line;
            while ((line = br.readLine()) != null) {
                fileContent.append(line).append("\n");
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        String[] recommendations = fileContent.toString().split("\\d+\\.");
        System.out.println(recommendations.length);
        System.out.println("===========");
        System.out.println();
        System.out.println(recommendations[0]);
        System.out.println("===========");
        System.out.println();
        System.out.println(recommendations[1]);
        System.out.println("===========");
        System.out.println();

        Pattern pattern = Pattern.compile("(?s)For a .*? Overall.*?\\.");

        int counter = 0;
        for (String recommendation : recommendations) {
            Matcher matcher = pattern.matcher(recommendation);
            if (matcher.find()) {
                System.out.println();
                counter++;
                System.out.println(counter);
                System.out.println(matcher.group().trim());
                // 217 - 267
            }
        }
    }
}
