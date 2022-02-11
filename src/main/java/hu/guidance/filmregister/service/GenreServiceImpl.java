package hu.guidance.filmregister.service;

import hu.guidance.filmregister.dto.GenreDTO;
import hu.guidance.filmregister.dto.CreateGenreCommand;
import hu.guidance.filmregister.dto.UpdateGenreCommand;
import hu.guidance.filmregister.exception.GenreNotFoundException;
import hu.guidance.filmregister.model.Genre;
import hu.guidance.filmregister.repository.GenreRepository;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.lang.reflect.Type;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class GenreServiceImpl implements GenreService {

    private final GenreRepository genreRepository;
    private final ModelMapper modelMapper;

    public GenreServiceImpl(GenreRepository genreRepository, ModelMapper modelMapper) {
        this.genreRepository = genreRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public GenreDTO createGenre(CreateGenreCommand command) {
        Genre genre = new Genre();
        genre.setName(command.getName());

        genre = genreRepository.save(genre);
        return modelMapper.map(genre, GenreDTO.class);

    }

    @Override
    public GenreDTO findGenreById(long id) {
        Optional<Genre> optionalGenre = genreRepository.findById(id);

        if (optionalGenre.isPresent()) {
            return modelMapper.map(optionalGenre.get(), GenreDTO.class);
        }
        else {
            throw new GenreNotFoundException(id);
        }
    }

    @Override
    @Transactional
    public GenreDTO updateGenre(long id, UpdateGenreCommand command) {
        Optional<Genre> optionalGenre = genreRepository.findById(id);

        if (optionalGenre.isEmpty()) {
            throw new GenreNotFoundException(id);
        }

        Genre genre = optionalGenre.get();
        if (command.getName() != null && !command.getName().equals("") ) {
            genre.setName(command.getName());
        }

        return modelMapper.map(genre, GenreDTO.class);
    }

    @Override
    public void deleteGenreById(long id) {
        Optional<Genre> optionalGenre = genreRepository.findById(id);
        if (optionalGenre.isPresent()) {
            genreRepository.deleteById(id);
        }
        else {
            throw new GenreNotFoundException(id);
        }
    }

    @Override
    public List<GenreDTO> listAllGenres(Optional<String> prefix) {
        Type targetListType = new TypeToken<List<GenreDTO>>(){}.getType();

        List<Genre> genre = genreRepository.findAll();
        List<Genre> filtered = genre.stream()
                .filter(e -> prefix.isEmpty()
                        || e.getName().toLowerCase().startsWith(prefix.get().toLowerCase()))
                .collect(Collectors.toList());

        return modelMapper.map(filtered, targetListType);
    }
}
