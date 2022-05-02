package com.hotelreservationapp.helpers;

import com.hotelreservationapp.model.RoomType;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.time.format.ResolverStyle;
import java.util.InputMismatchException;
import java.util.Objects;
import java.util.Scanner;

public class ValidatedRecurringReader {
    private static final DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("MM/dd/uuuu")
            .withResolverStyle(ResolverStyle.STRICT);

    public static int readInt() {
        boolean isValid = false;
        int input = 0;
        do {
            try {
                Scanner scanner = new Scanner(System.in);
                input = scanner.nextInt();
                isValid = true;
            } catch (InputMismatchException e) {
                System.out.println("Error: Invalid Input:" + e.getMessage());
            }

        } while (!isValid);
        return input;
    }

    public static double readDouble() {
        boolean isValid = false;
        double input = 0.0d;
        do {
            try {
                Scanner scanner = new Scanner(System.in);
                input = Double.parseDouble(scanner.next());
                isValid = true;
            } catch (InputMismatchException e) {
                System.out.println("Error: Invalid Input:" + e.getMessage());
            }
        } while (!isValid);
        return input;
    }

    public static String readString() {
        boolean isValid = false;
        String input = "";
        do {
            try {
                Scanner scanner = new Scanner(System.in);
                input = scanner.next();
                isValid = true;
            } catch (InputMismatchException e) {
                System.out.println("Error: Invalid Input:" + e.getMessage());

            }
        } while (!isValid);
        return input;
    }

    public static RoomType readRoomType() {
        boolean isValid = false;
        int input = 0;
        do {
            try {
                Scanner scanner = new Scanner(System.in);
                input = scanner.nextInt();
                if (input == 1 || input == 2) {
                    isValid = true;
                } else {
                    System.out.println("Error: Choose either 1 for single bed or 2 for double bed");
                }
            } catch (InputMismatchException e) {
                System.out.println("Error: Invalid Input:" + e.getMessage());
            }
        } while (!isValid);

        switch (input) {
            case 1:
                return RoomType.SINGLE;
            case 2:
                return RoomType.DOUBLE;
        }
        return null;
    }

    public static boolean readBipolarAnswer() {
        boolean isValid = false;
        String input = "";
        do {
            try {
                Scanner scanner = new Scanner(System.in);
                input = scanner.next().toLowerCase();
                if (Objects.equals(input, "y")) {
                    return true;
                } else if (Objects.equals(input, "n")) {
                    return false;
                }
            } catch (InputMismatchException e) {
                System.out.println("Error: Invalid Input:" + e.getMessage());
            }
        } while (true);
    }

    public static LocalDate readCheckInAndCheckOutDate(boolean isCheckIn) {
        boolean isValid = false;
        LocalDate date = null;
        do {
            try {
                Scanner scanner = new Scanner(System.in);
                date = LocalDate.parse(scanner.nextLine(), dateFormatter);
                isValid = true;
            } catch (DateTimeParseException e) {
                System.out.println("Error: Invalid Input:" + e.getMessage());
                System.out.println("Enter " + (isCheckIn ? "CheckInDate" : "CheckOutDate")
                        + " Date mm/dd/yyyy example 02/21/2020");
            }
        } while (!isValid);
        return date;
    }
}

