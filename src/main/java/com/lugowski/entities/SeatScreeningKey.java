package com.lugowski.entities;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;

/**
 * Created by Piotr Ługowski on 26.10.2016.
 */
@Embeddable
public class SeatScreeningKey implements Serializable{
    @Column(name="screening_id")
    private Long screeningId;
    @Column(name="seat_id")
    private Long seatId;

    public SeatScreeningKey(Long screeningId, Long seatId) {
        this.screeningId = screeningId;
        this.seatId = seatId;
    }

    public SeatScreeningKey() {
    }

    public Long getScreeningId() {
        return screeningId;
    }

    public void setScreeningId(Long screeningId) {
        this.screeningId = screeningId;
    }

    public Long getSeatId() {
        return seatId;
    }

    public void setSeatId(Long seatId) {
        this.seatId = seatId;
    }
}