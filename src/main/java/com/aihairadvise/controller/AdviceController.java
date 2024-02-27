package com.aihairadvise.controller;

import com.aihairadvise.configuration.exception.AdviceNotFoundException;
import com.aihairadvise.dto.request.AdviceRequestDto;
import com.aihairadvise.dto.request.AdviceResponseDto;
import com.aihairadvise.service.AdviceService;
import com.aihairadvise.validator.AdviceRequestValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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

    @PostMapping("/search")
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
}