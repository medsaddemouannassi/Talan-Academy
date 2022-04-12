import java.util.Scanner;
import java.util.ArrayList;

public class PlayListeUI {
    private static Scanner scanner = new Scanner(System.in);
    private static ArrayList<MusiqueImpl> musiques = new ArrayList<>();


    public static void main(String[] args) {
        MusiqueImpl musique = new MusiqueImpl();
        PlayListeImpl playListe1 = new PlayListeImpl();
        PlayListeImpl playListe2 = new PlayListeImpl();
        musique.setTitre("musique");
        musique.setAutheur("autheur");
        musique.setInterprete("interprete");
        musique.setGenre("genre");
        int choixMenu;
        do {
            System.out.println("------------------------MENU--------------------------");
            System.out.println("1- ajouter une musique");
            System.out.println("2- afficher toute la musique");
            System.out.println("3- comparer deux musiques");
            System.out.println("4- afficher les musiques de la playliste");
            System.out.println("5- ajouter une musique à la playliste");
            System.out.println("6- éliminer les doublons de la playliste");
            System.out.println("7- afficher les musiques des deux playlistes");
            System.out.println("8- trier les musiques de la playliste par auteur");
            System.out.println("9- trier les musiques de la playliste par interprete");
            System.out.println("0- sortir");
            System.out.print("Veuillez saisir votre choix: ");
            choixMenu = scanner.nextInt();
            if (choixMenu == 1) {
                insertMusic();
            } else if (choixMenu == 2) {
                musique.displayMusic(musique);
            } else if (choixMenu == 3) {
                compareMusic();
            } else if (choixMenu == 4) {
                for (int i = 0; i < musiques.size(); i++) {
                    System.out.println(i+1 + ") " + musiques.get(i));
                }
                System.out.print("Entrez le numéro de la musique: ");
                int musiqueAjout = scanner.nextInt();
                playListe1.addMusic(musiques.get(musiqueAjout-1));
            } else if (choixMenu == 5) {
                playListe2.addMusic(musique);
            } else if (choixMenu == 6) {
                playListe1.deleteDuplicates();
            } else if (choixMenu == 7) {
                playListe1.displayMusicTwoPlayList(playListe2);
            } else if (choixMenu == 8) {
                playListe1.triMusicAutheur();
            } else if (choixMenu == 9) {
                playListe2.triMusicInterprete();
            }
        } while (choixMenu != 0);


    }

    public static void insertMusic() {
        System.out.print("Entrez le titre: ");
        String titreNvMusique = scanner.nextLine();
        System.out.print("Entrez l'autheur: ");
        String autheurNvMusique = scanner.nextLine();
        System.out.print("Entrez l'interprete: ");
        String interpreteNvMusique = scanner.nextLine();
        System.out.print("Entrez le genre: ");
        String genreNvMusique = scanner.nextLine();
        MusiqueImpl nvMusique = new MusiqueImpl();
        nvMusique.setTitre(titreNvMusique);
        nvMusique.setAutheur(autheurNvMusique);
        nvMusique.setInterprete(interpreteNvMusique);
        nvMusique.setGenre(genreNvMusique);
        musiques.add(nvMusique);
        for (int i = 0; i < musiques.size(); i++) {
            System.out.println(i+1 + ") " + musiques.get(i));
        }
    }

    public static void compareMusic() {
        for (int i = 0; i < musiques.size(); i++) {
            System.out.println(i+1 + ") " + musiques.get(i));
        }
        System.out.print("Entrez le numéro de la musique 1: ");
        int musiqueVs1 = scanner.nextInt();
        System.out.print("Entrez le numéro de la musique 2: ");
        int musiqueVs2 = scanner.nextInt();
        musiques.get(musiqueVs1-1).compare(musiques.get(musiqueVs2-1));
    }
}
