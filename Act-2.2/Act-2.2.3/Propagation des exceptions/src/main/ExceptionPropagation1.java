package main;

import java.io.*;

public class ExceptionPropagation1 {
    public static void main(String[] args) {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Insert a number:");
        try {
            int c = Integer.parseInt(br.readLine());
            first(c);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    private static void first(int a) throws Exception {
        second(a);
    }

    private static void second(int b) throws Exception {
        Exception propagate = new Exception("The value is too small.");
        if (b < 10)
            // Error - Envoyer une Exception
            throw propagate;
        System.out.println("OK");
    }
}

