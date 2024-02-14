package com.movie.restfull.util;

import com.movie.restfull.dto.MovieDto;
import com.movie.restfull.model.Movie;

import java.lang.reflect.Field;

public class Util {

    public static Movie convertToMovie(MovieDto movieDto){
        Movie movie = new Movie();
        movie.setId(movieDto.getId());
        movie.setTitle(movieDto.getTitle());
        movie.setDescription(movieDto.getDescription());
        movie.setRating(movieDto.getRating());
        movie.setImage(movieDto.getImage());
        movie.setCreatedAt(movieDto.getCreatedAt());
        movie.setUpdatedAt(movieDto.getUpdatedAt());
        return movie;
    }

    public static MovieDto converToMovieDto(Movie movie){
        MovieDto movieDto = new MovieDto();
        movieDto.setId(movie.getId());
        movieDto.setTitle(movie.getTitle());
        movieDto.setDescription(movie.getDescription());
        movieDto.setRating(movie.getRating());
        movieDto.setImage(movie.getImage());
        movieDto.setCreatedAt(movie.getCreatedAt());
        movieDto.setUpdatedAt(movie.getUpdatedAt());
        return  movieDto;
    }

    public static void copyNonNullValue(MovieDto source,Movie destination){
        Field[] fields = source.getClass().getDeclaredFields();
        for(Field field:fields){
            try{
                field.setAccessible(true);
                Object value = field.get(source);
                if(value != null){
                    Field newField = destination.getClass().getDeclaredField(field.getName());
                    newField.setAccessible(true);
                    newField.set(destination,value);
                }
            }catch (Exception e){
                e.printStackTrace();
            }
        }
    }
}
