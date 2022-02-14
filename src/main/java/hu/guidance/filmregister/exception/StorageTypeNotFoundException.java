package hu.guidance.filmregister.exception;

import org.zalando.problem.AbstractThrowableProblem;
import org.zalando.problem.Status;

import java.net.URI;

public class StorageTypeNotFoundException extends AbstractThrowableProblem {
    public StorageTypeNotFoundException(Long id) {
        super(URI.create("storagetype/storage-type-not-found"),
                "Not found!",
                Status.NOT_FOUND,
                String.format("Storage type with id %d not found!", id));
    }

}
