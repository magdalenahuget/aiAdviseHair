package com.aihairadvise.dto.request;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
@Getter
@Setter
public class UpdateRecommendationRequestDto {
    private Long id;
    private String recommendation;
}
