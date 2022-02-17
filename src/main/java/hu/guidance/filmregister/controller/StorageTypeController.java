package hu.guidance.filmregister.controller;

import hu.guidance.filmregister.dto.CreateStorageTypeCommand;
import hu.guidance.filmregister.dto.StorageTypeDTO;
import hu.guidance.filmregister.dto.UpdateStorageTypeCommand;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

public interface StorageTypeController {
    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.CREATED)
    @Operation(summary = "Create a new storage type")
    @ApiResponse(responseCode = "201", description = "Storage type has been created")
    StorageTypeDTO createStorageType(@Valid @RequestBody CreateStorageTypeCommand command);

    @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    @Operation(summary = "Find and get a storage type by ID")
    StorageTypeDTO findStorageTypeById(@PathVariable("id") Long id);

    @PutMapping(value = "/{id}", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    @Operation(summary = "Updating a storage type with given data founded it by ID number")
    StorageTypeDTO updateStorageType(
            @Valid
            @PathVariable("id") Long id,
            @RequestBody UpdateStorageTypeCommand command);

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @Operation(summary = "Delete a storage type by ID number")
    @ApiResponse(responseCode = "204", description = "Movie storageType has been deleted")
    void deleteStorageType(@PathVariable("id") Long id);

    @GetMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    @Operation(summary = "List all storage type - filtered by optional prefix string")
    List<StorageTypeDTO> listAllStorageTypes(@RequestParam Optional<String> prefix);
}
