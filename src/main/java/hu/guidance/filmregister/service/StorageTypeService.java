package hu.guidance.filmregister.service;

import hu.guidance.filmregister.dto.CreateStorageTypeCommand;
import hu.guidance.filmregister.dto.StorageTypeDTO;
import hu.guidance.filmregister.dto.UpdateStorageTypeCommand;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

public interface StorageTypeService {
    StorageTypeDTO createStorageType(CreateStorageTypeCommand command);

    StorageTypeDTO findStorageTypeById(Long id);

    @Transactional
    StorageTypeDTO updateStorageType(Long id, UpdateStorageTypeCommand command);

    void deleteStorageTypeById(Long id);

    List<StorageTypeDTO> listAllStorageTypes(Optional<String> prefix);
}
