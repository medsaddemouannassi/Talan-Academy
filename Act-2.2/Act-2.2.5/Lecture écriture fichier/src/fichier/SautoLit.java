package fichier;

import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;

//Compléter les imports
public class SautoLit {
    static int i = 1;

    static void lecture(Scanner source) {
        while (source.hasNextLine()) {
            try {
                String s = source.nextLine();
                System.out.println("LU:\\" + s);
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
    }

    static void lectureReverse(Scanner sourceReverse) {
        while (sourceReverse.hasNextLine()) {
            try {
                String s = sourceReverse.nextLine();
                StringBuilder a = new StringBuilder(s);
                System.out.println(a.reverse());
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
    }

    static void fileCreate(Scanner sourceFile) {
        while (sourceFile.hasNextLine()) {
            try {
                String s = sourceFile.nextLine();
                FileWriter myWriter = new FileWriter("monFichier_L" + i + ".txt");
                myWriter.write(s);
                myWriter.close();
                lecture(new Scanner(Paths.get("C:\\Users\\msouannassi\\Desktop\\Talan-Academy-main\\Talan-Academy-main\\Act-2.2\\Act-2.2.5\\Lecture écriture fichier\\monFichier_L" + i + ".txt")));
                String tmpStr = sourceFile.nextLine();
                int charsCount = 0;
                if (!tmpStr.equalsIgnoreCase("")) {
                    String replaceAll = tmpStr.replaceAll("\\p{Punct}", "").replaceAll(" ", "");
                    charsCount += replaceAll.length();
                }
                System.out.println("CHARS: " + charsCount);
                i++;
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
    }


    static public void main(String[] args) {
        // A compléter
        try {
            //Path path = Paths.get("C:\\Users\\msouannassi\\Desktop\\Talan-Academy-main\\Talan-Academy-main\\Act-2.2\\Act-2.2.5\\Lecture écriture fichier\\src\\fichier\\SeLit.java");
            Path path = Paths.get("C:\\Users\\msouannassi\\Desktop\\Talan-Academy-main\\Talan-Academy-main\\Act-2.2\\Act-2.2.5\\Lecture écriture fichier\\src\\fichier\\SeLit.java");
            Scanner source = new Scanner(path);
            Scanner sourceReverse = new Scanner(path);
            Scanner sourceFile = new Scanner(path);
            lecture(source);
            lectureReverse(sourceReverse);
            fileCreate(sourceFile);
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}
