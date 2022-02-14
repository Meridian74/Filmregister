package hu.guidance.filmregister.exception;

import org.zalando.problem.AbstractThrowableProblem;
import org.zalando.problem.Status;

import java.net.URI;

public class CodecFormatNotFoundException extends AbstractThrowableProblem {

    public CodecFormatNotFoundException(Long id) {
        super(URI.create("codecformat/codec-format-not-found"),
                "Not found!",
                Status.NOT_FOUND,
                String.format("Codec format with id %d not found!", id));
    }
}
