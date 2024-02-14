package com.movie.restfull.Service;

import com.movie.restfull.dto.MovieDto;
import com.movie.restfull.model.Movie;
import com.movie.restfull.repo.MovieRepo;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public interface MovieService {

    List<MovieDto> selectAllMovie();

    MovieDto findMovieById(Integer id);

    MovieDto addMovie(MovieDto movieDto);

    MovieDto updateMovie(Integer id,MovieDto movieDto);

    void deleteMovie(Integer id);
}
