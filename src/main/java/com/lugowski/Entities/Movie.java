package com.lugowski.entities;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.time.LocalDate;


/**
 * Created by Piotr Ługowski on 21.10.2016.
 */
@Entity(name="movie")
public class Movie {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
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

    protected Movie(){}

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

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public LocalDate getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(LocalDate releaseDate) {
        this.releaseDate = releaseDate;
    }

    public String getDirecting() {
        return directing;
    }

    public void setDirecting(String directing) {
        this.directing = directing;
    }

    public String getActors() {
        return actors;
    }

    public void setActors(String actors) {
        this.actors = actors;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public String getPictureName() {
        return pictureName;
    }

    public void setPictureName(String pictureName) {
        this.pictureName = pictureName;
    }

    @Override
    public String toString(){
        return String.format(
                        "Nazwa: %s<br/>"+
                        "Kraj: %s<br/>" +
                        "Rok: %d<br/>" +
                        "Kategoria: %s<br/>" +
                        "Data wydania: %s<br/>"+
                        "Reżyseria: %s<br/>" +
                        "Aktorzy: %s<br/>" +
                        "Język: %s<br/>" + "<br/>",
                name, country, year, category,
                releaseDate, directing, actors, language);
    }
}
