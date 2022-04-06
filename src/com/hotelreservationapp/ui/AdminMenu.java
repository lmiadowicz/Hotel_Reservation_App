package com.hotelreservationapp.ui;

import java.util.Scanner;

public class AdminMenu {
    public AdminMenu() {}

    public void printAdminMenu() {
        System.out.println("__________________________________________________");
        System.out.println("1. See all Customers");
        System.out.println("2. See all Rooms");
        System.out.println("3. See all Reservations");
        System.out.println("4. Add a Room");
        System.out.println("5. Back to Main Menu");
        System.out.println("__________________________________________________");
        System.out.println("Please select a number for the menu option");
    }

    public void readAdminMenuInput() {
        Scanner scanner = new Scanner(System.in);
        int selectedAdminMenuItem;
        do {
            printAdminMenu();
            selectedAdminMenuItem = scanner.nextInt();

            switch (selectedAdminMenuItem) {
                case 1:
                    System.out.println("1");
                    break;
                case 2:
                    System.out.println("2");
                    break;
                case 3:
                    System.out.println("3");
                    break;
                case 4:
                    System.out.println("4");
                    break;
            }
        } while (selectedAdminMenuItem != 5);
    }
}
