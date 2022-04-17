import java.util.ArrayList;

public interface GroupePrédateursAction {
    public void afficherCarac();
    public void afficherCaracPredateurs();
    public void ajouterPredateur(ArrayList groupe, Prédateur prédateur);
    public void enleverPredateur(ArrayList groupe, Prédateur prédateur);
}
