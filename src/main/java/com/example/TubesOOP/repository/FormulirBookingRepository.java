package com.example.TubesOOP.repository;

import com.example.TubesOOP.entity.FormulirBooking;
import com.example.TubesOOP.entity.Collector;
import com.example.TubesOOP.entity.Customer;
import com.example.TubesOOP.enums.BookingStatus;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface FormulirBookingRepository extends JpaRepository<FormulirBooking, Long> {

    List<FormulirBooking> findByCustomer(Customer customer);

    List<FormulirBooking> findByCollector(Collector collector);

    List<FormulirBooking> findByStatus(BookingStatus status);

    List<FormulirBooking> findByCollectorAndStatus(Collector collector, BookingStatus status);

    List<FormulirBooking> findByCustomerAndStatus(Customer customer, BookingStatus status);
}
