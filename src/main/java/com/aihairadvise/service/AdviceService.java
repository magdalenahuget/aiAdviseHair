package com.aihairadvise.service;

import com.aihairadvise.configuration.exception.AdviceNotFoundException;
import com.aihairadvise.dto.request.AdviceRequestDto;
import com.aihairadvise.dto.request.AdviceResponseDto;
import com.aihairadvise.model.Advice;
import com.aihairadvise.repository.AdviceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AdviceService {

    private final AdviceRepository adviceRepository;

    @Autowired
    public AdviceService(AdviceRepository adviceRepository) {
        this.adviceRepository = adviceRepository;
    }

    public AdviceResponseDto getAdviceByAttributes(AdviceRequestDto requestDTO) {
        Optional<Advice> adviceOptional = adviceRepository.findByAttributes(
                requestDTO.getFaceShape(),
                requestDTO.getForeheadHeight(),
                requestDTO.getNoseSize(),
                requestDTO.getLipFullness(),
                requestDTO.getEyeColor(),
                requestDTO.getGender()
        );
        if (adviceOptional.isPresent()) {
            // mapper
            return null;
        } else {
            throw new AdviceNotFoundException("Advice not found for given attributes");
        }
    }


}