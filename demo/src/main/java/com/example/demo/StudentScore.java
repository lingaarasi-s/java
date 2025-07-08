package com.example.demo;
import java.util.Scanner;

public class StudentScore {
    public static void main(String[] args){
        Scanner scanner=new Scanner(System.in);
        System.out.println("enter the score:");
        Double score=scanner.nextDouble();

        if(score>=90){
            System.out.println("grade for "+score+" is O");
            System.out.println("feedback:Outstanding!!!");
        }else if(score>=80){
            System.out.println("grade for "+score+" is A+");
            System.out.println("feedback:Excellent!!");
        }else if(score>=70){
            System.out.println("grade for "+score+" is A");
            System.out.println("feedback:Very Good!");
        }else if(score>=60){
            System.out.println("grade for "+score+" is B+");
            System.out.println("feedback:Good");
        }else if(score>=50){
            System.out.println("grade for "+score+" is B");
            System.out.println("feedback:Average");
        }else if(score>=45){
            System.out.println("grade for "+score+" is C");
            System.out.println("feedback:Poor");
        }else if(score>=0 && score<45){
            System.out.println("grade for "+score+" is RA(fail)");
            System.out.println("feedback:Very Poor(Re-Appear)");
        }else{
            System.out.println("your score is must be in 100 or below 100 and non negative");
        }
    }
}
