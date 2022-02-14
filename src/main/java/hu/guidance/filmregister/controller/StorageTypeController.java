package hu.guidance.filmregister.controller;

import hu.guidance.filmregister.dto.CreateStorageTypeCommand;
import hu.guidance.filmregister.dto.StorageTypeDTO;
import hu.guidance.filmregister.dto.UpdateStorageTypeCommand;
import hu.guidance.filmregister.service.StorageTypeService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/storagetype")
@Tag(name = "Operations on Storage Type records")
public class StorageTypeController {

    private final StorageTypeService storageTypeService;

    public StorageTypeController(StorageTypeService storageTypeService) {
        this.storageTypeService = storageTypeService;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    @Operation(summary = "Create a new storage type")
    @ApiResponse(responseCode = "201", description = "Storage type has been created")
    public StorageTypeDTO createStorageType(@Validated @RequestBody CreateStorageTypeCommand command) {
        return storageTypeService.createStorageType(command);
    }

    @GetMapping("/{id}")
    @Operation(summary = "Find and get a storage type by ID")
    public StorageTypeDTO findStorageTypeById(@PathVariable("id") Long id) {
        return storageTypeService.findStorageTypeById(id);
    }

    @PutMapping("/{id}")
    @Operation(summary = "Updating a storage type with given data founded it by ID number")
    public StorageTypeDTO updateStorageType(
            @Validated
            @PathVariable("id") Long id,
            @RequestBody UpdateStorageTypeCommand command) {
        return storageTypeService.updateStorageType(id, command);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @Operation(summary = "Delete a storage type by ID number")
    @ApiResponse(responseCode = "204", description = "Movie storageType has been deleted")
    public void deleteStorageType(@PathVariable("id") Long id) {
        storageTypeService.deleteStorageTypeById(id);
    }

    @GetMapping
    @Operation(summary = "List all storage type - filtered by optional prefix string")
    public List<StorageTypeDTO> listAllStorageTypes(@RequestParam Optional<String> prefix) {
        return storageTypeService.listAllStorageTypes(prefix);
    }
    
}
