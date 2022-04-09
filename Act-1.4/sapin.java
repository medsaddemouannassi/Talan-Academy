import java.util.Scanner;

class SapinMoche {
    public static void main(String[] args) {
        int nbtriangles;
        System.out.print("Combien de triangles? ");
        Scanner scanner = new Scanner(System.in);
        nbtriangles = scanner.nextInt();
        System.out.println();
        triangle(nbtriangles, 1);
        body(0);
    }
    static void body(int lig) {
        int nbespaces, nbetoiles;
        nbespaces = 4;
        nbetoiles = 3;
        for (int i = 0; i < nbespaces; i = i + 1) {
            System.out.print(" ");
        }
        for (int i = 0; i < nbetoiles; i = i + 1) {
            System.out.print("*");
        }
        System.out.println();
        if (lig<4) {
            body(lig+1);
        }
    }
    static void triangle(int nbtriangles, int n) {
        int nbespaces, nbetoiles;
        nbespaces = 5;
        nbetoiles = 1;
        for (int lig = 0; lig < 4; lig = lig + 1) {
            for (int i = 0; i < nbespaces; i = i + 1) {
                System.out.print(" ");
            }
            for (int i = 0; i < nbetoiles; i = i + 1) {
                System.out.print("*");
            }
            System.out.println();
            nbetoiles = nbetoiles + 2;
            nbespaces = nbespaces - 1;
        }
        if (n<nbtriangles) {
            n = n + 1;
            triangle(nbtriangles, n);
        }
    }
}

class MonBeauSapin {
    public static void main(String[] args) {
        int nbtriangles, nbespaces, nbetoiles;
        System.out.print("Combien de triangles? ");
        Scanner scanner = new Scanner(System.in);
        nbtriangles = scanner.nextInt();
        System.out.println();
        triangle(nbtriangles, 1);
        body(0, nbtriangles);
    }
    static void body(int lig, int nbtriangles) {
        int nbespaces, nbetoiles;
        nbespaces = 4 + nbtriangles;
        nbetoiles = 3;
        for (int i = 0; i < nbespaces; i = i + 1) {
            System.out.print(" ");
        }
        for (int i = 0; i < nbetoiles; i = i + 1) {
            System.out.print("*");
        }
        System.out.println();
        if (lig<4) {
            body(lig+1, nbtriangles);
        }
    }
    static void triangle(int nbtriangles, int n) {
        int nbespaces, nbetoiles;
        nbespaces = 5 + nbtriangles;
        nbetoiles = 1;
        for (int lig = 0; lig < 2 + n; lig = lig + 1) {
            for (int i = 0; i < nbespaces; i = i + 1) {
                System.out.print(" ");
            }
            for (int i = 0; i < nbetoiles; i = i + 1) {
                System.out.print("*");
            }
            System.out.println();
            nbetoiles = nbetoiles + 2;
            nbespaces = nbespaces - 1;
        }
        if (n<nbtriangles) {
            n = n + 1;
            triangle(nbtriangles, n);
        }
    }
}