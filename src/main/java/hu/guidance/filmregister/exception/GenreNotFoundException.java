package hu.guidance.filmregister.exception;

import org.zalando.problem.AbstractThrowableProblem;
import org.zalando.problem.Status;

import java.net.URI;

public class GenreNotFoundException extends AbstractThrowableProblem {

    public GenreNotFoundException(Long id) {
        super(URI.create("genre/genre-not-found"),
                "Not found!",
                Status.NOT_FOUND,
                String.format("Movie genre with id %d not found!", id));
    }
}
