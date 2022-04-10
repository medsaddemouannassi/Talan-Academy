public class Mat {
    public String material;
    public int quantity;
    private int id;
    public Voile voile;

    public Mat(String material, int quantity, Voile voile) {
        this.material = material;
        this.quantity = quantity;
        this.voile = voile;
    }

    public Mat() {

    }

    public int getId() {
        return this.id;
    }
    public void setId(int id){
        this.id = id;
    }

    public String toString() {
        return "Le mât n°" + this.getId();
    }
}
