package com.nexum.backend.infra.streaming;

import org.springframework.web.servlet.mvc.method.annotation.StreamingResponseBody;

import java.io.IOException;
import java.io.OutputStream;
import java.util.Collection;

public abstract class AbstractStreamingService<TClass> implements StreamingService<TClass> {
    protected abstract Collection<TClass> getData();

    protected abstract void writeData(TClass data, OutputStream outputStream) throws IOException;

    @Override
    public StreamingResponseBody streamData() {
        Collection<TClass> data = getData();

        return outputStream -> {
            try {
                for (TClass item : data) {
                    writeData(item, outputStream);
                    outputStream.flush();
                }
            }catch (IOException e){
                throw new RuntimeException("Error streaming data", e);
            }
        };
    }
}
