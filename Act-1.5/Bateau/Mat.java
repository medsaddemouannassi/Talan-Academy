public class Mat {
    public String material;
    public int quantity;
    final int ID = 5;
    public Voile voile;

    public Mat(String material, int quantity, Voile voile) {
        this.material = material;
        this.quantity = quantity;
        this.voile = voile;
    }

    public Mat() {

    }

    public String toString() {
        return "Le mât n°" + this.ID;
    }
}
