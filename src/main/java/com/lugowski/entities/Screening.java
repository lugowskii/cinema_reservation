package com.lugowski.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Screening {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private LocalDateTime dateTime;
    private Long movieId;

    public String getDateTimeInString() {
        StringBuilder sb = new StringBuilder();
        sb.append(dateTime.getDayOfMonth()).append("-");
        sb.append(dateTime.getMonthValue()).append("-");
        sb.append(dateTime.getYear()).append(" ");
        sb.append(dateTime.getHour()).append(":");
        if (dateTime.getMinute() < 10) sb.append("0");
        sb.append(dateTime.getMinute());
        return sb.toString();
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
