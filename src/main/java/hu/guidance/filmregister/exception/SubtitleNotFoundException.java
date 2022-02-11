package hu.guidance.filmregister.exception;

import org.zalando.problem.AbstractThrowableProblem;
import org.zalando.problem.Status;

import java.net.URI;

public class SubtitleNotFoundException extends AbstractThrowableProblem {

    public SubtitleNotFoundException(long id) {
        super(URI.create("subtitle/subtitle-not-found"),
                "Not found!",
                Status.NOT_FOUND,
                String.format("Subtitle with id %d not found!", id));
    }

}
