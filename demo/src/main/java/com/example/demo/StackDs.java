package com.example.demo;

class CustomStack {
    private int[] stack;
    private int maxSize;
    int size = 0;

    public void CustomStack(int maxSize) {
        this.maxSize = maxSize;
        this.stack = new int[maxSize];
        this.size = size;
    }

    public void push(int x) {
        if (size < maxSize) {
            stack[size++] = x;
        } else {
            System.out.println("stack overflow..couldn't push element" + x);
        }
    }

    public int pop() {
        if (size == 0) {
            System.out.println("stack underflow..");
            return -1;
        }
        return stack[--size];
    }

    public void printStack() {
        System.out.println("stack:");
        for (int i = 0; i < size; i++) {
            System.out.print(stack[i] + " ");
        }
        System.out.println();
    }

    public void increment(int k, int val) {
        stack[k] = stack[k] + val;
    }
}

public class StackDs {
    public static void main(String[] args) {
        CustomStack stack = new CustomStack();
        stack.CustomStack(4);
        stack.push(4);
        stack.push(9);
        stack.push(7);
        stack.push(3);
        stack.push(6);
        stack.printStack();
        stack.pop();
        stack.increment(1, 10);
        stack.printStack();

    }
}
