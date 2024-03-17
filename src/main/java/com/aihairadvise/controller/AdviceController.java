package com.aihairadvise.controller;

import com.aihairadvise.configuration.exception.AdviceNotFoundException;
import com.aihairadvise.dto.request.AdviceRequestDto;
import com.aihairadvise.dto.response.AdviceResponseDto;
import com.aihairadvise.dto.request.UpdateRecommendationRequestDto;
import com.aihairadvise.dto.response.GetAdviceResponseDto;
import com.aihairadvise.model.Advice;
import com.aihairadvise.service.AdviceService;
import com.aihairadvise.validator.AdviceRequestValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/advices")
public class AdviceController {
    private final AdviceService adviceService;
    private final AdviceRequestValidator adviceRequestValidator;

    @Autowired
    public AdviceController(AdviceService adviceService, AdviceRequestValidator adviceRequestValidator) {
        this.adviceService = adviceService;
        this.adviceRequestValidator = adviceRequestValidator;
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getAdviceById(@PathVariable(value="id") Long adviceId) {
        try {
            GetAdviceResponseDto advice = adviceService.getAdviceById(adviceId);
            return ResponseEntity.ok(advice);
        } catch (AdviceNotFoundException ex) {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping("/")
    public ResponseEntity<?> getAdviceByAttributes(@RequestBody AdviceRequestDto requestDTO, BindingResult result) {
        adviceRequestValidator.validate(requestDTO, result);
        if (result.hasErrors()) {
            return ResponseEntity.badRequest().body(result.getAllErrors());
        }

        try {
            AdviceResponseDto advice = adviceService.getAdviceByAttributes(requestDTO);
            return ResponseEntity.ok(advice);
        } catch (AdviceNotFoundException ex) {
            return ResponseEntity.notFound().build();
        }
    }

    @PutMapping("/")
    public ResponseEntity<?> updateRecommendation(@RequestBody UpdateRecommendationRequestDto updateDTO) {
        try {
            Advice updatedAdvice = adviceService.updateRecommendation(updateDTO.getAdviceId(), updateDTO.getRecommendation());
            return ResponseEntity.ok(updatedAdvice);
        } catch (AdviceNotFoundException ex) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(ex.getMessage());
        }
    }

//
//    private final AdviceService adviceService;
//
//    public AdviceController(AdviceService adviceService) {
//        this.adviceService = adviceService;
//    }
//
//    @PostMapping("/search")
//    public ResponseEntity<?> getAdviceByAttributes(@RequestBody AdviceRequestDto requestDTO) {
//        if (requestDTO.getFaceShape() == null ||
//                requestDTO.getForeheadHeight() == null ||
//                requestDTO.getNoseSize() == null ||
//                requestDTO.getLipFullness() == null ||
//                requestDTO.getEyeColor() == null ||
//                requestDTO.getGender() == null) {
//            return ResponseEntity.badRequest().body("Missing one or more required fields");
//        }
//
//        try {
//            AdviceResponseDto advice = adviceService.getAdviceByAttributes(requestDTO);
//            return ResponseEntity.ok(advice);
//        } catch (AdviceNotFoundException ex) {
//            return ResponseEntity.notFound().build();
//        }
//    }
}