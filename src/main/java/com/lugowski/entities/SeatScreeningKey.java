package com.lugowski.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Embeddable
public class SeatScreeningKey implements Serializable {
    @Column(name = "screening_id")
    private Long screeningId;
    @Column(name = "seat_id")
    private Long seatId;

}