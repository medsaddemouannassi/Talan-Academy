package croisement;

import java.io.*;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        try {
            File file1 = new File("C:\\Users\\MED SADDEM\\Desktop\\Talan-Academy-main\\Talan-Academy-main\\Act-2.2\\Act-2.2.7\\Croisement deux textes\\texte1.txt");
            File file2 = new File("C:\\Users\\MED SADDEM\\Desktop\\Talan-Academy-main\\Talan-Academy-main\\Act-2.2\\Act-2.2.7\\Croisement deux textes\\texte2.txt");
            BufferedReader br1 = new BufferedReader(new FileReader(file1));
            BufferedReader br2 = new BufferedReader(new FileReader(file2));
            BufferedWriter outputWriter = new BufferedWriter(new FileWriter("croisement.txt"));
            BufferedWriter outputWriter1 = new BufferedWriter(new FileWriter("similar.txt"));
            String st1;
            ArrayList<String> st1Tab = new ArrayList<>();
            String st2;
            ArrayList<String> st2Tab = new ArrayList<>();
            while ((st1 = br1.readLine()) != null) {
                for (String word : st1.replaceAll("\\p{Punct}", "").split(" ")) {
                    st1Tab.add(word);

                }
            }
            System.out.println(st1Tab);
            while ((st2 = br2.readLine()) != null) {
                for (String word : st2.replaceAll("\\p{Punct}", "").split(" ")) {
                    st2Tab.add(word);
                }
            }
            System.out.println(st2Tab);
            for (int i = 0; i < Math.min(st1Tab.size(), st2Tab.size()); i++) {
                outputWriter.write(st1Tab.get(i) + " " + st2Tab.get(i) + " ");
            }
            if (st1Tab.size() > st2Tab.size()) {
                for (int i = st1Tab.size() - st2Tab.size(); i < Math.max(st1Tab.size(), st2Tab.size()); i++) {
                    outputWriter.write(st1Tab.get(i) + " ");
                }
            }
            if (st2Tab.size() > st1Tab.size()) {
                for (int i = st2Tab.size() - st1Tab.size(); i < Math.max(st1Tab.size(), st2Tab.size()); i++) {
                    outputWriter.write(st2Tab.get(i) + " ");
                }
            }
            outputWriter.close();
            for (int i = 0; i < Math.min(st1Tab.size(), st2Tab.size()); i++) {
                for (int j = 0; j < Math.min(st1Tab.size(), st2Tab.size()); j++) {
                    if (st1Tab.get(i).equalsIgnoreCase(st2Tab.get(j))) {
                        outputWriter1.write(st1Tab.get(i) + " ");
                    }
                }
            }
            outputWriter1.close();
        } catch (
                Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
