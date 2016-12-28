package com.lugowski.wrappers;

import java.util.ArrayList;

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
