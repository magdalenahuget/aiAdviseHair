package com.aihairadvise.mapper;

import com.aihairadvise.dto.request.AdviceRequestDto;
import com.aihairadvise.dto.response.AdviceResponseDto;
import com.aihairadvise.dto.response.GetAdviceResponseDto;
import com.aihairadvise.model.Advice;
import org.springframework.stereotype.Component;

@Component
public class AdviceMapper {

    public AdviceResponseDto toResponseDTO(Advice advice) {
        AdviceResponseDto responseDTO = new AdviceResponseDto();
        responseDTO.setRecommendation(advice.getRecommendation());
        return responseDTO;
    }

    public GetAdviceResponseDto toGetAllResponseDto(Advice advice) {
        GetAdviceResponseDto responseDTO = new GetAdviceResponseDto();
        responseDTO.setFaceShape(advice.getFaceShape());
        responseDTO.setForeheadHeight(advice.getForeheadHeight());
        responseDTO.setNoseSize(advice.getNoseSize());
        responseDTO.setLipFullness(advice.getLipFullness());
        responseDTO.setEyeColor(advice.getEyeColor());
        responseDTO.setGender(advice.getGender());
        responseDTO.setRecommendation(advice.getRecommendation());
        return responseDTO;
    }

    public Advice fromRequestDTO(AdviceRequestDto requestDTO) {
        Advice advice = new Advice();
        advice.setFaceShape(requestDTO.getFaceShape());
        advice.setForeheadHeight(requestDTO.getForeheadHeight());
        advice.setNoseSize(requestDTO.getNoseSize());
        advice.setLipFullness(requestDTO.getLipFullness());
        advice.setEyeColor(requestDTO.getEyeColor());
        advice.setGender(requestDTO.getGender());
        return advice;
    }
}