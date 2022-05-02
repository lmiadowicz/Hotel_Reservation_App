package com.hotelreservationapp.ui;

import com.hotelreservationapp.api.AdminResource;
import com.hotelreservationapp.helpers.ValidatedRecurringReader;
import com.hotelreservationapp.model.*;

import java.util.*;


public class AdminMenu {
    private static final AdminResource adminResource = AdminResource.getInstance();
    private final int EXIT_MENU = 6;

    public AdminMenu() {}

    public void printAdminMenu() {
        System.out.println("__________________________________________________");
        System.out.println("1. See all Customers");
        System.out.println("2. See all Rooms");
        System.out.println("3. See all Reservations");
        System.out.println("4. Add a Room");
        System.out.println("5. Add Test Data");
        System.out.println("6. Back to Main Menu");
        System.out.println("__________________________________________________");
        System.out.println("Please select a number for the menu option");
    }

    public void readAdminMenuInput() {
        int selectedAdminMenuItem = 0;
        do {
            try {
                printAdminMenu();
                Scanner scanner = new Scanner(System.in);
                selectedAdminMenuItem = scanner.nextInt();
            } catch (InputMismatchException e) {
                System.out.println("Error: Invalid Input:" + e.getMessage());
            }
            switch (selectedAdminMenuItem) {
                case 1 -> displayAllCustomers();
                case 2 -> displayAllRooms();
                case 3 -> displayAllReservations();
                case 4 -> addRoom();
                case 5 -> addTestData();
            }
        } while (selectedAdminMenuItem != EXIT_MENU);
    }



    private void addRoom() {
        boolean keepAddingRooms;
        List<IRoom> rooms = new ArrayList<>();

        do {
            System.out.println("Enter room number:");
            String roomNumber = String.valueOf(ValidatedRecurringReader.readInt());
            System.out.println("Enter price per night:");
            Double roomPrice = ValidatedRecurringReader.readDouble();
            System.out.println("Enter room type: 1 for single bed, 2 for double bed:");
            RoomType roomType = ValidatedRecurringReader.readRoomType();

            IRoom room = new Room(roomNumber, roomPrice, roomType);
            rooms.add(room);

            System.out.println();
            System.out.println("Would like to add another room? y/n");
            keepAddingRooms = ValidatedRecurringReader.readBipolarAnswer();

            if (!keepAddingRooms) {
                adminResource.addRoom(rooms);
            }
        } while (keepAddingRooms);

    }

    private void displayAllRooms() {
        Collection<IRoom> allRooms = adminResource.getAllRooms();
        for (IRoom room : allRooms) {
            System.out.println(room);
        }
    }

    private void displayAllCustomers() {
        Collection<Customer> customers = adminResource.getAllCustomers();
        for (Customer customer: customers) {
            System.out.println(customer);
        }
    }

    private void addTestData() {
        adminResource.addTestData();
    }

    private void displayAllReservations() {
        Collection<Reservation> reservations = adminResource.getAllReservations();
        if (!reservations.isEmpty()) {
            for (Reservation reservation : reservations) {
                System.out.println(reservation);
            }
        } else {
            System.out.println("There are no reservations");
        }
    }
}

