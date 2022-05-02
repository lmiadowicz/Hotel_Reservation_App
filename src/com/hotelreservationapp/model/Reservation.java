package com.hotelreservationapp.model;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Reservation {
    Customer customer;
    IRoom room;
    LocalDate checkInDate;
    LocalDate checkOutDate;

    public Reservation(Customer customer, IRoom room, LocalDate checkInDate, LocalDate checkOutDate) {
        this.customer = customer;
        this.room = room;
        this.checkInDate = checkInDate;
        this.checkOutDate = checkOutDate;
    }

    @Override
    public String toString() {
        return "Reservation \n" +
                customer.getName() + "\n" +
                "Room: " + room.getRoomNumber() + " - " + room.getRoomType() + " BED " + "\n" +
                "Price: " + "$" + room.getRoomPrice() + " price per night\n" +
                "Checkin Date: " + checkInDate.format(DateTimeFormatter.ofPattern("E MMM d  yyyy")) + "\n" +
                "Checkout Date: " + checkOutDate.format(DateTimeFormatter.ofPattern("E MMM d  yyyy")) +"\n";
    }

    public Customer getCustomer() {
        return customer;
    }

    public IRoom getRoom() {
        return room;
    }

    public LocalDate getCheckInDate() {
        return checkInDate;
    }

    public LocalDate getCheckOutDate() {
        return checkOutDate;
    }

}
