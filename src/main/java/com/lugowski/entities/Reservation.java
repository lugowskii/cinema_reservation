package com.lugowski.entities;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;

@Entity(name = "reservation")
public class Reservation {
    @EmbeddedId
    private SeatScreeningKey key;
    private Long customer_id;

    public Reservation() {
    }

    public Reservation(SeatScreeningKey key, Long customer_id) {
        this.key = key;
        this.customer_id = customer_id;
    }

    public Long getScreeningId() {
        return key.getScreeningId();
    }

    public void setScreeningId(Long screeningId) {
        this.key.setScreeningId(screeningId);
    }

    public Long getSeatId() {
        return key.getSeatId();
    }

    public void setSeatId(Long seatId) {
        this.key.setSeatId(seatId);
    }

    public Long getCustomer_id() {
        return customer_id;
    }

    public void setCustomer_id(Long customer_id) {
        this.customer_id = customer_id;
    }

    public SeatScreeningKey getKey() {
        return key;
    }

    public void setKey(SeatScreeningKey key) {
        this.key = key;
    }
}
