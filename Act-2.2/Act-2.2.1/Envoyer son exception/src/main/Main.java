package main;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        try{
            System.out.print("Saisir un nombre inclus entre 10 et 30 : ");
            int nombre = scanner.nextInt();
            if(nombre<10 || nombre>30) {
                throw new Exception("The value is not in the allowed interval");
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
