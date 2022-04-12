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
        for (int i = 0; i < this.musicTable.length; i++) {
            System.out.println(i+1 + ") " + this.musicTable[i]);
        }
    }

    @Override
    public void addMusic(MusiqueImpl musique) {
        if(this.nombreTitres<this.musicTable.length) {
            this.musicTable[this.nombreTitres]=musique;
            this.nombreTitres=this.nombreTitres+1;
        } else {
            System.out.println("La playliste est pleine, impossible d'ajouter");
        }
    }

    @Override
    public void deleteDuplicates() {
        for(int i=0;i<this.nombreTitres;i++) {
            for (int j=this.nombreTitres-1 ;j>i;j--) {
                if(this.musicTable[i]==this.musicTable[j]){
                    this.musicTable[j] = null;
                    this.nombreTitres -= 1;
                }
            }
        }
        Arrays.sort(this.musicTable);
    }

    @Override
    public void displayMusicTwoPlayList(PlayListeImpl playListe) {
        for (int i = 0; i < this.getMusicTable().length; i++) {
            System.out.println(i+1+") "+this.getMusicTable()[i]);
        }
        for (int i = 0; i < playListe.getMusicTable().length; i++) {
            System.out.println(this.getMusicTable().length+i+") "+playListe.getMusicTable()[i]);
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
        Arrays.sort(this.getMusicTable(), new triMusicAutheur());
    }

    class triMusicInterprete implements Comparator<MusiqueImpl> {
        @Override
        public int compare(MusiqueImpl o1, MusiqueImpl o2) {
            return o1.getInterprete().compareTo(o2.getInterprete());
        }
    }
    @Override
    public void triMusicInterprete() {
        Arrays.sort(this.getMusicTable(), new triMusicInterprete());
    }
}
