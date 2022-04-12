import java.util.Arrays;
import java.util.Comparator;

public class PlayListeImpl implements PlayListe {
    final int MAX_MUSIQUES = 7;
    private String nom;
    private String genre;
    private int nombreTitres;
    private MusiqueImpl[] musicTable = new MusiqueImpl[MAX_MUSIQUES];

    public PlayListeImpl() {

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

    public void setMusicTable(MusiqueImpl[] musicTable) {
        this.musicTable = musicTable;
    }

    public MusiqueImpl[] getMusicTable() {
        return this.musicTable;
    }

    @Override
    public void displayMusicPlayList() {
        for (int i = 0; i < this.musicTable.length; i++) System.out.println(this.musicTable[i]);
    }

    @Override
    public void addMusic(MusiqueImpl music) {
        for (int i = 0; i < this.musicTable.length; i++) {
            if (this.musicTable[i] == null) {
                this.musicTable[i] = music;
                System.out.println(music.getTitre() + " successfully added!");
                break;
            } else {
                System.out.println(music.getTitre() + " can't be added, storage is full!");
            }
        }
    }

    @Override
    public void deleteDuplicates() {
        for (int i = 0; i < this.musicTable.length; i++) {
            for (int j = i + 1; j < this.musicTable.length; j++) {
                if (this.musicTable[i] == this.musicTable[j]) this.musicTable[j] = null;
            }
        }
    }

    @Override
    public void displayMusicTwoPlayList(PlayListeImpl playListe) {
        for (int i = 0; i < this.musicTable.length; i++) System.out.println(this.musicTable[i]);
        for (int i = 0; i < playListe.musicTable.length; i++) System.out.println(playListe.musicTable[i]);
    }

    @Override
    public void triMusicAutheur() {
        Arrays.sort(this.musicTable, (MusiqueImpl a, MusiqueImpl b) -> a.getAutheur().compareTo(b.getAutheur()));

    }

    @Override
    public void triMusicInterprete() {
        Arrays.sort(this.musicTable, (MusiqueImpl a, MusiqueImpl b) -> a.getInterprete().compareTo(b.getInterprete()));
    }
}
