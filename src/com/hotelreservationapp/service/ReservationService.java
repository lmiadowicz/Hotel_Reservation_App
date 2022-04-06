package com.hotelreservationapp.service;

import com.hotelreservationapp.model.Customer;
import com.hotelreservationapp.model.IRoom;
import com.hotelreservationapp.model.Reservation;

import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class ReservationService {
    private static ReservationService INSTANCE;
    private Map<String, IRoom> rooms;

    private ReservationService() {}

    public ReservationService getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new ReservationService();
            INSTANCE.rooms = new HashMap<>();
        }

        return INSTANCE;
    }

    public void addRoom(IRoom room) {

    }

    public IRoom getARoom(String roomId) {
        return null;
    }

    public Reservation reserveARoom(Customer customer, IRoom room, Date checkInDate, Date checkOutDate) {
        return null;
    }

    public Collection<Reservation> getCustomerReservation(Customer customer) {
        return null;
    }

    public void printAllReservation() {

    }
}
