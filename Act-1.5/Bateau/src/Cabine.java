public class Cabine {
    public String type;
    public String material;
    private int id;

    public Cabine(String type, String material) {
        this.type = type;
        this.material = material;
    }

    public Cabine() {

    }

    public int getId() {
        return this.id;
    }
    public void setId(int id){
        this.id = id;
    }

    public String toString() {
        return "La cabine n°" + this.getId();
    }
}
