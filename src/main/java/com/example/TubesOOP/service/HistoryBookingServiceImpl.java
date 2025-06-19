package com.example.TubesOOP.service;

import com.example.TubesOOP.entity.HistoryBooking;
import com.example.TubesOOP.repository.HistoryBookingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HistoryBookingServiceImpl implements HistoryBookingService {

    @Autowired
    private HistoryBookingRepository historyBookingRepository;

    @Override
    public List<HistoryBooking> getAllHistory() {
        return historyBookingRepository.findAll();
    }
}
