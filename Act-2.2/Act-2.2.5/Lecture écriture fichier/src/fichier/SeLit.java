package fichier;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
public class SeLit {
    public static void main(String[] args) {
        try {
            File file = new File("C:\\Users\\msouannassi\\Desktop\\Talan-Academy-main\\Talan-Academy-main\\Act-2.2\\Act-2.2.5\\Lecture écriture fichier\\src\\fichier\\SeLit.java");
            BufferedReader br = new BufferedReader(new FileReader(file));
            String st;
            while ((st = br.readLine()) != null)
                System.out.println(st);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
