import java.util.ArrayList;

public interface GroupePrédateursAction {
    public void afficherCarac();
    public void afficherCaracPredateurs(ArrayList<Lion> lionGroup);
    public void ajouterPredateur(ArrayList groupe, Prédateur prédateur);
    public void enleverPredateur(ArrayList groupe, Prédateur prédateur);
}
