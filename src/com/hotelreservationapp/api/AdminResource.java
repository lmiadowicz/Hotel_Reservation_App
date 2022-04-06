package com.hotelreservationapp.api;

import com.hotelreservationapp.model.Customer;
import com.hotelreservationapp.model.IRoom;

import java.util.Collection;
import java.util.List;

public class AdminResource {
    private static AdminResource INSTANCE;

    private AdminResource() {}

    public static AdminResource getInstance() {
        if (INSTANCE == null) {
            AdminResource INSTANCE = new AdminResource();
        }
        return INSTANCE;
    }

    public Customer getCustomer(String email) {
        return null;
    }

    public void addRoom(List<IRoom> rooms) {

    }

    public Collection<IRoom> getAllRooms() {
        return null;
    }

    public Collection<Customer> getAllCustomers() {
        return null;
    }

    public void displayAllReservations() {

    }
}
