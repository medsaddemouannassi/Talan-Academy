public class Bateau {
    public String marque;
    public int releaseYear;
    final int ID = 1;

    private Coque coque;
    private Pont pont;
    private Cabine cabine;

    public Bateau(String marque, int releaseYear) {
        this.marque = marque;
        this.releaseYear = releaseYear;
    }

    public Bateau() {

    }

    public void setCoque(Coque coque) {
        this.coque = coque;
    }
    public Coque getCoque() {
        return this.coque;
    }

    public void setPont(Pont pont) {
        this.pont = pont;
    }
    public Pont getPont() {
        return this.pont;
    }

    public void setCabine(Cabine cabine) {
        this.cabine = cabine;
    }
    public Cabine getCabine() {
        return this.cabine;
    }

    public String toString() {
        return "Le bateau n°" + this.ID + " est constitué de:";
    }
}
