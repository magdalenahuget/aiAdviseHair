package com.aihairadvise.validator;

import com.aihairadvise.dto.request.AdviceRequestDto;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;

@Component
public class AdviceRequestValidator implements Validator {

    @Override
    public boolean supports(Class<?> clazz) {
        return AdviceRequestDto.class.equals(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        AdviceRequestDto requestDTO = (AdviceRequestDto) target;

        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "faceShape", "field.required", "Face shape is required");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "foreheadHeight", "field.required", "Forehead height is required");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "noseSize", "field.required", "Nose size is required");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "lipFullness", "field.required", "Lip fullness is required");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "eyeColor", "field.required", "Eye color is required");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "gender", "field.required", "Gender is required");
    }
}