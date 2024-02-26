package com.aihairadvise.service;

import com.aihairadvise.configuration.exception.AdviceNotFoundException;
import com.aihairadvise.dto.request.AdviceRequestDto;
import com.aihairadvise.dto.request.AdviceResponseDto;
import com.aihairadvise.mapper.AdviceMapper;
import com.aihairadvise.model.Advice;
import com.aihairadvise.repository.AdviceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AdviceServiceImpl implements AdviceService {

    private final AdviceRepository adviceRepository;
    private final AdviceMapper adviceMapper;

    @Autowired
    public AdviceServiceImpl(AdviceRepository adviceRepository, AdviceMapper adviceMapper) {
        this.adviceRepository = adviceRepository;
        this.adviceMapper = adviceMapper;
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
            return adviceMapper.toResponseDTO(adviceOptional.get());
        } else {
            throw new AdviceNotFoundException("Advice not found for given attributes");
        }
    }


}