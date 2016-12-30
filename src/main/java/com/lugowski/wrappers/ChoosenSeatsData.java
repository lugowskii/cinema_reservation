package com.lugowski.wrappers;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;

@Data
@NoArgsConstructor
public class ChoosenSeatsData {
    private ArrayList<Long> seatsReserved;
}
