package com.nexum.backend.infra.streaming;

import org.springframework.web.servlet.mvc.method.annotation.StreamingResponseBody;

public interface StreamingService<T> {
    StreamingResponseBody streamData();
}
