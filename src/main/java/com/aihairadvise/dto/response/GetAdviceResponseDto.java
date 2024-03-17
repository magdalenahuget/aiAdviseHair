package com.aihairadvise.dto.response;

import com.aihairadvise.model.Advice;
import jakarta.persistence.*;
import lombok.*;

import java.util.Date;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
@Getter
@Setter
public class GetAdviceResponseDto {
    private Long id;
    private Advice.FaceShape faceShape;
    private Advice.ForeheadHeight foreheadHeight;
    private Advice.NoseSize noseSize;
    private Advice.LipFullness lipFullness;
    private Advice.EyeColor eyeColor;
    private Advice.Gender gender;
    private String recommendation;
    private Date timestamp;
}
