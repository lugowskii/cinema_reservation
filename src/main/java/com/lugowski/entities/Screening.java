package com.lugowski.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.time.LocalDateTime;


@Entity(name = "screening")
public class Screening {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private LocalDateTime dateTime;
    private Long movieId;

    protected Screening() {
    }

    public Screening(LocalDateTime dateTime, Long movieId) {
        this.dateTime = dateTime;
        this.movieId = movieId;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDateTimeInString() {
        StringBuilder sb = new StringBuilder();
        sb.append(dateTime.getDayOfMonth());
        sb.append("-");
        sb.append(dateTime.getMonthValue());
        sb.append("-");
        sb.append(dateTime.getYear());
        sb.append(" ");
        sb.append(dateTime.getHour());
        sb.append(":");
        if (dateTime.getMinute() < 10) sb.append("0");
        sb.append(dateTime.getMinute());
        return sb.toString();
    }

    public LocalDateTime getDateTime() {
        return dateTime;
    }

    public void setDateTime(LocalDateTime dateTime) {
        this.dateTime = dateTime;
    }

    public Long getMovieId() {
        return movieId;
    }

    public void setMovieId(Long movieId) {
        this.movieId = movieId;
    }

    @Override
    public String toString() {
        return "Screening{" +
                "id=" + id +
                ", dateTime=" + dateTime +
                ", movieId=" + movieId +
                '}';
    }
}
