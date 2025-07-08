package com.example.demo;
import java.util.Scanner;

public class TextAnalyzer {

    public void wordCount(String para){
        int count=1;
        for(int i=0;i<para.length();i++){
            if(para.charAt(i)==' '){
                count++;
            }
        }
        System.out.println("word count:"+count);
    }

    public void charCount(String para){
        int count=0;
        for(int i=0;i<para.length();i++){
            count++;
        }
        System.out.println("character count:"+count);
    }

    public void sentenceCount(String para){
        int count=0;
        for(int i=0;i<para.length();i++){
            if(para.charAt(i)=='.'){
                count++;
            }
        }
        System.out.println("sentence count:"+count);
    }

    public static void main(String[] args){
        Scanner scanner=new Scanner(System.in);
        System.out.println("Enter any text:");
        String text=scanner.nextLine();

        TextAnalyzer ob1=new TextAnalyzer();
        ob1.wordCount(text);
        ob1.charCount(text);
        ob1.sentenceCount(text);

    }
}
