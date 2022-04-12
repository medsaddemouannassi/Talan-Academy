public class Lion extends Prédateur implements LionAction {
    private boolean dominant;
    private String rangDomination;
    private int impétuosité;


    @Override
    public void chasser(Prédateur prédateur) {
        if (this.isSeul()) {
            System.out.println("Ce n'est pas possible de chasser seul");
        } else {
            System.out.println("Bonne chasse!");
        }
    }

    @Override
    public String afficherCarac() {
        return null;
    }

    @Override
    public void grimper() {

    }

    @Override
    public void creuser() {

    }

    @Override
    public void son() {
            System.out.println("Rugissement!!!");
    }

    @Override
    public void entendreSon() {

    }

    @Override
    public void separer() {

    }

    @Override
    public void seNourrir() {
            System.out.println("La viance, c'est un délice!");
    }


}
