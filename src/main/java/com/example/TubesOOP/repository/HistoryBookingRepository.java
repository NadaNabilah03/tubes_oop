<<<<<<< HEAD
package com.example.TubesOOP.repository;

import com.example.TubesOOP.entity.HistoryBooking;
import com.example.TubesOOP.entity.Customer;
import com.example.TubesOOP.entity.Collector;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface HistoryBookingRepository extends JpaRepository<HistoryBooking, Long> {

    List<HistoryBooking> findByCustomer(Customer customer);

    List<HistoryBooking> findByCollector(Collector collector);

    List<HistoryBooking> findByCustomerAndStatus(Customer customer, String status);

    List<HistoryBooking> findByCollectorAndStatus(Collector collector, String status);
}
=======
package com.example.TubesOOP.repository;

import com.example.TubesOOP.entity.HistoryBooking;
import com.example.TubesOOP.entity.Customer;
import com.example.TubesOOP.entity.Collector;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface HistoryBookingRepository extends JpaRepository<HistoryBooking, Long> {

    List<HistoryBooking> findByCustomer(Customer customer);

    List<HistoryBooking> findByCollector(Collector collector);

    List<HistoryBooking> findByCustomerAndStatus(Customer customer, String status);

    List<HistoryBooking> findByCollectorAndStatus(Collector collector, String status);
}
>>>>>>> 91f24e28f179339d6805b090435767b894ba3a26
