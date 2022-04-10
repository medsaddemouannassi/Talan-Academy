public class Coque {
    public String type;
    public String material;
    private int id;

    public Coque(String type, String material) {
        this.type = type;
        this.material = material;
    }

    public Coque() {

    }

    public int getId() {
        return this.id;
    }
    public void setId(int id){
        this.id = id;
    }

    public String toString() {
        return "La coque n°" + this.getId();
    }
}
