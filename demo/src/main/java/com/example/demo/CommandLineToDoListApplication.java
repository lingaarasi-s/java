package com.example.demo;
import java.util.ArrayList;
import java.util.Scanner;

enum Command {
    add,
    view,
    delete,
    done,
    exit
}

public class CommandLineToDoListApplication {

    ArrayList<String> tasks = new ArrayList<>();

    public ArrayList<String> add(String task) {
        tasks.add(task);
        System.out.println(task + " is added...");
        return tasks;
    }

    public void view() {
        System.out.println(tasks);
        System.out.println("these are the available tasks...");
    }

    public String delete(String task) {
        tasks.remove(task);
        System.out.println(task + " is deleted...");
        return task;
    }

    public void done(String task) {
        for (int i = 0; i < tasks.size(); i++) {
            if (tasks.get(i).equals(task)) {
                tasks.set(i, task + " [✓]");
                System.out.println(task + " is done...");
            }
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        CommandLineToDoListApplication command=new CommandLineToDoListApplication();
        while (true) {
            System.out.println("Enter command (add, view, delete, done, exit): ");
            String input = scanner.nextLine();

            try{
                Command MyAction = Command.valueOf(input);
                switch (MyAction) {
                    case add:
                        System.out.println("enter task to add:");
                        String task = scanner.nextLine();
                        command.add(task);
                        break;
                    case view:
                        command.view();
                        break;
                    case delete:
                        System.out.println("enter which task to delete:");
                        String deltask = scanner.nextLine();
                        command.delete(deltask);
                        break;
                    case done:
                        System.out.println("enter which task is done:");
                        String donetask = scanner.nextLine();
                        command.done(donetask);
                        break;
                    case exit:
                        System.out.println("Exiting...");
                        scanner.close();
                        return;
                }
            } catch (IllegalArgumentException e) {
                System.out.println("invalid command..please enter anyone of these commands..(add or view or delete or done or exit)"+"\n");
            }
        }
    }
}
