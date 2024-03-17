package com.aihairadvise.service;

import com.aihairadvise.dto.request.AdviceRequestDto;
import com.aihairadvise.dto.response.AdviceResponseDto;
import com.aihairadvise.dto.response.GetAdviceResponseDto;
import com.aihairadvise.model.Advice;

public interface AdviceService {
    AdviceResponseDto getAdviceByAttributes(AdviceRequestDto requestDTO);
    Advice updateRecommendation(Long id, String recommendation);
    GetAdviceResponseDto getAdviceById(Long adviceId);
}