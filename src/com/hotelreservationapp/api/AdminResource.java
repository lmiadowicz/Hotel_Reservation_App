package com.hotelreservationapp.api;

import com.hotelreservationapp.model.*;
import com.hotelreservationapp.service.CustomerService;
import com.hotelreservationapp.service.ReservationService;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Set;

public class AdminResource {
    private static AdminResource INSTANCE;
    private static final ReservationService reservationService = ReservationService.getInstance();
    private static final CustomerService customerService = CustomerService.getInstance();

    private AdminResource() {}

    public static AdminResource getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new AdminResource();
        }
        return INSTANCE;
    }

    public Customer getCustomer(String email) {
        return customerService.getCustomer(email);
    }

    public void addRoom(List<IRoom> rooms) {
        for (IRoom room: rooms) {
            reservationService.addRoom(room);
        }
    }

    public Collection<IRoom> getAllRooms() {

        return reservationService.getRooms();
    }

    public Collection<Customer> getAllCustomers() {
        return customerService.getAllCustomers();
    }

    public Set<Reservation> getAllReservations() {
        return reservationService.getReservations();
    }

    public void addTestData() {
        List<IRoom> rooms = new ArrayList<>();
        rooms.add(new Room("1", 100.0, RoomType.SINGLE));
        rooms.add(new Room("2", 200.0, RoomType.DOUBLE));

        addRoom(rooms);

        customerService.addCustomer("test@udacity.com", "John", "English");

//        LocalDate checkInDate = LocalDate.parse("06/01/2022", DateTimeFormatter.ofPattern("MM/dd/yyyy"));
//        LocalDate checkOutDate = LocalDate.parse("06/05/2022", DateTimeFormatter.ofPattern("MM/dd/yyyy"));
//
//        reservationService.reserveARoom(customerService.getCustomer("test@udacity.com"),
//                reservationService.getARoom("1"), checkInDate, checkOutDate);
//
//        checkInDate = LocalDate.parse("06/01/2022", DateTimeFormatter.ofPattern("MM/dd/yyyy"));
//        checkOutDate = LocalDate.parse("06/05/2022", DateTimeFormatter.ofPattern("MM/dd/yyyy"));
//
//        reservationService.reserveARoom(customerService.getCustomer("test@udacity.com"),
//                reservationService.getARoom("2"), checkInDate, checkOutDate);


    }
}
