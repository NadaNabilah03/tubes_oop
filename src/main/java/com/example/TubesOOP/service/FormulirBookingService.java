package com.example.TubesOOP.service;

import com.example.TubesOOP.entity.Collector;
import com.example.TubesOOP.entity.Customer;
import com.example.TubesOOP.entity.FormulirBooking;
import com.example.TubesOOP.payload.BookingResponse;
import com.example.TubesOOP.enums.BookingStatus;
import com.example.TubesOOP.enums.WasteType;
import com.example.TubesOOP.repository.FormulirBookingRepository;
import com.example.TubesOOP.repository.CustomerRepository;
import com.example.TubesOOP.repository.CollectorRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class FormulirBookingService {

    @Autowired
    private FormulirBookingRepository bookingRepository;

    @Autowired
    private CustomerRepository customerRepository;

    @Autowired
    private CollectorRepository collectorRepository;

    // Tambah booking baru
    public void createBooking(WasteType jenisSampah, Double beratSampah,
                              LocalDate tanggalPickup, LocalTime jamPickup,
                              Long customerId) throws Exception {

        Optional<Customer> customer = customerRepository.findById(customerId);
        if (!customer.isPresent()) {
            throw new Exception("createBooking.Customer not found");
        }

        // Hitung harga otomatis: berat > 5 kg dikenakan 1000/kg
        double harga = 0;
        if (beratSampah > 5) {
            harga = (beratSampah - 5) * 1000;
        }

        FormulirBooking booking = new FormulirBooking();
        booking.setJenisSampah(jenisSampah);
        booking.setBeratSampah(beratSampah);
        booking.setHarga(harga);
        booking.setTanggalPickup(tanggalPickup);
        booking.setJamPickup(jamPickup);
        booking.setStatus(BookingStatus.MENUNGGU);
        booking.setCustomer(customer.get());

        bookingRepository.save(booking);
    }

    // Ambil semua booking
    public List<BookingResponse> getAllBookings() {
        List<FormulirBooking> allBookings = bookingRepository.findAll();
        return convertToResponseList(allBookings);
    }

    // Cari booking berdasarkan ID
    public FormulirBooking getBookingById(Long id) throws Exception {
        return bookingRepository.findById(id)
                .orElseThrow(() -> new Exception("getBookingById.Booking not found"));
    }

    // Update status booking dan assign ke collector
    public void assignCollector(Long bookingId, Long collectorId) throws Exception {
        FormulirBooking booking = getBookingById(bookingId);
        Collector collector = collectorRepository.findById(collectorId)
                .orElseThrow(() -> new Exception("assignCollector.Collector not found"));

        booking.setCollector(collector);
        booking.setStatus(BookingStatus.DIPROSES);

        bookingRepository.save(booking);
    }

    // Ubah status booking menjadi COMPLETED
    public void completeBooking(Long bookingId) throws Exception {
        FormulirBooking booking = getBookingById(bookingId);
        booking.setStatus(BookingStatus.SELESAI);
        bookingRepository.save(booking);
    }

    // Membatalkan booking
    public void cancelBooking(Long bookingId) throws Exception {
        FormulirBooking booking = getBookingById(bookingId);

        if (booking.getStatus() == BookingStatus.SELESAI || booking.getStatus() == BookingStatus.DIPROSES) {
            throw new Exception("cancelBooking.Booking tidak bisa dibatalkan karena sedang diproses atau sudah selesai.");
        }

        booking.setStatus(BookingStatus.DIBATALKAN);
        bookingRepository.save(booking);
    }

    // Hapus booking berdasarkan ID
    public void deleteBooking(Long id) throws Exception {
        if (!bookingRepository.existsById(id)) {
            throw new Exception("deleteBooking.Booking not found");
        }
        bookingRepository.deleteById(id);
    }

    // Daftar booking berdasarkan customer ID
    public List<BookingResponse> getBookingsByCustomerId(Long customerId) throws Exception {
        Customer customer = customerRepository.findById(customerId)
                .orElseThrow(() -> new Exception("getBookingsByCustomerId.Customer not found"));
        return convertToResponseList(bookingRepository.findByCustomer(customer));
    }

    // Daftar booking berdasarkan collector ID
    public List<BookingResponse> getBookingsByCollectorId(Long collectorId) throws Exception {
        Collector collector = collectorRepository.findById(collectorId)
                .orElseThrow(() -> new Exception("getBookingsByCollectorId.Collector not found"));
        return convertToResponseList(bookingRepository.findByCollector(collector));
    }

    // Daftar booking berdasarkan status
    public List<BookingResponse> getBookingsByStatus(BookingStatus status) {
        List<FormulirBooking> bookings = bookingRepository.findByStatus(status);
        return convertToResponseList(bookings);
    }

    // Convert satu booking jadi response
    public BookingResponse convertToResponse(FormulirBooking booking) {
        String customerUsername = (booking.getCustomer() != null) ? booking.getCustomer().getUsername() : null;
        String collectorName = (booking.getCollector() != null) ? booking.getCollector().getName() : null;

        return new BookingResponse(
                booking.getId(),
                booking.getJenisSampah(),
                booking.getBeratSampah(),
                booking.getHarga(),
                booking.getTanggalPickup(),
                booking.getJamPickup(),
                booking.getStatus(),
                customerUsername,
                collectorName
        );
    }

    // Convert list booking jadi response list
    public List<BookingResponse> convertToResponseList(List<FormulirBooking> bookings) {
        return bookings.stream()
                .map(this::convertToResponse)
                .collect(Collectors.toList());
    }
}
