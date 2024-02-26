package com.aihairadvise.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.*;
import lombok.*;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Getter
@Setter
@Table(name = "advice")
public class Advice {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(EnumType.STRING)
    @Column(name = "face_shape")
    private FaceShape faceShape;

    @Enumerated(EnumType.STRING)
    @Column(name = "forehead_height")
    private ForeheadHeight foreheadHeight;

    @Enumerated(EnumType.STRING)
    @Column(name = "nose_size")
    private NoseSize noseSize;

    @Enumerated(EnumType.STRING)
    @Column(name = "lip_fullness")
    private LipFullness lipFullness;

    @Enumerated(EnumType.STRING)
    @Column(name = "eye_color")
    private EyeColor eyeColor;

    @Enumerated(EnumType.STRING)
    @Column(name = "gender")
    private Gender gender;

    // Enums for subcharacteristics
    public enum FaceShape {
        SQUARE, ROUND
    }

    public enum ForeheadHeight {
        HIGH, LOW, MEDIUM
    }

    public enum NoseSize {
        LARGE, SMALL, MEDIUM
    }

    public enum LipFullness {
        FULL, NOT_FULL
    }

    public enum EyeColor {
        BLUE, BROWN, GREEN, BLACK
    }

    public enum Gender {
        FEMALE, MALE
    }
}
