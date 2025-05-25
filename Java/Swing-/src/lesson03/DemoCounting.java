package lesson03;

import java.util.Scanner;

public class DemoCounting {
    public static void main(String[] args) {
        Counting counting = new Counting();
        counting.start();
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter any character to stop: ");
        String input = sc.next();
        counting.end();
        System.out.println("Lucky number: "+ counting.getNumber());
    }
}
