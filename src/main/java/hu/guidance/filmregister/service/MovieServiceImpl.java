package hu.guidance.filmregister.service;

import hu.guidance.filmregister.dto.CreateMovieCommand;
import hu.guidance.filmregister.dto.MovieDTO;
import hu.guidance.filmregister.dto.UpdateMovieCommand;
import hu.guidance.filmregister.exception.MovieAllTitlesAreEmptyException;
import hu.guidance.filmregister.exception.MovieNotFoundException;
import hu.guidance.filmregister.model.Movie;
import hu.guidance.filmregister.repository.MovieRepository;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

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
        setNewMovieData(command, movie);

        movie = movieRepository.save(movie);
        return modelMapper.map(movie, MovieDTO.class);
    }

    private void setNewMovieData(CreateMovieCommand command, Movie movie) {
        checkThreeTitlesAreEmpty(command.getTitleHun(),
                command.getTitleEnglish(),
                command.getTitleOriginal());

        movie.setTitleHun(command.getTitleHun());
        movie.setTitleEnglish(command.getTitleEnglish());
        movie.setTitleOriginal(command.getTitleOriginal());
        movie.setDuration(command.getDuration());
        movie.setReleaseYear(command.getReleaseYear());
        movie.setXResolution(command.getXResolution());
        movie.setYResolution(command.getYResolution());
        movie.setGenre(command.getGenre());
        movie.setDirector(command.getDirector());
        movie.setStorageNumber(command.getStorageNumber());
        movie.setCodecFormat(command.getCodecFormat());
        movie.setStorageType(command.getStorageType());
    }

    @Override
    public MovieDTO findMovieById(Long id) {
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
    public MovieDTO updateMovie(Long id, UpdateMovieCommand command) {
        Optional<Movie> optionalMovie = movieRepository.findById(id);

        if (optionalMovie.isEmpty()) {
            throw new MovieNotFoundException(id);
        }

        Movie movie = optionalMovie.get();
        setMovieTitles(movie, command);
        setMovieOtherData(movie, command);

        return modelMapper.map(movie, MovieDTO.class);
    }

    private void setMovieOtherData(Movie movie, UpdateMovieCommand command) {
        if (command.getDuration() != null) {
            movie.setDuration(command.getDuration());
        }
        if (command.getReleaseYear() != null) {
            movie.setReleaseYear(command.getReleaseYear());
        }
        if (command.getXResolution() != null) {
            movie.setXResolution(command.getXResolution());
        }
        if (command.getYResolution() != null) {
            movie.setYResolution(command.getYResolution());
        }
        if (command.getStorageNumber() != null) {
            movie.setStorageNumber(command.getStorageNumber());
        }
        if (command.getGenre() != null) {
            movie.setGenre(command.getGenre());
        }
        if (command.getDirector()!= null) {
            movie.setDirector(command.getDirector());
        }
        if (command.getStorageType() != null) {
            movie.setStorageType(command.getStorageType());
        }
        if (command.getCodecFormat() != null) {
            movie.setCodecFormat(command.getCodecFormat());
        }
    }

    private void setMovieTitles(Movie movie, UpdateMovieCommand command) {
        String hunTitle = command.getTitleHun();
        String englishTitle = command.getTitleEnglish();
        String originalTitle = command.getTitleOriginal();
        checkThreeTitlesAreEmpty(hunTitle, englishTitle, originalTitle);

        if (!hunTitle.isEmpty() || !hunTitle.isBlank() ) {
            movie.setTitleHun(command.getTitleHun());
        }
        if (!englishTitle.isEmpty() || !englishTitle.isBlank()) {
            movie.setTitleEnglish(command.getTitleEnglish());
        }
        if (!originalTitle.isEmpty() || !originalTitle.isBlank()) {
            movie.setTitleOriginal(command.getTitleOriginal());
        }

    }

    private void checkThreeTitlesAreEmpty(String hunTitle, String englishTitle, String originalTitle) {
        boolean hungarian = hunTitle.isEmpty() || hunTitle.isBlank();
        boolean english = englishTitle.isEmpty() || englishTitle.isBlank();
        boolean original = originalTitle.isEmpty() || originalTitle.isBlank();

        if (hungarian && english && original) {
            throw new MovieAllTitlesAreEmptyException("All titles can not be empty or blank!");
        }
    }

    @Override
    public void deleteMovieById(Long id) {
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
        List<Movie> allMovies = movieRepository.findAll();

        if (prefix.isPresent()) {
            String keyWord = prefix.get();
            List<Movie> filteredMovies = filterWithKeyWordInAllTitles(keyWord, allMovies);

            return modelMapper.map(filteredMovies, targetListType);

        } else {
            return modelMapper.map(allMovies, targetListType);
        }

    }

    private List<Movie> filterWithKeyWordInAllTitles(String keyWord, List<Movie> movies) {
        List<Movie> filtered = new ArrayList<>();

        for (Movie movie : movies) {
            boolean hungarianTitleHit = movie.getTitleHun() != null &&
                    movie.getTitleHun().contains(keyWord);

            boolean englishTitleHit = movie.getTitleEnglish() != null &&
                    movie.getTitleEnglish().contains(keyWord);

            boolean originalTitleHit = movie.getTitleOriginal() != null &&
                    movie.getTitleOriginal().contains(keyWord);

            if(hungarianTitleHit || englishTitleHit || originalTitleHit) {
                filtered.add(movie);
            }
        }

        return filtered;
    }

    @Override
    @Transactional
    public MovieDTO deleteMovieTitleByType(Long id, String titleType) {
        Optional<Movie> optionalMovie = movieRepository.findById(id);
        if (optionalMovie.isEmpty()) {
            throw new MovieNotFoundException(id);
        }

        Movie movie = optionalMovie.get();
        switch (titleType) {
            case "hungarian":
                movie.setTitleHun(null);
                break;
            case "english":
                movie.setTitleEnglish(null);
                break;
            case "original":
                movie.setTitleOriginal(null);
                break;
            default:
                break;
        }

        String hunTitle = movie.getTitleHun();
        String englishTitle = movie.getTitleEnglish();
        String originalTitle = movie.getTitleOriginal();
        checkThreeTitlesAreEmpty(hunTitle, englishTitle, originalTitle);

        return modelMapper.map(movie, MovieDTO.class);
    }

}
