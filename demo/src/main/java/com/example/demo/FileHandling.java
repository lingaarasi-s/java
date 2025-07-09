package com.example.demo;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class FileHandling {
    public static void main(String[] args) {
        File f1 = new File("C:\\Users\\LINGA ARASI\\java\\demo\\src\\main\\resources\\number.txt");
        int count = 0;
        int sum = 0;

        try (Scanner scanner = new Scanner(f1)) {
            while (scanner.hasNextLine()) {
                String data = scanner.nextLine().trim();
                if (data.isEmpty()) {
                    continue;
                }
                try {
                    int num = Integer.parseInt(data);
                    sum += num;
                    count++;
                } catch (NumberFormatException e) {
                    System.out.println("Skipping invalid number format: " + data);
                }
            }

            if (count > 0) {
                System.out.println("Sum: " + sum);
                double average = (double) sum / count;
                System.out.println("Average: " + average);
            } else {
                System.out.println("No valid numbers found in the file.");
            }

        } catch (FileNotFoundException e) {
            System.out.println("File not found: " + f1.getAbsolutePath());
        } catch (Exception e) {
            System.out.println("An unexpected error occurred: " + e.getMessage());
        }
    }
}
