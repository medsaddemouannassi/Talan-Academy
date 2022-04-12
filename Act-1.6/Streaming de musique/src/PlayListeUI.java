import java.util.Scanner;

public class PlayListeUI {

    public static void main(String[] args) {
        MusiqueImpl music1 = new MusiqueImpl();
        MusiqueImpl music2 = new MusiqueImpl();
        MusiqueImpl music3 = new MusiqueImpl();
        MusiqueImpl music4 = new MusiqueImpl();
        MusiqueImpl music5 = new MusiqueImpl();

        music1.setTitre("titre 1");
        music2.setTitre("titre 2");
        music3.setTitre("titre 3");
        music4.setTitre("titre 4");
        music5.setTitre("titre 5");

        music1.setAutheur("autheur 1");
        music2.setAutheur("autheur 2");
        music3.setAutheur("autheur 3");
        music4.setAutheur("autheur 4");
        music5.setAutheur("autheur 5");

        music1.setInterprete("interprete 1");
        music2.setInterprete("interprete 2");
        music3.setInterprete("interprete 3");
        music4.setInterprete("interprete 4");
        music5.setInterprete("interprete 5");

        music1.setGenre("genre 1");
        music2.setGenre("genre 2");
        music3.setGenre("genre 3");
        music4.setGenre("genre 4");
        music5.setGenre("genre 5");

        System.out.println("-------------------------MENU------------------------");
        System.out.println("1- afficher la musique");
        System.out.println("2- comparer la musique");
        System.out.println("3- afficher les musiques de la playliste");
        System.out.println("4- ajouter une musique à la playliste");
        System.out.println("5- éliminer les doublons de la playliste");
        System.out.println("6- afficher les musiques de deux la playlistes");
        System.out.println("7- trier les musiques de la playliste par auteur");
        System.out.println("8- trier les musiques de la playliste par interprete");
        System.out.println("----------------------------------------------------");
        System.out.print("Veuillez saisir votre choix: ");
        Scanner scanner = new Scanner(System.in);
        int choixMenu = scanner.nextInt();
        if (choixMenu == 1) {
            music1.displayMusic();
            music2.displayMusic();
            music3.displayMusic();
            music4.displayMusic();
            music5.displayMusic();
        } else if (choixMenu == 2) {
            System.out.print("Veuillez saisir le nom de la musique 1: ");
            String choixMusic1 = scanner.nextLine();
        }


    }


}
