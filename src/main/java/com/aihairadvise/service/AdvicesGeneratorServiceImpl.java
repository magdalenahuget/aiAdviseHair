package com.aihairadvise.service;

import com.aihairadvise.model.Advice;
import org.springframework.stereotype.Component;

@Component
public class AdvicesGeneratorServiceImpl implements AdvicesGeneratorService {

    public void generateAndDisplayAdvices() {
        Advice.FaceShape[] faceShapes = Advice.FaceShape.values();
        Advice.ForeheadHeight[] foreheadHeights = Advice.ForeheadHeight.values();
        Advice.NoseSize[] noseSizes = Advice.NoseSize.values();
        Advice.LipFullness[] lipFullnesses = Advice.LipFullness.values();
        Advice.EyeColor[] eyeColors = Advice.EyeColor.values();
        Advice.Gender[] genders = Advice.Gender.values();

        int counter = 0;
        for (Advice.FaceShape faceShape : faceShapes) {
            for (Advice.ForeheadHeight foreheadHeight : foreheadHeights) {
                for (Advice.NoseSize noseSize : noseSizes) {
                    for (Advice.LipFullness lipFullness : lipFullnesses) {
                        for (Advice.EyeColor eyeColor : eyeColors) {
                            for (Advice.Gender gender : genders) {
                                counter++;
                                Advice advice = createAdviceBy(faceShape, foreheadHeight, noseSize, lipFullness, eyeColor, gender);

                                displayHairSpecificPrompt(counter, advice);
                            }
                        }
                    }
                }
            }
        }
    }

    private Advice createAdviceBy(Advice.FaceShape faceShape, Advice.ForeheadHeight foreheadHeight, Advice.NoseSize noseSize, Advice.LipFullness lipFullness, Advice.EyeColor eyeColor, Advice.Gender gender) {
        Advice advice = new Advice();
        advice.setFaceShape(faceShape);
        advice.setForeheadHeight(foreheadHeight);
        advice.setNoseSize(noseSize);
        advice.setLipFullness(lipFullness);
        advice.setEyeColor(eyeColor);
        advice.setGender(gender);
        advice.setRecommendation("Example recommendation");
        return advice;
    }

    private void displayHairSpecificPrompt(int counter, Advice advice) {
        System.out.println(counter
                + ". Give your most recommended hairstyle based on the following human characteristics: "
                + advice.getFaceShape() + " face shape, "
                + advice.getForeheadHeight() + " forehead height, "
                + advice.getNoseSize() + " nose size, "
                + advice.getLipFullness() + " lipfullness, "
                + advice.getEyeColor() + " eye color, "
                + advice.getGender() + " gender."
                + " The description should be in 10 sentences and maximum of 150 words " +
                "without mentioning consulting with a specialist. " +
                "Make sure to have at least summarizing 2 sentences. " +
                "The last part of your answer should be an summarization and start that with word \"Overall\". " +
                "Do not use break line between 'overall' section and description.");
    }
}
