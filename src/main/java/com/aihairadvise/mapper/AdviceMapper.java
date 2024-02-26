package com.aihairadvise.mapper;

import com.aihairadvise.dto.request.AdviceResponseDto;
import com.aihairadvise.model.Advice;
import org.springframework.stereotype.Component;

@Component
public class AdviceMapper {

    public AdviceResponseDto toResponseDTO(Advice advice) {
        AdviceResponseDto responseDTO = new AdviceResponseDto();
        responseDTO.setId(advice.getId());
        responseDTO.setFaceShape(advice.getFaceShape().toString());
        responseDTO.setForeheadHeight(advice.getForeheadHeight().toString());
        responseDTO.setNoseSize(advice.getNoseSize().toString());
        responseDTO.setLipFullness(advice.getLipFullness().toString());
        responseDTO.setEyeColor(advice.getEyeColor().toString());
        responseDTO.setGender(advice.getGender().toString());
        return responseDTO;
    }
}