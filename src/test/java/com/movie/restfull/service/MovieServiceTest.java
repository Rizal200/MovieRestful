package com.movie.restfull.service;

import com.movie.restfull.Service.impl.MovieServiceImpl;
import com.movie.restfull.dto.MovieDto;
import com.movie.restfull.model.Movie;
import com.movie.restfull.repo.MovieRepo;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

public class MovieServiceTest {


    @Mock
    private MovieRepo movieRepo;

    @InjectMocks
    private MovieServiceImpl movieService;

    @BeforeEach
    void setUp(){
        MockitoAnnotations.initMocks(this);
    }

    @Test
    void testSelectAllMovie(){
        LocalDateTime nowDate = LocalDateTime.now();
        List<Movie> movies = new ArrayList<>();
        movies.add(new Movie(1,"test1","desc1",2.0F,"img1",nowDate,nowDate));
        movies.add(new Movie(2,"test2","desc2",3.0F,"img2",nowDate,nowDate));

        when(movieRepo.findAll()).thenReturn(movies);

        List<MovieDto> movieDtos = movieService.selectAllMovie();

        assertEquals(2,movies.size());
        assertEquals("img1",movieDtos.get(0).getImage());
    }

    @Test
    void testFindById(){
        LocalDateTime nowDate = LocalDateTime.now();
        Movie movie = new Movie(2,"test2","desc2",3.0F,"img2",nowDate,nowDate);

        when(movieRepo.findById(2)).thenReturn(Optional.of(movie));

        MovieDto movieDto = movieService.findMovieById(2);

        assertEquals("test2",movieDto.getTitle());

    }

    @Test
    void testAddMovie(){
        MovieDto movieDto = new MovieDto();
        movieDto.setId(1);
        movieDto.setTitle("test1");
        movieDto.setDescription("desc1");
        movieDto.setRating(1.0F);
        movieDto.setImage("img1");
        movieDto.setCreatedAt(LocalDateTime.now());
        movieDto.setUpdatedAt(LocalDateTime.now());

        Movie movie = new Movie();
        movie.setId(1);
        movie.setTitle("test1");
        movie.setDescription("desc1");
        movie.setRating(1.0F);
        movie.setImage("img1");
        movie.setCreatedAt(LocalDateTime.now());
        movie.setUpdatedAt(LocalDateTime.now());

        when(movieRepo.save(any())).thenReturn(movie);

        MovieDto savedMovieDto = movieService.addMovie(movieDto);

        assertNotNull(savedMovieDto);
        assertEquals("test1",savedMovieDto.getTitle());
    }

    @Test
    void testDeleteMovie(){
        int id = 1;
        movieService.deleteMovie(id);
        verify(movieRepo,times(1)).deleteById(id);
    }

    @Test
    void testUpdateMovie(){
        MovieDto movieDto = new MovieDto();
        movieDto.setId(1);
        movieDto.setTitle("newTest1");
        movieDto.setImage("newImg1");

        Movie movie = new Movie();
        movie.setId(1);
        movie.setTitle("test1");
        movie.setDescription("desc1");
        movie.setRating(1.0F);
        movie.setImage("img1");
        movie.setCreatedAt(LocalDateTime.now());
        movie.setUpdatedAt(LocalDateTime.now());

        when(movieRepo.findById(1)).thenReturn(Optional.of(movie));
        when(movieRepo.save(any())).thenAnswer(invocation -> invocation.getArgument(0));

        MovieDto updateMovieDto = movieService.updateMovie(1,movieDto);

        assertNotNull(updateMovieDto);
        assertEquals(1,updateMovieDto.getId());
        assertEquals("newTest1",updateMovieDto.getTitle());
        assertEquals("newImg1",updateMovieDto.getImage());

    }

}
