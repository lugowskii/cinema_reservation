package com.lugowski.entities;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;

@Embeddable
public class SeatScreeningKey implements Serializable {
    @Column(name = "screening_id")
    private Long screeningId;
    @Column(name = "seat_id")
    private Long seatId;

    public SeatScreeningKey(Long screeningId, Long seatId) {
        this.screeningId = screeningId;
        this.seatId = seatId;
    }

    public SeatScreeningKey() {
    }

    Long getScreeningId() {
        return screeningId;
    }

    void setScreeningId(Long screeningId) {
        this.screeningId = screeningId;
    }

    Long getSeatId() {
        return seatId;
    }

    void setSeatId(Long seatId) {
        this.seatId = seatId;
    }
}