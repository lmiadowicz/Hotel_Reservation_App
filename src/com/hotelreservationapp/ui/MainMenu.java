package com.hotelreservationapp.ui;

import com.hotelreservationapp.api.HotelResource;
import com.hotelreservationapp.helpers.ValidatedRecurringReader;
import com.hotelreservationapp.model.IRoom;
import com.hotelreservationapp.model.Reservation;

import java.time.LocalDate;
import java.util.Collection;
import java.util.InputMismatchException;
import java.util.Scanner;

public class MainMenu {
    private final AdminMenu adminMenu;
    private final HotelResource hotelResource = HotelResource.getInstance();

    public MainMenu() {
        this.adminMenu = new AdminMenu();
    }

    public void printMainMenu() {
        System.out.println(" ");
        System.out.println("Welcome to the Hotel Reservation Application");
        System.out.println(" ");
        System.out.println("__________________________________________________");
        System.out.println("1. Find and reserve a room");
        System.out.println("2. See my reservations");
        System.out.println("3. Create an account");
        System.out.println("4. Admin");
        System.out.println("5. Exit");
        System.out.println("__________________________________________________");
        System.out.println("Please select a number for the menu option");
    }

    public void readMainMenuInput() {
        int selectedMainMenuItem = 0;
        do {
            printMainMenu();
            try {
                Scanner scanner = new Scanner(System.in);
                selectedMainMenuItem = scanner.nextInt();
            } catch (InputMismatchException e) {
                System.out.println("Error: Invalid Input:" + e.getMessage());
            }
            switch (selectedMainMenuItem) {
                case 1 -> findAndReserveRoom();
                case 2 -> showCustomersReservations();
                case 3 -> addCustomer();
                case 4 -> adminMenu.readAdminMenuInput();
            }
        } while (selectedMainMenuItem != 5);
    }

    private void findAndReserveRoom() {
        System.out.println("Enter CheckIn Date mm/dd/yyyy example 02/01/2020");
        LocalDate checkInDate = ValidatedRecurringReader.readCheckInAndCheckOutDate(true);

        System.out.println("Enter CheckOut Date mm/dd/yyyy example 02/21/2020");
        LocalDate checkOutDate = ValidatedRecurringReader.readCheckInAndCheckOutDate(false);

        Collection<IRoom> availableRooms = hotelResource.findARoom(checkInDate, checkOutDate);

        boolean isAlternativeRoom = false;

        if (availableRooms.isEmpty()) {
            availableRooms = hotelResource.findARoom(checkInDate.plusDays(7), checkOutDate.plusDays(7));

            if (availableRooms.isEmpty()) {
                System.out.println("No available rooms were found.");
                return;
            } else {
                System.out.println("We found alternative rooms between dates "
                                    + checkInDate.plusDays(7) + " and " + checkOutDate.plusDays(7));
                isAlternativeRoom = true;
            }
        }

        printRooms(availableRooms);
        System.out.println("What room you want to reserve");
        String roomNumber = ValidatedRecurringReader.readString();
        if (hotelResource.getRoom(roomNumber) == null) {
            System.out.println("Error: Room entered doesn't exist");
            return;
        }
        if (!availableRooms.contains(hotelResource.getRoom(roomNumber))) {
            System.out.println("Error: This room is not on the list");
            return;
        }


        System.out.println("Do you have an account with us? y/n");
        if (!ValidatedRecurringReader.readBipolarAnswer()) {
            System.out.println("Please create account first!");
            return;
        }

        System.out.println("Enter Email format: name@domain.com");
        String customerEmail = ValidatedRecurringReader.readString();
        if (hotelResource.getCustomer(customerEmail) == null) {
            System.out.println("Error: Customer doesn't exist");
            return;
        }

        if (isAlternativeRoom) {
            hotelResource.bookARoom(customerEmail, hotelResource.getRoom(roomNumber), checkInDate.plusDays(7),
                    checkOutDate.plusDays(7));
        }
        else {
            hotelResource.bookARoom(customerEmail, hotelResource.getRoom(roomNumber), checkInDate, checkOutDate);
        }
    }

    private void showCustomersReservations() {
        System.out.println("Enter Customers Email format: name@domain.com");
        String customerEmail = ValidatedRecurringReader.readString();
        if (hotelResource.getCustomer(customerEmail) == null) {
            System.out.println("Error: Customer doesn't exist");
            return;
        }

        Collection<Reservation> reservations = hotelResource.getCustomersReservations(customerEmail);
        if (!reservations.isEmpty()) {
            for (Reservation reservation : reservations) {
                System.out.println(reservation);
            }
        } else {
            System.out.println("There are no reservations for this email.");
        }
    }

    private void addCustomer() {
        System.out.println("Enter Email format: name@domain.com");
        String email = ValidatedRecurringReader.readString();
        System.out.println("First Name");
        String firstName = ValidatedRecurringReader.readString();
        System.out.println("Last Name");
        String lastName = ValidatedRecurringReader.readString();
        try {
            hotelResource.createACustomer(email, firstName, lastName);
        } catch(IllegalArgumentException e) {
            System.out.println("Error: Incorrect email format");
        }
    }

    private void printRooms(Collection<IRoom> rooms) {
        for (IRoom room : rooms) {
            System.out.println(room);
        }
    }
}
