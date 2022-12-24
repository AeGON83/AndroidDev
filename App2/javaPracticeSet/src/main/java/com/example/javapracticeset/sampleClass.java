package com.example.javapracticeset;

public class sampleClass {
    public static void main(String[] args) {
    printTable(7);
        System.out.println(firstEvenSum(5));
    }
    public static void printTable(int n){
        for (int i=1 ; i<=10 ;i++){
            System.out.println(String.format("%s x %s = %s" , n , i , n*i ));
        }
    }

    public static int firstEvenSum(int n){
        int sum = 0;
        for(int i=2; i<=n*2 ; i+=2){
            sum+=i;
        }
        return sum;
    }
}