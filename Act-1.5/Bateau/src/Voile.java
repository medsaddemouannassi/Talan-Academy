public class Voile {
    private String color;
    private String type;
    private boolean roule;
    public String material; 
    protected int releaseDate;
    private int id;


    public Voile(String material, int releaseDate) {
        this.material = material;
        this.releaseDate = releaseDate;
    }

    public int getId() {
        return this.id;
    }
    public void setId(int id){
        this.id = id;
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

    public void enrouler(boolean enroule) {
        this.roule = (enroule == true) ? true : false;
    }
    public void derouler(boolean deroule) {
        this.roule = (deroule == true) ? false : true;
    }

    public String toString() {
        return "La voile n°" + this.getId();
    }
}
