public class Voile {
    private String color;
    private String type;
    private boolean roule;
    public String material; 
    protected int releaseDate;
    final int ID = 6;


    public Voile(String material, int releaseDate) {
        this.material = material;
        this.releaseDate = releaseDate;
    }

    public Voile() {

    }

    public String getColour() {
        return this.color;
    }
    public void setColour(String color) {
        this.color = color;
    }

    public String getType() {
        return this.type;
    }
    public void setType(String type) {
        this.type = type;
    }

    public Boolean enrouler(boolean enroule) {
        this.roule = (enroule == true) ? true : false;
        return this.roule;
    }

    public Boolean derouler(boolean deroule) {
        this.roule = (deroule == true) ? false : true;
        return this.roule;
    }

    public String toString() {
        return "La voile n°" + this.ID;
    }
}
