package fichier;

import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;

//Compléter les imports
public class SautoLit {
    //Scanner scanner = new Scanner(System.in);
    static int i = 1;
    static void lecture(Scanner source) {
        while (source.hasNextLine()) {
            try {
                String s = source.nextLine();
                FileWriter myWriter = new FileWriter("monFichier_L"+i+".txt");
                myWriter.write(s);
                myWriter.close();
                StringBuilder a = new StringBuilder(s);
                System.out.println("LU:\\" + s);
                System.out.println(a.reverse());
                i++;
            } catch (IOException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    static public void main(String[] args) {
        // A compléter
        try {
            Path path = Paths.get("C:\\Users\\msouannassi\\Desktop\\Talan-Academy-main\\Talan-Academy-main\\Act-2.2\\Act-2.2.5\\Lecture écriture fichier\\src\\fichier\\SeLit.java");
            Scanner source = new Scanner(path);
            lecture(source);
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}
