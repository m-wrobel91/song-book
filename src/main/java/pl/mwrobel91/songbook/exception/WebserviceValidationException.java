package pl.mwrobel91.songbook.exception;

import java.util.Objects;

public class WebserviceValidationException extends RuntimeException {
    private final transient Object validationObject;

    public WebserviceValidationException(Object validationObject) {
        super(Objects.toString(validationObject));
        this.validationObject = validationObject;
    }

    public Object getValidationObject() {
        return this.validationObject;
    }
}