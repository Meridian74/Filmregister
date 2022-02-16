package hu.guidance.filmregister.exception;

import org.zalando.problem.AbstractThrowableProblem;
import org.zalando.problem.Status;

import java.net.URI;

public class ImageIOException extends AbstractThrowableProblem {

    public ImageIOException(String message) {
        super(URI.create("image/image-IO-error"),
                "Not found!",
                Status.UNPROCESSABLE_ENTITY,
                String.format("Image can nit be uploaded. Message: %s", message));
    }
}

