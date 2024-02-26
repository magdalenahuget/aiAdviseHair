package com.aihairadvise.service;

import com.aihairadvise.dto.request.AdviceRequestDto;
import com.aihairadvise.dto.request.AdviceResponseDto;

public interface AdviceService {
    AdviceResponseDto getAdviceByAttributes(AdviceRequestDto requestDTO);
}