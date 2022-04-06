package com.hotelreservationapp.ui;

import java.util.Scanner;

public class MainMenu {
    private AdminMenu adminMenu;

    public MainMenu() {
        this.adminMenu = new AdminMenu();
    }

    public void printMainMenu() {
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
        Scanner scanner = new Scanner(System.in);
        int selectedMainMenuItem;

        do {
            printMainMenu();
            selectedMainMenuItem = scanner.nextInt();

            switch (selectedMainMenuItem) {
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
                    adminMenu.readAdminMenuInput();
                    break;
            }
        } while (selectedMainMenuItem != 5);
    }
}
