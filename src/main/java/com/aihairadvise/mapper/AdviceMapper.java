package com.aihairadvise.mapper;

import com.aihairadvise.dto.request.AdviceResponseDto;
import com.aihairadvise.model.Advice;
import org.springframework.stereotype.Component;

@Component
public class AdviceMapper {

    public AdviceResponseDto toResponseDTO(Advice advice) {
        AdviceResponseDto responseDTO = new AdviceResponseDto();
        responseDTO.setRecommendation(advice.getRecommendation());
        return responseDTO;
    }
}