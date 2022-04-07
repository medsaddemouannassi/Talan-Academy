import java.util.Scanner;
import java.util.Arrays;
import java.util.*;

public class OrientationEtoile {
	public static void main(String[] args) {
		int q = 0;
		String[] tab = { "Alban", "Jim", "Bob", "Albatroz", "Jinto", "Bow", "Hijo", "Manu", "Seb", "Teilo", "Charles",
				"Xavier" };

		ordre(tab);
		tab = ajout(tab);
		ordre(tab);
		System.out.println("Entrer un nom pour chercher sa position");
		Scanner input = new Scanner(System.in);
		String nom1 = input.nextLine();
		recherche(tab, 0, tab.length - 1, nom1);
	}

	private static String[] ajout(String[] tab) {
		String[] ajoutPrenom = new String[tab.length + 1];
		for (int i = 0; i < tab.length; i++) {
			ajoutPrenom[i] = tab[i];
		}
		Scanner input = new Scanner(System.in);
		System.out.println("Entrer un nouveau nom");
		ajoutPrenom[ajoutPrenom.length - 1] = input.nextLine();
		return ajoutPrenom;
	}

	private static void ordre(String[] prenoms) {

		int k;
		String x;

		for (int i = 0; i < prenoms.length - 1; i++) {

			for (int j = prenoms.length - 1; j > i; j--) {

				k = 0;

				while (k < Math.min(prenoms[j].length(), prenoms[j - 1].length())) {

					if (prenoms[j].toLowerCase().charAt(k) < prenoms[j - 1].toLowerCase().charAt(k)) {
						x = prenoms[j];
						prenoms[j] = prenoms[j - 1];
						prenoms[j - 1] = x;
						k = Math.min(prenoms[j].length(), prenoms[j - 1].length());
					} else if (prenoms[j].charAt(k) > prenoms[j - 1].charAt(k)) {
						k = Math.min(prenoms[j].length(), prenoms[j - 1].length());
					}

					else {
						k++;
					}
				}
			}
		}

		for (int i = 0; i < prenoms.length; i++) {

			System.out.println(prenoms[i]);

		}

	}

	private static int comparer(String ch1, String ch2) {

		int i, a;
		i = 0;
		a = 0;
		do {
			if (ch1.charAt(i) < ch2.charAt(i)) {
				a = 1;
			} else if (ch1.charAt(i) > ch2.charAt(i)) {
				a = 2;
			} else {
				i = i + 1;
			}
		} while (a == 0 && i < Math.min(ch1.length(), ch2.length()));
		return (a);
	}

	public static void recherche(String[] tab, int f, int l, String val) {
		int mid = ((f + l) / 2) + f;
		while (f <= l) {
			if (tab[mid].toLowerCase().equals(val.toLowerCase())) {
				System.out.println("L'élément se trouve à l'index: " + mid);
				break;
			} else {
				l -= 1;
			}
			mid = (f + l) / 2;
		}
		if (f > l) {
			System.out.println("L'élément n'existe pas!");
		}
	}
}