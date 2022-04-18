package texte;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        lecture();
    }

    static String lecture() {
        String s = null;
        String newText = "";
        try {
            Path path = Paths.get("C:\\Users\\MED SADDEM\\Desktop\\Talan-Academy-main\\Talan-Academy-main\\Act-2.2\\Act-2.2.6\\texte1.txt");
            Scanner source = new Scanner(path);
            while (source.hasNextLine()) {
                String[] wordsCount = new String[0];
                try {
                    s = source.nextLine();
                    if (!s.equalsIgnoreCase("")) {
                        String replaceAll = s.replaceAll("\\s+", "");
                        wordsCount = s.split(" ");
                    }
                } catch (Exception e) {
                    System.out.println(e.getMessage());
                }
                for (int i = 0; i < wordsCount.length; i += 2) {
                    newText += wordsCount[i] + " ";
                }
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        return s;
    }
}
