package com.example.demo;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Calculator {
    public static void main(String[] args){
        Scanner scanner=new Scanner(System.in);
        int num1=0;
        int num2=0;

        System.out.println("enter first integer operand:");
        try{
            num1= scanner.nextInt();
        }catch(InputMismatchException e){
            System.out.println("invalid input..please enter integer numbers only.\n");
            System.exit(1);
        }

        System.out.println("enter second integer operand:");
        try{
            num2= scanner.nextInt();
            scanner.nextLine();
        }catch(InputMismatchException e){
            System.out.println("invalid input..please enter integer numbers only.\n");
            System.exit(1);
        }

        System.out.println("enter  operator(+,-,*,/):");
        String op= scanner.nextLine();

        switch(op) {
            case "+":
                int addVal=num1+num2;
                System.out.println("addition is "+addVal);
                break;

            case "-":
                int subVal=num1-num2;
                System.out.println("subtraction is "+subVal);
                break;

            case "*":
                int mulVal=num1*num2;
                System.out.println("multiplication is "+mulVal);
                break;

            case "/":
                try{
                    int divVal=num1/num2;
                    System.out.println("division is "+divVal);
                }catch(ArithmeticException e){
                    System.out.println("division by zero error.\n");
                }
                break;

            default:
                System.out.println("operator invalid");
        }
    }
}
