package hu.guidance.filmregister.service;

import hu.guidance.filmregister.dto.CreateMovieCommand;
import hu.guidance.filmregister.dto.MovieDTO;
import hu.guidance.filmregister.dto.UpdateMovieCommand;
import hu.guidance.filmregister.exception.MovieNotFoundException;
import hu.guidance.filmregister.model.Movie;
import hu.guidance.filmregister.repository.MovieRepository;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.lang.reflect.Type;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class MovieServiceImpl implements MovieService {

    private final MovieRepository movieRepository;
    private final ModelMapper modelMapper;

    public MovieServiceImpl(MovieRepository movieRepository, ModelMapper modelMapper) {
        this.movieRepository = movieRepository;
        this.modelMapper = modelMapper;
    }
    @Override
    public MovieDTO createMovie(CreateMovieCommand command) {
        Movie movie = new Movie();
        movie.setTitleHun(command.getTitleHun());
        movie.setTitleEnglish(command.getTitleEnglish());
        movie.setTitleOriginal(command.getTitleOriginal());
        movie.setDuration(command.getDuration());
        movie.setGenreId(command.getGenreId());
        movie.setDirectorId(command.getDirectorId());
        movie.setReleaseYear(command.getReleaseYear());
        movie.setCodecFormatId(command.getCodecFormatId());
        movie.setXResolution(command.getXResolution());
        movie.setYResolution(command.getYResolution());
        movie.setStorageTypeId(command.getStorageTypeId());
        movie.setStorageNumber(command.getStorageNumber());

        movie = movieRepository.save(movie);
        return modelMapper.map(movie, MovieDTO.class);
    }

    @Override
    public MovieDTO findMovieById(long id) {
        Optional<Movie> optionalMovie= movieRepository.findById(id);

        if (optionalMovie.isPresent()) {
            return modelMapper.map(optionalMovie.get(), MovieDTO.class);
        }
        else {
            throw new MovieNotFoundException(id);
        }
    }

    @Override
    @Transactional
    public MovieDTO updateMovie(long id, UpdateMovieCommand command) {
        Optional<Movie> optionalMovie = movieRepository.findById(id);

        if (optionalMovie.isEmpty()) {
            throw new MovieNotFoundException(id);
        }

        Movie movie = optionalMovie.get();
        if (command.getTitleHun() != null && !command.getTitleHun().equals("") ) {
            movie.setTitleHun(command.getTitleHun());
        }
        if (command.getTitleEnglish() != null  && !command.getTitleEnglish().equals("")) {
            movie.setTitleEnglish(command.getTitleEnglish());
        }
        if (command.getTitleOriginal() != null  && !command.getTitleOriginal().equals("")) {
            movie.setTitleOriginal(command.getTitleOriginal());
        }
        if (command.getDuration() != null) {
            movie.setDuration(command.getDuration());
        }
        if (command.getGenreId() > 0) {
            movie.setGenreId(command.getGenreId());
        }
        if (command.getDirectorId() > 0) {
            movie.setDirectorId(command.getDirectorId());
        }
        if (command.getReleaseYear() > 1894) {
            movie.setReleaseYear(command.getReleaseYear());
        }
        if (command.getCodecFormatId() > 0) {
            movie.setCodecFormatId(command.getCodecFormatId());
        }
        if (command.getXResolution() > 0) {
            movie.setXResolution(command.getXResolution());
        }
        if (command.getYResolution() > 0) {
            movie.setYResolution(command.getYResolution());
        }
        if (command.getStorageTypeId() > 0) {
            movie.setStorageTypeId(command.getStorageTypeId());
        }
        if (command.getStorageNumber() > 0) {
            movie.setStorageNumber(command.getStorageNumber());
        }

        return modelMapper.map(movie, MovieDTO.class);
    }

    @Override
    public void deleteMovieById(long id) {
        Optional<Movie> optionalMovie = movieRepository.findById(id);
        if (optionalMovie.isPresent()) {
            movieRepository.deleteById(id);
        }
        else {
            throw new MovieNotFoundException(id);
        }
    }

    @Override
    public List<MovieDTO> listAllMovies(Optional<String> prefix) {
        Type targetListType = new TypeToken<List<MovieDTO>>(){}.getType();

        String word = "";
        if (prefix.isPresent()){
            word = prefix.get().toLowerCase();
        }
        String keyWord = word;

        List<Movie> movie = movieRepository.findAll();
        List<Movie> filtered = movie.stream()
                .filter(e -> prefix.isEmpty()
                        || e.getTitleHun().toLowerCase().contains(keyWord)
                        || e.getTitleEnglish().toLowerCase().contains(keyWord)
                        || e.getTitleOriginal().toLowerCase().contains(keyWord))
                .collect(Collectors.toList());

        return modelMapper.map(filtered, targetListType);
    }

}
