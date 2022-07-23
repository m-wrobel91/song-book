package pl.mwrobel91.songbook.controller;

import org.springframework.validation.BeanPropertyBindingResult;
import org.springframework.validation.Errors;
import org.springframework.validation.ObjectError;
import org.springframework.validation.Validator;
import pl.mwrobel91.songbook.exception.WebserviceValidationException;

public class BaseController {
    protected void validate(final Object object, final String objectName, final Validator validator) {
        final Errors errors = new BeanPropertyBindingResult(object, objectName);
        validator.validate(object, errors);
        if (errors.hasErrors()) {
            final ObjectError objectError = errors.getAllErrors().get(0);
            throw new WebserviceValidationException(objectError.getCode());
        }
    }
}
