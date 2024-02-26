package com.aihairadvise.dto.request;

import com.aihairadvise.model.Advice;
import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
@Getter
@Setter
public class AdviceRequestDto {

    private Advice.FaceShape faceShape;
    private Advice.ForeheadHeight foreheadHeight;
    private Advice.NoseSize noseSize;
    private Advice.LipFullness lipFullness;
    private Advice.EyeColor eyeColor;
    private Advice.Gender gender;

}
