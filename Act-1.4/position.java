import java.util.Scanner;

public class Position{
	public static void main(String[] args){
		int[] tab = array();
		ordre(tab);
		Scanner scannerX = new Scanner(System.in);
		System.out.print("Veuillez saisir nombre à rechercher: ");
		int x = scannerX.nextInt();
            	System.out.print("La position est: "+pos(tab, x, 0));
	}
	static int[] array(){
			Scanner scannerNb = new Scanner(System.in);
			Scanner scannerRes = new Scanner(System.in);
            		System.out.print("Veuillez saisir la dimension du tableau: ");
			int n = scannerNb.nextInt();
			int[] tab = new int[n];
			for (int i = 0; i < tab.length; i++) {
            		System.out.print("Veuillez saisir nombre "+(i+1)+": ");
			int num1 = scannerNb.nextInt();
			tab[i] = num1;
			}
			for (int i = 0; i < tab.length; i++) {
				System.out.println(tab[i] + " ");
			}
        return tab;
	}
	private static void ordre(int[] tab) {
		int k;
		int x;
		for (int i = 0; i < tab.length - 1; i++) {
			for (int j = tab.length - 1; j > i; j--) {
					if (tab[j] < tab[j - 1]) {
						x = tab[j];
						tab[j] = tab[j - 1];
						tab[j - 1] = x;
					}
				}
			}
				for (int i = 0; i < tab.length; i++) {
			System.out.println(tab[i]+ " ");
		}
		}

	

	
	public static int pos(int[] tab, int x, int n){
		if (x==tab[n] && n<tab.length){
			return n;
		} else {
			return pos(tab, x, n+1);	
		}
	}
}