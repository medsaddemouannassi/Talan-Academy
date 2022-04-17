package Streaming;

import java.util.ArrayList;

public class User {
    private String nom;
    private String prénom;
    private String pseudo;
    private ArrayList<PlayListeImpl> playlisteTable = new ArrayList<>();

    public User(String nom, String prénom, String pseudo) {
        this.setNom(nom);
        this.setPrénom(prénom);
        this.setPseudo(pseudo);
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrénom() {
        return prénom;
    }

    public void setPrénom(String prénom) {
        this.prénom = prénom;
    }

    public String getPseudo() {
        return pseudo;
    }

    public void setPseudo(String pseudo) {
        this.pseudo = pseudo;
    }

    public ArrayList<PlayListeImpl> getPlaylisteTable() {
        return playlisteTable;
    }

    public void setPlaylisteTable(ArrayList<PlayListeImpl> playlisteTable) {
        this.playlisteTable = playlisteTable;
    }

    public void afficherMusique() {
        for (int i = 0; i < playlisteTable.size(); i++) {
            for (int j = 0; j < playlisteTable.get(i).getMusicTable().size(); j++) {
                System.out.println(playlisteTable.get(i).getMusicTable().get(j).getTitre());
            }
        }
    }

    public MusiqueImpl rechercherMusique(String musique) {
        for (int i = 0; i < playlisteTable.size(); i++) {
            for (int j = 0; j < playlisteTable.get(i).getMusicTable().size(); j++) {
                if (playlisteTable.get(i).getMusicTable().get(j).getTitre().equals(musique) || playlisteTable.get(i).getMusicTable().get(j).getAutheur().equals(musique)) {
                    System.out.println(playlisteTable.get(i).getMusicTable().get(j).getTitre());
                    return playlisteTable.get(i).getMusicTable().get(j);
                }
            }
        }
        return null;
    }

    public void supprimerMusique(String musique) {
        for (int i = 0; i < playlisteTable.size(); i++) {
            for (int j = 0; j < playlisteTable.get(i).getMusicTable().size(); j++) {
                if (playlisteTable.get(i).getMusicTable().get(j).getTitre().equals(musique)) {
                    System.out.println("Musique Supprimé: "+playlisteTable.get(i).getMusicTable().get(j).getTitre());
                    playlisteTable.get(i).getMusicTable().remove(j);
                }
            }
        }
    }
}
