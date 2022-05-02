package com.hotelreservationapp.api;

import com.hotelreservationapp.model.Customer;
import com.hotelreservationapp.model.IRoom;
import com.hotelreservationapp.model.Reservation;
import com.hotelreservationapp.service.CustomerService;
import com.hotelreservationapp.service.ReservationService;

import java.time.LocalDate;
import java.util.Collection;

public class HotelResource {
    private static HotelResource INSTANCE;
    private static final CustomerService customerService = CustomerService.getInstance();
    private static final ReservationService reservationService = ReservationService.getInstance();

    private HotelResource() {}

    public static HotelResource getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new HotelResource();
        }
        return INSTANCE;
    }

    public Customer getCustomer(String email) {
        return customerService.getCustomer(email);
    }

    public void createACustomer(String email, String firstName, String lastName) {
        customerService.addCustomer(email, firstName, lastName);
    }

    public IRoom getRoom(String roomNumber) {
        return reservationService.getARoom(roomNumber);
    }

    public void bookARoom(String customerEmail, IRoom room, LocalDate checkInDate, LocalDate checkoutDate) {
        reservationService.reserveARoom(getCustomer(customerEmail), room, checkInDate, checkoutDate);
    }

    public Collection<Reservation> getCustomersReservations(String customerEmail) {
        Customer customer = customerService.getCustomer(customerEmail);
        return reservationService.getCustomerReservation(customer);
    }

    public Collection<IRoom> findARoom(LocalDate checkIn, LocalDate checkOut) {
        return reservationService.findRooms(checkIn, checkOut);
    }

}
