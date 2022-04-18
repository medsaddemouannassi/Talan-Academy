package main;

import java.io.File;
import java.util.Scanner;

public class Main extends Filter {
    private static Scanner scanner = new Scanner(System.in);
    private static String[] tab;
    private static String rep = "C:/Users/msouannassi/Desktop/Talan-Academy-main/Talan-Academy-main/Act-2.2/Act-2.2.4";
    private static File file = new File(rep);

    public static void main(String[] args) {
        file();
    }

    public static void file() {
        try {
            tab = new String[file.list().length];
            tab = file.list(new Filter());
            for (int i = 0; i < tab.length; i++) {
                System.out.println(tab[i]);
            }
            tab = file.list();
            for (int i = 0; i < tab.length; i++) {
                if (new File(rep + "/" + tab[i]).list() != null) {
                    rep = rep + "/" + tab[i];
                    file = new File(rep);
                    file();
                }
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
