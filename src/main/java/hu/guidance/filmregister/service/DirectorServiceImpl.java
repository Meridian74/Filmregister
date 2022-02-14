package hu.guidance.filmregister.service;

import hu.guidance.filmregister.dto.DirectorDTO;
import hu.guidance.filmregister.dto.CreateDirectorCommand;
import hu.guidance.filmregister.dto.UpdateDirectorCommand;
import hu.guidance.filmregister.exception.DirectorNotFoundException;
import hu.guidance.filmregister.model.Director;
import hu.guidance.filmregister.repository.DirectorRepository;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.lang.reflect.Type;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class DirectorServiceImpl implements DirectorService {
    private final DirectorRepository directorRepository;
    private final ModelMapper modelMapper;

    public DirectorServiceImpl(DirectorRepository directorRepository, ModelMapper modelMapper) {
        this.directorRepository = directorRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public DirectorDTO createDirector(CreateDirectorCommand command) {
        Director director = new Director();
        director.setName(command.getName());
        director.setBirthDay(command.getBirthDay());

        director = directorRepository.save(director);
        return modelMapper.map(director, DirectorDTO.class);

    }

    @Override
    public DirectorDTO findDirectorById(Long id) {
        Optional<Director> optionalDirector= directorRepository.findById(id);

        if (optionalDirector.isPresent()) {
            return modelMapper.map(optionalDirector.get(), DirectorDTO.class);
        }
        else {
            throw new DirectorNotFoundException(id);
        }
    }

    @Override
    @Transactional
    public DirectorDTO updateDirector(Long id, UpdateDirectorCommand command) {
        Optional<Director> optionalDirector = directorRepository.findById(id);

        if (optionalDirector.isEmpty()) {
            throw new DirectorNotFoundException(id);
        }

        Director director = optionalDirector.get();
        if (command.getName() != null && !command.getName().equals("") ) {
            director.setName(command.getName());
        }
        if (command.getBirthDay() != null) {
            director.setBirthDay(command.getBirthDay());
        }

        return modelMapper.map(director, DirectorDTO.class);
    }

    @Override
    public void deleteDirectorById(Long id) {
        Optional<Director> optionalDirector = directorRepository.findById(id);
        if (optionalDirector.isPresent()) {
            directorRepository.deleteById(id);
        }
        else {
            throw new DirectorNotFoundException(id);
        }
    }

    @Override
    public List<DirectorDTO> listAllDirectors(Optional<String> prefix) {
        Type targetListType = new TypeToken<List<DirectorDTO>>(){}.getType();

        List<Director> director = directorRepository.findAll();
        List<Director> filtered = director.stream()
                .filter(e -> prefix.isEmpty()
                        || e.getName().toLowerCase().startsWith(prefix.get().toLowerCase()))
                .collect(Collectors.toList());

        return modelMapper.map(filtered, targetListType);
    }
}
