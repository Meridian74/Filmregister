package hu.guidance.filmregister.exception;

import org.zalando.problem.AbstractThrowableProblem;
import org.zalando.problem.Status;

import java.net.URI;

public class MovieNotFoundException extends AbstractThrowableProblem {

    public MovieNotFoundException(long id) {
        super(URI.create("movie/movie-not-found"),
                "Not found!",
                Status.NOT_FOUND,
                String.format("Movie with id %d not found!", id));
    }
}
