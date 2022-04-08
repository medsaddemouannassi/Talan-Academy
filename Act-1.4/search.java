import java.util.Scanner;

public class Search{
	public static void main(String[] args){
		int[] tab = array();
		Scanner scannerX = new Scanner(System.in);
		System.out.print("Veuillez saisir nombre à rechercher: ");
		int x = scannerX.nextInt();
            	System.out.print(rechercher(tab, x, 0));
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
	
	public static boolean rechercher(int[] tab, int x, int n){
		boolean result= false;
		if (x==tab[n] && n<tab.length){
			result = true;
		} else {
			return rechercher(tab, x, n+1);	
		}
		return result;
	}
}