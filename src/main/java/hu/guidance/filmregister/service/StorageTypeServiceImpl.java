package hu.guidance.filmregister.service;

import hu.guidance.filmregister.dto.CreateStorageTypeCommand;
import hu.guidance.filmregister.dto.StorageTypeDTO;
import hu.guidance.filmregister.dto.UpdateStorageTypeCommand;
import hu.guidance.filmregister.exception.StorageTypeNotFoundException;
import hu.guidance.filmregister.model.StorageType;
import hu.guidance.filmregister.repository.StorageTypeRepository;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.lang.reflect.Type;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class StorageTypeServiceImpl implements StorageTypeService {

    private final StorageTypeRepository storageTypeRepository;
    private final ModelMapper modelMapper;

    public StorageTypeServiceImpl(StorageTypeRepository storageTypeRepository, ModelMapper modelMapper) {
        this.storageTypeRepository = storageTypeRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public StorageTypeDTO createStorageType(CreateStorageTypeCommand command) {
        StorageType storageType = new StorageType();
        storageType.setName(command.getName());

        storageType = storageTypeRepository.save(storageType);
        return modelMapper.map(storageType, StorageTypeDTO.class);

    }

    @Override
    public StorageTypeDTO findStorageTypeById(long id) {
        Optional<StorageType> optionalStorageType = storageTypeRepository.findById(id);

        if (optionalStorageType.isPresent()) {
            return modelMapper.map(optionalStorageType.get(), StorageTypeDTO.class);
        }
        else {
            throw new StorageTypeNotFoundException(id);
        }
    }

    @Override
    @Transactional
    public StorageTypeDTO updateStorageType(long id, UpdateStorageTypeCommand command) {
        Optional<StorageType> optionalStorageType = storageTypeRepository.findById(id);

        if (optionalStorageType.isEmpty()) {
            throw new StorageTypeNotFoundException(id);
        }

        StorageType storageType = optionalStorageType.get();
        if (command.getName() != null && !command.getName().equals("") ) {
            storageType.setName(command.getName());
        }

        return modelMapper.map(storageType, StorageTypeDTO.class);
    }

    @Override
    public void deleteStorageTypeById(long id) {
        Optional<StorageType> optionalStorageType = storageTypeRepository.findById(id);
        if (optionalStorageType.isPresent()) {
            storageTypeRepository.deleteById(id);
        }
        else {
            throw new StorageTypeNotFoundException(id);
        }
    }

    @Override
    public List<StorageTypeDTO> listAllStorageTypes(Optional<String> prefix) {
        Type targetListType = new TypeToken<List<StorageTypeDTO>>(){}.getType();

        List<StorageType> storageType = storageTypeRepository.findAll();
        List<StorageType> filtered = storageType.stream()
                .filter(e -> prefix.isEmpty()
                        || e.getName().toLowerCase().startsWith(prefix.get().toLowerCase()))
                .collect(Collectors.toList());

        return modelMapper.map(filtered, targetListType);
    }
}
