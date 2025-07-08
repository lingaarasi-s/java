package com.example.demo;
import java.util.Scanner;

public  class NumberPattern {

    public  void Triangle(int n){
        for(int i=1;i<=n;i++){
            for(int j=1;j<=i;j++){
                System.out.print(i);
            }
            System.out.println( );
        }
    }

    public void Pyramid(int n) {
        for (int i = 1; i <= n; i++) {
            for (int j = i; j < n; j++) {
                System.out.print(" ");
            }
            for (int j = 1; j <= i; j++) {
                System.out.print(j);
            }
            for (int j = i - 1; j >= 1; j--) {
                System.out.print(j);
            }
            System.out.println();
        }
    }

    public void RightAlignedTriangle(int n) {
        for (int i = 1; i <= n; i++) {
            for (int j = i; j < n; j++) {
                System.out.print(" ");
            }
            for (int j = 1; j <= i; j++) {
                System.out.print(j);
            }
            System.out.println();
        }
    }

    public void InvertedTriangle(int n){
        for (int i = n; i >= 1; i--) {
            for (int j = 1; j <= i; j++) {
                System.out.print(j);
            }
            System.out.println();
        }
    }

    public static void main(String[] args){
        System.out.println("1. Triangle\n2. Pyramid\n3. RightAlignedTriangle\n4. InvertedTriangle\n5. exit");
        Scanner scanner=new Scanner(System.in);
        NumberPattern tp=new NumberPattern();

        while(true){

            System.out.println("enter the choice you want:");
            int pattern=scanner.nextInt();
            System.out.println("enter n:");
            int n=scanner.nextInt();

            switch(pattern){
                case 1:
                    tp.Triangle(n);
                    break;
                case 2:
                    tp.Pyramid(n);
                    break;
                case 3:
                    tp.RightAlignedTriangle(n);
                    break;
                case 4:
                    tp.InvertedTriangle(n);
                    break;
                case 5:
                    System.out.println("exiting..");
                    scanner.close();
                default:
                    System.out.println("pattern not found...");
                    break;
            }
        }
    }
}
