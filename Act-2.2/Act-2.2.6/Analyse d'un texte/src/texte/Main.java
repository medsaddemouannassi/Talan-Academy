package texte;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;
import java.util.function.Supplier;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {
        lecture();
    }

    static String lecture() {
        String s = null;
        String newText = "";
        String regex = "";
        ArrayList<String> occ = new ArrayList<>();
        try {
            //Path path = Paths.get("C:\\Users\\msouannassi\\Desktop\\Talan-Academy-main\\Talan-Academy-main\\Act-2.2\\Act-2.2.6\\texte1.txt");
            Path path = Paths.get("C:\\Users\\MED SADDEM\\Desktop\\Talan-Academy-main\\Talan-Academy-main\\Act-2.2\\Act-2.2.6\\texte1.txt");
            Scanner source = new Scanner(path);
            String[] wordsCount = new String[0];
            FileWriter myWriter;
            while (source.hasNextLine()) {
                try {
                    Pattern pattern = Pattern.compile(".*[eéèênEN].*");
                    myWriter = new FileWriter("regex.txt");
                    for (int i = 0; i < wordsCount.length; i++) {
                        Matcher matcher = pattern.matcher(wordsCount[i]);
                        if (matcher.matches()) {
                            regex += wordsCount[i] + " ";
                        }
                    }
                    myWriter.write(regex);
                    myWriter.close();
                    s = source.nextLine();
                    if (!s.equalsIgnoreCase("")) {
                        String replaceAll = s.replaceAll("\\s+", " ").replaceAll("\\p{Punct}", "");
                        wordsCount = replaceAll.split(" ");
                        for (int i = 0; i < wordsCount.length; i++) {
                            occ.add(wordsCount[i]);
                        }
                    }
                } catch (Exception e) {
                    System.out.println(e.getMessage());
                }
                for (int i = 0; i < wordsCount.length; i += 2) {
                    newText += wordsCount[i] + " ";
                }
            }
            myWriter = new FileWriter("newText.txt");
            myWriter.write(newText);
            myWriter.close();
            occurence(occ);
            capitalize(occ);
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        return s;
    }

    public static void occurence(ArrayList<String> tab) {
        try {
            Map<String, Integer> map = new HashMap<>();
            BufferedWriter outputWriter = new BufferedWriter(new FileWriter("occurences.txt"));
            for (String word : tab) {
                Integer count = map.get(word.toLowerCase());
                if (count == null) {
                    map.put(word.toLowerCase(), 1);

                } else {
                    map.put(word.toLowerCase(), ++count);
                }
            }
            Stream<Map.Entry<String, Integer>> sorted = map.entrySet().stream().sorted(Map.Entry.comparingByValue());
            sorted.forEach(element -> {
                try {
                    System.out.println(element);
                    outputWriter.write(String.valueOf(element.getKey()));
                    if (element.getKey().length() > 5)
                        outputWriter.write("\t" + "\t" + element.getValue());
                    else outputWriter.write("\t" + "\t" + "\t" + element.getValue());
                    outputWriter.newLine();
                } catch (IOException e) {
                    System.out.println(e.getMessage());
                }
            });
            //File file = new File("C:\\Users\\msouannassi\\Desktop\\Talan-Academy-main\\Talan-Academy-main\\Act-2.2\\Act-2.2.6\\Analyse d'un texte\\occurences.txt");
            File file = new File("C:\\Users\\MED SADDEM\\Desktop\\Talan-Academy-main\\Talan-Academy-main\\Act-2.2\\Act-2.2.6\\Analyse d'un texte\\occurences.txt");
            outputWriter.close();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    public static void capitalize(ArrayList<String> tab) {
        try {
            BufferedWriter outputWriter = new BufferedWriter(new FileWriter("pluriels.txt"));
            for (String word : tab) {
                if (word.endsWith("s") && !word.equalsIgnoreCase("dans")) {
                    outputWriter.write(word.substring(0, 1).toUpperCase() + word.substring(1) +" ");
                }
            }
            outputWriter.close();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}