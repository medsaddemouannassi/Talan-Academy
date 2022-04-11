public class Coque {
    public String type;
    public String material;
    final int ID = 2;

    public Coque(String type, String material) {
        this.type = type;
        this.material = material;
    }

    public Coque() {

    }


    public String toString() {
        return "La coque n°" + this.ID;
    }
}
