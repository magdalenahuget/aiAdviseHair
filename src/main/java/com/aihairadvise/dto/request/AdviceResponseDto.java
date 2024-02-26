package com.aihairadvise.dto.request;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
@Getter
@Setter
public class AdviceResponseDto {

    private String faceShape;
    private String foreheadHeight;
    private String noseSize;
    private String lipFullness;
    private String eyeColor;
    private String gender;

}
