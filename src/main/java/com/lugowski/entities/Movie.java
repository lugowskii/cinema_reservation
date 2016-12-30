package com.lugowski.entities;


import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.time.LocalDate;

@Data
@Entity
public class Movie {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String country;
    private int year;
    private String category;
    private LocalDate releaseDate;
    private String directing;
    private String actors;
    private String language;
    private String pictureName;

    public Movie(String name, String country, int year, String category, LocalDate releaseDate, String directing, String actors, String language, String pictureName) {
        this.name = name;
        this.country = country;
        this.year = year;
        this.category = category;
        this.releaseDate = releaseDate;
        this.directing = directing;
        this.actors = actors;
        this.language = language;
        this.pictureName = pictureName;
    }

    @Override
    public String toString() {
        return String.format(
                "Nazwa: %s<br/>" +
                        "Kraj: %s<br/>" +
                        "Rok: %d<br/>" +
                        "Kategoria: %s<br/>" +
                        "Data wydania: %s<br/>" +
                        "Reżyseria: %s<br/>" +
                        "Aktorzy: %s<br/>" +
                        "Język: %s<br/>" + "<br/>",
                name, country, year, category,
                releaseDate, directing, actors, language);
    }
}
