package Streaming;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class PlayListeImpl implements PlayListe {
    final int MAX_MUSIQUES = 7;
    private String nom;
    private String genre;
    private int nombreTitres;
    private  ArrayList<MusiqueImpl> musicTable = new ArrayList<>();

    public PlayListeImpl(String nom) {
        this.setNom(nom);
    }

    public void setNom(String nom) {
        this.nom = nom;
    }
    public String getNom() {
        return this.nom;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }
    public String getGenre() {
        return this.genre;
    }

    public void setNombreTitres(int nombreTitres) {
        this.nombreTitres = nombreTitres;
    }
    public int getNombreTitres() {
        return this.nombreTitres;
    }

    public void setMusicTable(ArrayList<MusiqueImpl> musicTable) {
        this.musicTable = musicTable;
    }
    public ArrayList<MusiqueImpl> getMusicTable() {
        return this.musicTable;
    }

    @Override
    public void displayMusicPlayList() {
        for (int i = 0; i < this.musicTable.size(); i++) {
            if (musicTable.get(i) != null) {
                System.out.println(i+1 + ") " + this.musicTable.get(i).getTitre());
            }
        }
    }

    @Override
    public void addMusic(MusiqueImpl musique) {
            this.musicTable.add(musique);
    }

    @Override
    public void deleteDuplicates() {
        for(int i=0;i<this.musicTable.size();i++) {
            for (int j=this.musicTable.size()-1 ;j>i;j--) {
                if(this.musicTable.get(i).getTitre().equalsIgnoreCase(musicTable.get(j).getTitre()) && this.musicTable.get(i).getAutheur().equalsIgnoreCase(musicTable.get(j).getAutheur()) && this.musicTable.get(i).getInterprete().equalsIgnoreCase(musicTable.get(j).getInterprete()) && this.musicTable.get(i).getGenre().equalsIgnoreCase(musicTable.get(j).getGenre())){
                    this.musicTable.remove(j);
                }
            }
        }
    }

    @Override
    public void displayMusicTwoPlayList(PlayListeImpl playListe) {
        for (int i = 0; i < this.getMusicTable().size(); i++) {
            System.out.println(i+1+") "+ this.getMusicTable().get(i).getTitre());
        }
        for (int i = 0; i < playListe.getMusicTable().size(); i++) {
            System.out.println(this.getMusicTable().size()+i+1+") "+ playListe.getMusicTable().get(i).getTitre());
        }
    }

    class triMusicAutheur implements Comparator<MusiqueImpl> {
        @Override
        public int compare(MusiqueImpl o1, MusiqueImpl o2) {
            return o1.getAutheur().compareTo(o2.getAutheur());
        }
    }
    @Override
    public void triMusicAutheur() {
        Collections.sort(this.getMusicTable(), new triMusicAutheur());
    }

    class triMusicInterprete implements Comparator<MusiqueImpl> {
        @Override
        public int compare(MusiqueImpl o1, MusiqueImpl o2) {
            return o1.getInterprete().compareTo(o2.getInterprete());
        }
    }
    @Override
    public void triMusicInterprete() {
        Collections.sort(this.getMusicTable(), new triMusicInterprete());
    }

    class triMusicTitreCroissant implements Comparator<MusiqueImpl> {
        @Override
        public int compare(MusiqueImpl o1, MusiqueImpl o2) {
            return o1.getTitre().compareTo(o2.getTitre());
        }
    }
    public void triMusicTitreCroissant() {
        Collections.sort(this.getMusicTable(), new PlayListeImpl.triMusicTitreCroissant());
    }

    class triMusicTitreDecroissant implements Comparator<MusiqueImpl> {
        @Override
        public int compare(MusiqueImpl o1, MusiqueImpl o2) {
            return o2.getTitre().compareTo(o1.getTitre());
        }
    }
    public void triMusicTitreDecroissant() {
        Collections.sort(this.getMusicTable(), new PlayListeImpl.triMusicTitreDecroissant());
    }
}
