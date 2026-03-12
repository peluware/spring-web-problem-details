package com.peluware.springframework.web.problemdetails;

import org.springframework.http.ProblemDetail;
import org.springframework.web.context.request.WebRequest;

public interface ProblemDetailRepresentable {
    ProblemDetail toProblemDetail(WebRequest request);
}
