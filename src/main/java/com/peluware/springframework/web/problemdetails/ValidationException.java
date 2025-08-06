package com.peluware.springframework.web.problemdetails;

import com.peluware.springframework.web.problemdetails.schemas.ValidationErrors;
import lombok.Getter;

/**
 * Exception thrown when a request fails validation and contains one or more validation errors.
 * <p>
 * This exception is intended to be used in web applications to represent structured validation
 * issues that can be serialized and returned to clients, typically as part of a standardized
 * error response (e.g., using RFC 9457 Problem Details).
 */
@Getter
public class ValidationException extends RuntimeException {

    /**
     * Holds the detailed validation errors associated with the exception.
     * This field is marked as {@code transient} to avoid serialization issues in certain contexts.
     */
    private final transient ValidationErrors validationErrors;

    /**
     * Constructs a new {@code ValidationException} with a default message and the specified validation errors.
     *
     * @param validationErrors the validation errors that caused the exception
     */
    public ValidationException(ValidationErrors validationErrors) {
        super("Validation error");
        this.validationErrors = validationErrors;
    }

    /**
     * Constructs a new {@code ValidationException} with a custom message and the specified validation errors.
     *
     * @param validationErrors the validation errors that caused the exception
     * @param message the custom message for the exception
     */
    public ValidationException(ValidationErrors validationErrors, String message) {
        super(message);
        this.validationErrors = validationErrors;
    }
}
