package ArrayList;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class Main {
    public static void main(String[] args) {
        ArrayList<String> animaux = new ArrayList<>();
        animaux.add("Lion");
        animaux.add("Tiger");
        animaux.add("Cat");
        animaux.add("Dog");
        System.out.println(animaux);
        animaux.add(2, "Elephant");
        System.out.println(animaux);
        ArrayList<String> copieAnimaux = animaux;
        System.out.println("----------------------------------------------------");
        ArrayList<String> concat = new ArrayList<>();
        concat.addAll(animaux);
        concat.addAll(copieAnimaux);
        System.out.println(concat);
        System.out.println("Taille du tableau: " + concat.size());
        System.out.println("----------------------------------------------------");
        System.out.println("Suppression de l'élément en position: " + concat.indexOf("Cat"));
        System.out.println("Suppression de l'élément " + concat.get(3));
        concat.remove(3);
        System.out.println("Nouveau tableau : " + concat);
        System.out.println("Taille du tableau: " + concat.size());
        System.out.println("----------------------------------------------------");
        System.out.println("Suppression de l'animal (nom): Tiger");
        concat.removeAll(Collections.singleton("Tiger"));
        System.out.println("Nouveau tableau : " + concat);
        System.out.println("Taille du tableau: " + concat.size());
        System.out.println("----------------------------------------------------");
        System.out.println(concat.contains("Lion"));
        System.out.println(concat.contains("Tiger"));
        System.out.println("----------------------------------------------------");
        Collections.sort(concat);
        System.out.println("Nouveau tableau : " + concat);
        System.out.println("----------------------------------------------------");
        concat.sort(Comparator.naturalOrder());
        System.out.println("Nouveau tableau : " + concat);
        System.out.println("----------------------------------------------------");
        ordre(concat);
        System.out.println("Nouveau tableau : " + concat);
    }

    private static void ordre(ArrayList<String> animaux) {
        int k;
        String x;
        for (int i = 0; i < animaux.size() - 1; i++) {
            for (int j = animaux.size() - 1; j > i; j--) {
                k = 0;
                while (k < Math.min(animaux.get(j).length(), animaux.get(j-1).length())) {
                    if (animaux.get(j).toLowerCase().charAt(k) < animaux.get(j - 1).toLowerCase().charAt(k)) {
                        x = animaux.get(j);
                        animaux.set(j, animaux.get(j - 1));
                        animaux.set(j - 1, x);
                        k = Math.min(animaux.size(), animaux.get(j - 1).length());
                    } else if (animaux.get(j).charAt(k) > animaux.get(j - 1).charAt(k)) {
                        k = Math.min(animaux.get(j).length(), animaux.get(j-1).length());
                    } else {
                        k++;
                    }
                }
            }
        }
    }
}







