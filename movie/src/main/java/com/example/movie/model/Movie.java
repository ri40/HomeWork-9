package com.example.movie.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Range;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.*;
import java.time.LocalDate;
import java.util.Date;

@AllArgsConstructor @NoArgsConstructor @Data
@Entity
public class Movie {
    @Id
    @NotNull
    @Size(min = 4)
    @Column(name = "Movie-Id",unique = true,nullable = false)
    private Integer id;
    @NotEmpty
    @Size(min = 3)
    @Column(name = "Movie-Name",unique = true,nullable = false)
    private String name;
    @NotEmpty
    @Pattern(regexp = "Drama|Action|Comedy")
    private String genre;
    @NotNull
    @Positive
    @Range(min = 1,max = 5)
    private Integer rating;
    @NotNull
    @Positive
    private Integer duration;
    @NotNull
    //@Pattern(regexp = "(yyyy-MM-dd)")
    private LocalDate launchDate;
}
