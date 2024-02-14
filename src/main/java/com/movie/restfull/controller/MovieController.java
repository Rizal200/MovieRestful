package com.movie.restfull.controller;

import com.movie.restfull.Service.MovieService;
import com.movie.restfull.dto.MovieDto;
import com.movie.restfull.repo.MovieRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/Movies")
public class MovieController {
    @Autowired
    MovieService movieService;
    @Autowired
    private MovieRepo movieRepo;

    @GetMapping
    ResponseEntity<List<MovieDto>> getAllMovie(){
        List<MovieDto> listMovie = movieService.selectAllMovie();
        return new ResponseEntity<>(listMovie, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    ResponseEntity<MovieDto> getMovieById(@PathVariable Integer id){
        MovieDto movieDto = movieService.findMovieById(id);
        return new ResponseEntity<>(movieDto,HttpStatus.OK);
    }

    @PostMapping()
    ResponseEntity<MovieDto> createMovie(@RequestBody MovieDto movieDto){
        MovieDto addMovieDto = movieService.addMovie(movieDto);
        return new ResponseEntity<>(addMovieDto,HttpStatus.CREATED);
    }

    @PatchMapping("/{id}")
    ResponseEntity<MovieDto> updateMovie(@PathVariable Integer id,
                                         @RequestBody MovieDto movieDto){
        MovieDto updateMovie = movieService.updateMovie(id,movieDto);
        return new ResponseEntity<>(updateMovie,HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    ResponseEntity<String> deleteMovieById (@PathVariable Integer id){
        movieService.deleteMovie(id);
        return new ResponseEntity<>("Data index " + id +" Berhasil di hapus",HttpStatus.OK);
    }

}
