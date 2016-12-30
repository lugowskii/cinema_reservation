package com.lugowski.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Reservation {
    @EmbeddedId
    private SeatScreeningKey key;
    private Long customer_id;

}
