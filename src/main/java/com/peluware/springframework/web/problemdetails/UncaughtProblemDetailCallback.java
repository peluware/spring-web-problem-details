package com.peluware.springframework.web.problemdetails;

import org.springframework.http.ProblemDetail;

/**
 * Functional interface used to handle uncaught exceptions by customizing the {@link ProblemDetail}
 * before it is returned in the HTTP response.
 * <p>
 * This can be useful to log unexpected errors, enrich the response with additional metadata,
 * or report the issue to external monitoring systems.
 */
@FunctionalInterface
public interface UncaughtProblemDetailCallback {

    /**
     * Called when an uncaught exception occurs and a {@link ProblemDetail} is being generated.
     *
     * @param exception the uncaught exception
     * @param problemDetail the generated {@link ProblemDetail} instance that can be customized
     */
    void call(Exception exception, ProblemDetail problemDetail);

    /**
     * Returns a no-op implementation of {@code UncaughtProblemDetailCallback}
     * that performs no action.
     *
     * @return a no-op {@code UncaughtProblemDetailCallback}
     */
    static UncaughtProblemDetailCallback none() {
        return (exception, problemDetails) -> {
            // No operation
        };
    }
}
