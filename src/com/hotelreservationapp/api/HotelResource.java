package com.hotelreservationapp.api;

import com.hotelreservationapp.model.Customer;
import com.hotelreservationapp.model.IRoom;
import com.hotelreservationapp.model.Reservation;

import java.util.Collection;
import java.util.Date;

public class HotelResource {
    private static HotelResource INSTANCE;

    private HotelResource() {}

    public static HotelResource getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new HotelResource();
        }
        return INSTANCE;
    }

    public Customer getCustomer(String email) {
        return null;
    }

    public void createACustomer(String email, String firstName, String lastName) {
    }

    public IRoom getRoom(String roomNumber) {
        return null;
    }

    public Reservation bookARoom(String customerEmail, IRoom room, Date checkInDate, Date checkoutDate) {
        return null;
    }

    public Collection<Reservation> getCustomersReservations(String customerEmail) {
        return null;
    }

    public Collection<IRoom> findARoom(Date checkIn, Date checkOut) {
        return null;
    }

}
