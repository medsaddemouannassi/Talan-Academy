import java.util.Scanner;

class CalculMontant {
    public static void main(String[] args) {
        System.out.print("Combien de produits? ");
        Scanner scanner = new Scanner(System.in);
        int nbProducts = scanner.nextInt();
        System.out.print("Le prix TTC est: " + calculate(0, nbProducts, 1));
    }

    static double calculate(double ttc, int nbProducts, int n) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Entrer le prix HT du produit N°" + n + ": ");
        int priceHt = scanner.nextInt();
        System.out.print("Entrer la quantité du produit N°" + n + ": ");
        int quantity = scanner.nextInt();
        System.out.println("Est ce que le taux de TVA est: 1- normal(20%) || 2-  intermédiaire (10%) || 3- réduit (5,5%)");
        System.out.print("Entrer 1 ou 2 ou 3: ");
        double tva = scanner.nextInt();
        tva = tva == 1 ? 0.2 : tva == 2 ? 0.1 : tva == 3 ? 0.055 : 0;
        double priceTtc = ttc + ((priceHt + (priceHt * tva)) * quantity);
        if (n < nbProducts) {
            return calculate(priceTtc, nbProducts, n += 1);
        }
        return priceTtc;
    }
}