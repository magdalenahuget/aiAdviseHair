package com.aihairadvise.dto.response;

import lombok.*;

import java.util.Date;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
@Getter
@Setter
public class AdviceResponseDto {

    private String recommendation;
    private Date timestamp;
}
