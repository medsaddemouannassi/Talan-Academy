package main;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class MaximumWithoutExceptions {
    public static void main(String args[]) throws IOException {
        BufferedReader br = null;
        try {
            br = new BufferedReader(new FileReader("data.txt"));
            // could generate FileNotFoundException (checked)
        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
        }
        int max = -1;
        String line = null;
        int n = 0;
        try {
            line = br.readLine();
            // peut générer IOException
        } catch (IOException e) {
            System.out.println(e.getMessage());
        } catch (NullPointerException e) {
            System.out.println(e.getMessage());
        }
        while (line != null) {
            try {
                n = Integer.parseInt(line);
                // peut générer NumberFormatException
            } catch (NumberFormatException e) {
                System.out.println(e.getMessage());
            }
            if (n > max) max = n;
            try {
                line = br.readLine();
                // peut générer IOException
            } catch (IOException e) {
                System.out.println(e.getMessage());
            } catch (NullPointerException e) {
                System.out.println(e.getMessage());
            }
        }
        System.out.println("Maximum = " + max);
    }
}
