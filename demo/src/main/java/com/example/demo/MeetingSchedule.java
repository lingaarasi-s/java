package com.example.demo;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Scanner;

public class MeetingSchedule {
    ArrayList<Meeting> meetingList = new ArrayList<>();

    public void addMeeting(Meeting newMeeting) {
        for (Meeting existing : meetingList) {
            if (newMeeting.start.isBefore(existing.end) && existing.start.isBefore(newMeeting.end)) {
                System.out.println("Conflict detected with meeting: " + existing.title + " (" + existing.start + " to " + existing.end + ")");
                return;
            }
        }
        meetingList.add(newMeeting);
        System.out.println("Meeting scheduled successfully.");
    }

    public void viewMeeting() {
        System.out.println("Upcoming meetings:");
        for (Meeting m : meetingList) {
            System.out.println(m.title + " - " + m.start + " to " + m.end);
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        MeetingSchedule ob1 = new MeetingSchedule();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm");

        while (true) {
            System.out.println("\n1. Schedule a meeting\n2. View meetings\n3. Exit\nEnter choice:");
            int choice = Integer.parseInt(scanner.nextLine());

            switch (choice) {
                case 1:
                    System.out.println("Enter meeting title:");
                    String title = scanner.nextLine();
                    System.out.println("Enter start date and time (dd-MM-yyyy HH:mm):");
                    String startInput = scanner.nextLine();
                    System.out.println("Enter end date and time (dd-MM-yyyy HH:mm):");
                    String endInput = scanner.nextLine();

                    LocalDateTime start = LocalDateTime.parse(startInput, formatter);
                    LocalDateTime end = LocalDateTime.parse(endInput, formatter);

                    Meeting m = new Meeting(title, start, end);
                    ob1.addMeeting(m);
                    break;
                case 2:
                    ob1.viewMeeting();
                    break;
                case 3:
                    System.out.println("Exiting.");
                    System.exit(0);
            }
        }
    }
}

class Meeting {
    String title;
    LocalDateTime start;
    LocalDateTime end;

    public Meeting(String title, LocalDateTime start, LocalDateTime end) {
        this.title = title;
        this.start = start;
        this.end = end;
    }
}
