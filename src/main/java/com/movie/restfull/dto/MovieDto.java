package com.movie.restfull.dto;

import jakarta.persistence.Column;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDateTime;

public class MovieDto {
    @NotNull
    private Integer id;
    @NotBlank
    private String title;
    @NotBlank
    private String description;
    @NotNull
    private Float rating;
    @NotBlank
    private String image;
    @NotNull
    private LocalDateTime createdAt;
    @NotNull
    private LocalDateTime updatedAt;

}
