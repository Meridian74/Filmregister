package hu.guidance.filmregister.exception;

import org.zalando.problem.AbstractThrowableProblem;
import org.zalando.problem.Status;

import java.net.URI;

public class AudioNotFoundException extends AbstractThrowableProblem {

    public AudioNotFoundException(Long id) {
        super(URI.create("audio/audio-not-found"),
                "Not found!",
                Status.NOT_FOUND,
                String.format("Audio with id %d not found!", id));
    }
}
