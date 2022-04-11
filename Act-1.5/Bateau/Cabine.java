public class Cabine {
    public String type;
    public String material;
    final int ID = 3;

    public Cabine(String type, String material) {
        this.type = type;
        this.material = material;
    }

    public Cabine() {

    }

    public String toString() {
        return "La cabine n°" + this.ID;
    }
}
