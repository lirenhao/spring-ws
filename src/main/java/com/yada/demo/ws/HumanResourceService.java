package com.yada.demo.ws;

import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class HumanResourceService {
    public void bookHoliday(Date startDate, Date endDate, String name) {
        System.out.println("Booking holiday for [" + startDate + "-" + endDate + "] for [" + name + "] ");
    }
}
