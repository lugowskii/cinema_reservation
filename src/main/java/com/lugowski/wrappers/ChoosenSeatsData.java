package com.lugowski.wrappers;

import java.util.ArrayList;

/**
 * Created by Piotr Ługowski on 25.10.2016.
 */
public class ChoosenSeatsData {
    private ArrayList<Long> seatsReserved;

    public ChoosenSeatsData() {
    }

    public ChoosenSeatsData(ArrayList<Long> seatsReserved) {
        this.seatsReserved = seatsReserved;
    }

    public ArrayList<Long> getSeatsReserved() {
        return seatsReserved;
    }

    public void setSeatsReserved(ArrayList<Long> seatsReserved) {
        this.seatsReserved = seatsReserved;
    }
}
