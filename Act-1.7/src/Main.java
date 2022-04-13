import java.util.ArrayList;

public class Main {
    public static ArrayList<Ours> oursGroup = new ArrayList<>();
    public static ArrayList<Lion> lionGroup = new ArrayList<>();


    public static void main(String[] args) {
        Lion lion1 = new Lion(true, "Beta", true);
        lion1.afficherCarac();
        Lion lion2 = new Lion(true, "Gama", false);
        lion2.afficherCarac();
        lionGroup.add(lion1);
        lionGroup.add(lion2);
        lion1.separer(lion1);
        lion2.chasser();
        lion2.courir();
        lion2.seNourrir();
        lion2.entendreSon("rugissement");
        lion2.seReproduire();
        lion2.son(3);


        Ours ours1 = new Ours(true, 7, true);
        Ours ours2 = new Ours(false, 11, false);
        oursGroup.add(ours1);
        oursGroup.add(ours2);
        ours1.afficherCarac();
        ours2.afficherCarac();
        ours1.hiverner(true);
        ours1.chasser();
        ours2.chasser();
        ours2.creuser();
        ours2.grimper();
        ours2.seNourrir();
        ours2.son(1);

    }
}
