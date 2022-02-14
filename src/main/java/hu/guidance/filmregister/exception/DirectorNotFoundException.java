package hu.guidance.filmregister.exception;

import org.zalando.problem.AbstractThrowableProblem;
import org.zalando.problem.Status;

import java.net.URI;

public class DirectorNotFoundException extends AbstractThrowableProblem {
    public DirectorNotFoundException(Long id) {
        super(URI.create("director/director-not-found"),
                "Not found!",
                Status.NOT_FOUND,
                String.format("Director with id %d not found!", id));
    }
}
