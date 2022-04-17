package Streaming;

import java.util.Scanner;
import java.util.ArrayList;

public class PlayListeUI {
    private static Scanner scanner = new Scanner(System.in);
    private static Scanner musiqueScanner = new Scanner(System.in);
    private static Scanner userScanner = new Scanner(System.in);
    private static ArrayList<MusiqueImpl> musiques = new ArrayList<>();
    private static ArrayList<PlayListeImpl> playlistes = new ArrayList<>();
    private static ArrayList<User> users = new ArrayList<>();


    public static void main(String[] args) {
        MusiqueImpl musique = new MusiqueImpl();
        PlayListeImpl playListe1 = new PlayListeImpl("playListe1");
        PlayListeImpl playListe2 = new PlayListeImpl("playListe1");
        musique.setTitre("musique");
        musique.setAutheur("autheur");
        musique.setInterprete("interprete");
        musique.setGenre("genre");
        int choixMenu, choixPlayliste, choixMenuUser, concatPlayliste1, concatPlayliste2;
        do {
            System.out.println("------------------------MENU--------------------------");
            System.out.println("1- ajouter une musique");
            System.out.println("2- afficher toute la musique");
            System.out.println("3- comparer deux musiques");
            System.out.println("4- ajouter une musique à la playliste");
            System.out.println("5- afficher les musiques de la playliste");
            System.out.println("6- éliminer les doublons de la playliste");
            System.out.println("7- afficher les musiques des deux playlistes");
            System.out.println("8- trier les musiques de la playliste par auteur");
            System.out.println("9- trier les musiques de la playliste par interprete");
            System.out.println("10- Créer votre profil");
            System.out.println("0- sortir");
            System.out.print("Veuillez saisir votre choix: ");
            choixMenu = scanner.nextInt();
            if (choixMenu == 1) {
                insertMusic();
            } else if (choixMenu == 2) {
                musique.displayMusic(musiques);
            } else if (choixMenu == 3) {
                compareMusic();
            } else if (choixMenu == 4) {
                if (playlistes.size() == 0) {
                    System.out.print("Créer une playliste: ");
                    String nomPlayliste = userScanner.nextLine();
                    playlistes.add(new PlayListeImpl(nomPlayliste));
                }
                for (int i = 0; i < playlistes.size(); i++) {
                    System.out.println(i + 1 + ") " + playlistes.get(i).getNom());
                }
                System.out.print("Voulez-vous créer une nouvelle playliste? répondre par 'Oui' ou 'Non' : ");
                String nouvellePlayliste = userScanner.nextLine();
                if (nouvellePlayliste.equalsIgnoreCase("oui")) {
                    System.out.print("Créer une playliste: ");
                    String nomNvPlayliste = userScanner.nextLine();
                    playlistes.add(new PlayListeImpl(nomNvPlayliste));
                    for (int i = 0; i < playlistes.size(); i++) {
                        System.out.println(i + 1 + ") " + playlistes.get(i).getNom());
                    }
                }
                System.out.print("Entrez le numéro de la playliste: ");
                choixPlayliste = scanner.nextInt();
                for (int i = 0; i < musiques.size(); i++) {
                    System.out.println(i + 1 + ") " + musiques.get(i).getTitre());
                }
                System.out.print("Entrez le numéro de la musique: ");
                int musiqueAjout = scanner.nextInt();
                playlistes.get(choixPlayliste - 1).addMusic(musiques.get(musiqueAjout - 1));
            } else if (choixMenu == 5) {
                for (int i = 0; i < playlistes.size(); i++) {
                    System.out.println(i + 1 + ") " + playlistes.get(i).getNom());
                }
                System.out.print("Entrez le numéro de la playliste: ");
                choixPlayliste = scanner.nextInt();
                playlistes.get(choixPlayliste - 1).displayMusicPlayList();
            } else if (choixMenu == 6) {
                for (int i = 0; i < playlistes.size(); i++) {
                    playlistes.get(i).deleteDuplicates();
                    System.out.println(i + 1 + ") " + playlistes.get(i).getNom());
                }
            } else if (choixMenu == 7) {
                for (int i = 0; i < playlistes.size(); i++) {
                    System.out.println(i + 1 + ") " + playlistes.get(i).getNom());
                }
                System.out.print("Entrez le numéro de la playliste 1: ");
                concatPlayliste1 = scanner.nextInt();
                System.out.print("Entrez le numéro de la playliste 2: ");
                concatPlayliste2 = scanner.nextInt();
                playlistes.get(concatPlayliste1 - 1).displayMusicTwoPlayList(playlistes.get(concatPlayliste2 - 1));
            } else if (choixMenu == 8) {
                for (int i = 0; i < playlistes.size(); i++) {
                    System.out.println(i + 1 + ") " + playlistes.get(i).getNom());
                }
                System.out.print("Entrez le numéro de la playliste: ");
                choixPlayliste = scanner.nextInt();
                playlistes.get(choixPlayliste - 1).triMusicAutheur();
            } else if (choixMenu == 9) {

                for (int i = 0; i < playlistes.size(); i++) {
                    System.out.println(i + 1 + ") " + playlistes.get(i).getNom());
                }
                System.out.print("Entrez le numéro de la playliste: ");
                choixPlayliste = scanner.nextInt();
                playlistes.get(choixPlayliste - 1).triMusicInterprete();
            }
            if (choixMenu == 10) {
                System.out.print("Entrez votre nom: ");
                String nom = userScanner.nextLine();
                System.out.print("Entrez votre prénom: ");
                String prénom = userScanner.nextLine();
                System.out.print("Entrez votre pseudo: ");
                String pseudo = userScanner.nextLine();
                User connectedUser = new User(nom, prénom, pseudo);
                users.add(connectedUser);
                do {
                    System.out.println("------------------------MENU USER--------------------------");
                    System.out.println("1- Ajouter une musique à une Playlist");
                    System.out.println("2- Afficher toutes les musiques de toutes ses playlists");
                    System.out.println("3- Rechercher une musique par titre / auteur");
                    System.out.println("4- Trier une playlist par titre de manière croissante");
                    System.out.println("5- Trier une playlist par titre de manière décroissante");
                    System.out.println("6- Supprimer une musique d'une Playlist");
                    System.out.println("0- Déconnexion");
                    System.out.print("Veuillez saisir votre choix: ");
                    choixMenuUser = scanner.nextInt();
                    if (choixMenuUser == 1) {
                        if (playlistes.size() == 0) {
                            System.out.print("Créer une playliste: ");
                            String nomPlayliste = userScanner.nextLine();
                            playlistes.add(new PlayListeImpl(nomPlayliste));
                        }
                        for (int i = 0; i < playlistes.size(); i++) {
                            System.out.println(i + 1 + ") " + playlistes.get(i).getNom());
                        }
                        System.out.print("Voulez-vous créer une nouvelle playliste? répondre par 'Oui' ou 'Non' : ");
                        String nouvellePlayliste = userScanner.nextLine();
                        if (nouvellePlayliste.equalsIgnoreCase("oui")) {
                            System.out.print("Créer une playliste: ");
                            String nomNvPlayliste = userScanner.nextLine();
                            playlistes.add(new PlayListeImpl(nomNvPlayliste));
                            for (int i = 0; i < playlistes.size(); i++) {
                                System.out.println(i + 1 + ") " + playlistes.get(i).getNom());
                            }
                        }
                        System.out.print("Entrez le numéro de la playliste: ");
                        choixPlayliste = scanner.nextInt();
                        for (int i = 0; i < musiques.size(); i++) {
                            System.out.println(i + 1 + ") " + musiques.get(i).getTitre());
                        }
                        System.out.print("Entrez le numéro de la musique: ");
                        int musiqueAjout = scanner.nextInt();
                        playlistes.get(choixPlayliste - 1).addMusic(musiques.get(musiqueAjout - 1));
                        connectedUser.setPlaylisteTable(playlistes);
                    }
                    if (choixMenuUser == 2) {
                        connectedUser.afficherMusique();
                    } else if (choixMenuUser == 3) {
                        System.out.print("Entrez le titre où l'auteur: ");
                        String rech = userScanner.nextLine();
                        connectedUser.rechercherMusique(rech);
                    } else if (choixMenuUser == 4) {
                        for (int i = 0; i < connectedUser.getPlaylisteTable().size(); i++) {
                            System.out.println(i + 1 + ") " + connectedUser.getPlaylisteTable().get(i).getNom());
                        }
                        System.out.print("Veuillez saisir le numéro de la playliste: ");
                        int choixTriPlayliste = userScanner.nextInt();
                        connectedUser.getPlaylisteTable().get(choixTriPlayliste - 1).triMusicTitreCroissant();
                        for (int i = 0; i < connectedUser.getPlaylisteTable().size(); i++) {
                            System.out.println(i + 1 + ") " + connectedUser.getPlaylisteTable().get(choixTriPlayliste - 1).getMusicTable().get(i).getTitre());
                        }
                    } else if (choixMenuUser == 5) {
                        for (int i = 0; i < connectedUser.getPlaylisteTable().size(); i++) {
                            System.out.println(i + 1 + ") " + connectedUser.getPlaylisteTable().get(i).getNom());
                        }
                        System.out.print("Veuillez saisir le numéro de la playliste: ");
                        int choixTriPlayliste = userScanner.nextInt();
                        connectedUser.getPlaylisteTable().get(choixTriPlayliste - 1).triMusicTitreDecroissant();
                        for (int i = 0; i < connectedUser.getPlaylisteTable().size(); i++) {
                            System.out.println(i + 1 + ") " + connectedUser.getPlaylisteTable().get(choixTriPlayliste - 1).getMusicTable().get(i).getTitre());
                        }
                    } else if (choixMenuUser == 6) {
                        for (int i = 0; i < connectedUser.getPlaylisteTable().size(); i++) {
                            System.out.println(i + 1 + ") " + connectedUser.getPlaylisteTable().get(i).getNom());
                        }
                        System.out.print("Veuillez saisir le numéro de la playliste: ");
                        choixPlayliste = scanner.nextInt();
                        for (int i = 0; i < connectedUser.getPlaylisteTable().get(choixPlayliste - 1).getMusicTable().size(); i++) {
                            System.out.println(i + 1 + ") " + connectedUser.getPlaylisteTable().get(choixPlayliste - 1).getMusicTable().get(i).getTitre());
                        }
                        System.out.print("Veuillez saisir le nom de la musique: ");
                        String supp = userScanner.nextLine();
                        connectedUser.supprimerMusique(supp);
                        for (int i = 0; i < connectedUser.getPlaylisteTable().get(choixPlayliste - 1).getMusicTable().size(); i++) {
                            System.out.println(i + 1 + ") " + connectedUser.getPlaylisteTable().get(choixPlayliste - 1).getMusicTable().get(i).getTitre());
                        }
                    }
                } while (choixMenuUser != 0);
            }
        } while (choixMenu != 0);
    }

    public static void insertMusic() {
        System.out.println("--------------------------");
        System.out.print("Entrez le titre: ");
        String titreNvMusique = musiqueScanner.nextLine();
        System.out.print("Entrez l'autheur: ");
        String autheurNvMusique = musiqueScanner.nextLine();
        System.out.print("Entrez l'interprete: ");
        String interpreteNvMusique = musiqueScanner.nextLine();
        System.out.print("Entrez le genre: ");
        String genreNvMusique = musiqueScanner.nextLine();
        MusiqueImpl nvMusique = new MusiqueImpl();
        nvMusique.setTitre(titreNvMusique);
        nvMusique.setAutheur(autheurNvMusique);
        nvMusique.setInterprete(interpreteNvMusique);
        nvMusique.setGenre(genreNvMusique);
        musiques.add(nvMusique);
        for (int i = 0; i < musiques.size(); i++) {
            System.out.println(i + 1 + ") " + musiques.get(i).getTitre());
        }
    }

    public static void compareMusic() {
        for (int i = 0; i < musiques.size(); i++) {
            System.out.println(i + 1 + ") " + musiques.get(i).getTitre());
        }
        System.out.print("Entrez le numéro de la musique 1: ");
        int musiqueVs1 = scanner.nextInt();
        System.out.print("Entrez le numéro de la musique 2: ");
        int musiqueVs2 = scanner.nextInt();
        System.out.println(musiques.get(musiqueVs1 - 1).compare(musiques.get(musiqueVs2 - 1)));
    }
}
