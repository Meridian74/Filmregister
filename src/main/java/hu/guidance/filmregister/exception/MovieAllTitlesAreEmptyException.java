package hu.guidance.filmregister.exception;

import org.zalando.problem.AbstractThrowableProblem;
import org.zalando.problem.Status;

import java.net.URI;

public class MovieAllTitlesAreEmptyException extends AbstractThrowableProblem {
    public MovieAllTitlesAreEmptyException(String message) {
        super(URI.create("movie/all-movie-title-empty"),
                "Give at least one movie title!",
                Status.NOT_MODIFIED,
                String.format("Can't modify the movie data, because of: %s", message));
    }
}
