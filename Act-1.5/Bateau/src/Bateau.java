public class Bateau {
    public String marque;
    public int releaseYear;
    private int id;

    private Coque coque;
    private Pont pont;
    private Cabine cabine;

    public Bateau(String marque, int releaseYear, Coque coque, Pont pont, Cabine cabine) {
        this.marque = marque;
        this.releaseYear = releaseYear;
        this.coque = coque;
        this.pont = pont;
        this.cabine = cabine;
    }

    public Bateau() {

    }

    public int getId() {
        return this.id;
    }
    public void setId(int id){
        this.id = id;
    }

    public String toString() {
        return "Le bateau n°" + this.getId() + " est constitué de:";
    }
}
