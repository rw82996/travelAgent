package com.travelagent.api.service;

import org.springframework.stereotype.Component;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Component
public class DateWindowGenerator {
    public List<LocalDate> window(LocalDate baseDate, int flexDays) {
        List<LocalDate> dates = new ArrayList<>();
        for (int i = -flexDays; i <= flexDays; i++) {
            dates.add(baseDate.plusDays(i));
        }
        return dates;
    }
}
