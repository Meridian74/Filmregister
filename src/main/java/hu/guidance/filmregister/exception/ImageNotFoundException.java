package hu.guidance.filmregister.exception;

import org.zalando.problem.AbstractThrowableProblem;
import org.zalando.problem.Status;

import java.net.URI;

public class ImageNotFoundException extends AbstractThrowableProblem {
    public ImageNotFoundException(Long id) {
        super(URI.create("image/image-not-found"),
                "Not found!",
                Status.NOT_FOUND,
                String.format("Image can not found with %d ID", id));
    }


}
