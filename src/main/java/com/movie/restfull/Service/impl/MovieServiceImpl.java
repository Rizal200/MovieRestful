package com.movie.restfull.Service.impl;

import com.movie.restfull.Service.MovieService;
import com.movie.restfull.dto.MovieDto;
import com.movie.restfull.exception.MovieNotFoundException;
import com.movie.restfull.model.Movie;
import com.movie.restfull.repo.MovieRepo;
import com.movie.restfull.util.Util;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class MovieServiceImpl implements MovieService {
    @Autowired
    MovieRepo movieRepo;

    @Override
    public List<MovieDto> selectAllMovie() {
        try{
            List<Movie> listMovie = new ArrayList<>();
            listMovie = movieRepo.findAll();
            return listMovie.stream()
                    .map(Util::converToMovieDto)
                    .collect(Collectors.toList());
        }catch (Exception e){
            throw new MovieNotFoundException("Data Tidak ditemukan");
        }
    }

    @Override
    public MovieDto findMovieById(Integer id) {
            Movie movie = movieRepo.findById(id)
                    .orElseThrow(()-> new MovieNotFoundException("id tidak ditemukan : " + id));
        return Util.converToMovieDto(movie);
    }

    @Override
    @Transactional
    public MovieDto addMovie(MovieDto movieDto) {
        Movie movie = Util.convertToMovie(movieDto);
        movieRepo.save(movie);
        return Util.converToMovieDto(movie);
    }

    @Override
    @Transactional
    public MovieDto updateMovie(Integer id, MovieDto movieDto) {
        Movie movie = movieRepo.findById(id).orElseThrow(
                ()-> new MovieNotFoundException("id tidak ditemukan " + id));
        Util.copyNonNullValue(movieDto,movie);
        movie = movieRepo.save(movie);
        return Util.converToMovieDto(movie);
    }

    @Override
    @Transactional
    public void deleteMovie(Integer id) {
        movieRepo.deleteById(id);
    }
}
