package com.lugowski.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Reservation {
    @EmbeddedId
    private SeatScreeningKey key;
    @Column(name = "customer_id")
    private Long customerId;

}
