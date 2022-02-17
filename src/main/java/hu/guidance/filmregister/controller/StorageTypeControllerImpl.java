package hu.guidance.filmregister.controller;

import hu.guidance.filmregister.dto.CreateStorageTypeCommand;
import hu.guidance.filmregister.dto.StorageTypeDTO;
import hu.guidance.filmregister.dto.UpdateStorageTypeCommand;
import hu.guidance.filmregister.service.StorageTypeService;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/storagetype")
@Tag(name = "Operations on Storage Type records")
public class StorageTypeControllerImpl implements StorageTypeController {

    private final StorageTypeService storageTypeService;

    public StorageTypeControllerImpl(StorageTypeService storageTypeService) {
        this.storageTypeService = storageTypeService;
    }

    @Override
    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public StorageTypeDTO createStorageType(@Valid @RequestBody CreateStorageTypeCommand command) {
        return storageTypeService.createStorageType(command);
    }

    @Override
    @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public StorageTypeDTO findStorageTypeById(@PathVariable("id") Long id) {
        return storageTypeService.findStorageTypeById(id);
    }

    @Override
    @PutMapping(value = "/{id}", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public StorageTypeDTO updateStorageType(
            @Valid
            @PathVariable("id") Long id,
            @RequestBody UpdateStorageTypeCommand command) {
        return storageTypeService.updateStorageType(id, command);
    }

    @Override
    @DeleteMapping("/{id}")
    public void deleteStorageType(@PathVariable("id") Long id) {
        storageTypeService.deleteStorageTypeById(id);
    }

    @Override
    @GetMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public List<StorageTypeDTO> listAllStorageTypes(@RequestParam Optional<String> prefix) {
        return storageTypeService.listAllStorageTypes(prefix);
    }
    
}
