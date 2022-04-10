public class Pont {
    public String type;
    public String material;
    private int id;
    public Mat mat;

    public Pont(String type, String material, Mat mat) {
        this.type = type;
        this.material = material;
        this.mat = mat;
    }

    public Pont() {

    }

    public int getId() {
        return this.id;
    }
    public void setId(int id){
        this.id = id;
    }

    public String toString() {
        return "Le pont n°" + this.getId() + " est constitué du mât n°" + this.mat.getId() + " qui est constitué de la voile n°" + this.mat.voile.getId();
    }
}
