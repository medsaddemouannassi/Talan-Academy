import java.util.Scanner;

public class CompterButin {
	public static void main(String[] args) {
		Scanner scannerNb = new Scanner(System.in);
		Scanner scannerMeth = new Scanner(System.in);
		Scanner scannerRes = new Scanner(System.in);
		int result = 0;
		String res = "";
		do {
			System.out.print("Veuillez saisir un nombre:");
			int num1 = scannerNb.nextInt();
			System.out.print("Veuillez saisir un deuxième nombre:");
			int num2 = scannerNb.nextInt();
			System.out.print("Saisissez vote mode de calcul:");
			String meth = scannerMeth.nextLine();
			if (meth.equals("+")) {
				result += num1 + num2;
			} else if (meth.equals("-")) {
				result += num1 - num2;
			} else if (meth.equals("/")) {
				result += num1 / num2;
			} else if (meth.equals("*")) {
				result += num1 * num2;
			}

			System.out.println(
					"Résultat total : " + result + ". Continuez ? (tapez 'Oui' pour continuer et 'Non' pour Sortir)");
			res = scannerRes.nextLine().toLowerCase();
		} while (res.equals("oui"));
		System.out.println("Merci, à bientôt l'ami !");
	}
}