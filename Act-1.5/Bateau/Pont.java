public class Pont {
    public String type;
    public String material;
    final int ID = 4;
    public Mat mat;

    public Pont(String type, String material, Mat mat) {
        this.type = type;
        this.material = material;
        this.mat = mat;
    }

    public Pont() {

    }

    public String toString() {
        return "Le pont n°" + this.ID + " est constitué du mât n°" + this.mat.ID + " qui est constitué de la voile n°" + this.mat.voile.ID;
    }
}
