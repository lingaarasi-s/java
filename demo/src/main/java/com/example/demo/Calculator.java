package com.example.demo;
import java.util.Scanner;

enum Level1{
    add,
    subtract,
    multiply,
    divide
}

public class Calculator {
    public static void main(String[] args){
        Scanner scanner=new Scanner(System.in);
        System.out.println("enter first operand:");
        String first= scanner.nextLine();

        Double num1;
        Double num2;

        try {
            num1 = (double) Integer.parseInt(first);
        } catch (NumberFormatException e1) {
            try {
                num1 = Double.parseDouble(first);
            } catch (NumberFormatException e2) {
                System.out.println("invalid input: " + first);
                return;
            }
        }

        System.out.println("enter second operand:");
        String second= scanner.nextLine();

        try {
            num2 = (double) Integer.parseInt(second);
        } catch (NumberFormatException e1) {
            try {
                num2 = Double.parseDouble(second);
            } catch (NumberFormatException e2) {
                System.out.println("invalid input: " + second);
                return;
            }
        }

        System.out.println("enter  operator(+,-,*,/):");
        String op= scanner.nextLine();

        Level1 operator;
        switch(op) {
            case "+":
                operator = Level1.add;
                Double addVal=num1+num2;
                System.out.println("addition is "+addVal);
                break;

            case "-":
                operator = Level1.subtract;
                Double subVal=num1-num2;
                System.out.println("subtraction is "+subVal);
                break;

            case "*":
                operator = Level1.multiply;
                Double mulVal=num1*num2;
                System.out.println("multiplication is "+mulVal);
                break;

            case "/":
                operator = Level1.divide;
                Double divVal=num1/num2;
                System.out.println("division is "+divVal);
                break;

            default:
                System.out.println("operator invalid");
        }
    }
}
