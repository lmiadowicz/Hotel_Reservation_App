package com.hotelreservationapp.service;

import com.hotelreservationapp.model.Customer;
import com.hotelreservationapp.model.IRoom;
import com.hotelreservationapp.model.Reservation;

import java.time.LocalDate;
import java.util.*;


public class ReservationService {
    private static ReservationService INSTANCE;
    private Set<Reservation> reservations;
    private Set<IRoom> rooms;

    private ReservationService() {}

    public static ReservationService getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new ReservationService();
            INSTANCE.reservations = new HashSet<>();
            INSTANCE.rooms = new HashSet<>();
        }

        return INSTANCE;
    }

    public void addRoom(IRoom room) {
        if (rooms.contains(room)) {
            System.out.println("Error: Room " + room.getRoomNumber() + " already exists and can't be added");
            return;
        }
        rooms.add(room);
    }

    public IRoom getARoom(String roomNumber) {
        for (IRoom room: rooms) {
            if (Objects.equals(room.getRoomNumber(), roomNumber)) {
                return room;
            }
        }
        return null;
    }

    public Collection<IRoom> findRooms(LocalDate checkInDate, LocalDate checkOutDate) {
        Collection<IRoom> availableRooms = new HashSet<>(getRooms());

        for (Reservation reservation : reservations) {
            if (isOverlappingReservation(reservation, checkInDate, checkOutDate))
                availableRooms.remove(reservation.getRoom());
        }

        return availableRooms;
    }

    private boolean isOverlappingReservation(Reservation reservation, LocalDate checkInDate, LocalDate checkOutDate) {
        return checkInDate.isBefore(reservation.getCheckOutDate())
                || checkOutDate.isBefore(reservation.getCheckInDate());
    }

    public Reservation reserveARoom(Customer customer, IRoom room, LocalDate checkInDate, LocalDate checkOutDate) {

        Reservation reservation = new Reservation(customer, room, checkInDate, checkOutDate);
        reservations.add(reservation);

        return reservation;
    }

    public Collection<Reservation> getCustomerReservation(Customer customer) {
        List<Reservation> customersReservations = new ArrayList<>();
        for (Reservation reservation: reservations) {
            if (customer.equals(reservation.getCustomer())) {
                customersReservations.add(reservation);
            }
        }
        return customersReservations;
    }

    //package default method
    void printAllReservation() {
        for(Reservation reservation: reservations) {
            System.out.println(reservation);
        }
    }

    public Set<Reservation> getReservations() {
        return reservations;
    }

    public Set<IRoom> getRooms() {
        return rooms;
    }

}


