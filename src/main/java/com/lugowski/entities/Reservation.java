package com.lugowski.entities;

import javax.persistence.*;
import java.util.List;

/**
 * Created by Piotr Ługowski on 25.10.2016.
 */
@Entity(name="reservation")
public class Reservation {
    @EmbeddedId
    private SeatScreeningKey key;

    public Reservation() {
    }

    public Reservation(Long screeningId, Long seatId) {
        key=new SeatScreeningKey(screeningId,seatId);
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
}
