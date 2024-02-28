package com.aihairadvise.utils.generators;

import com.aihairadvise.model.Advice;

public class AdvicesGenerator {
    public static void main(String[] args) {
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
                                Advice advice = new Advice();
                                advice.setFaceShape(faceShape);
                                advice.setForeheadHeight(foreheadHeight);
                                advice.setNoseSize(noseSize);
                                advice.setLipFullness(lipFullness);
                                advice.setEyeColor(eyeColor);
                                advice.setGender(gender);
                                advice.setRecommendation("Example recommendation");
                                System.out.println(counter + ". " + advice.toString());
                            }
                        }
                    }
                }
            }
        }
    }
}
