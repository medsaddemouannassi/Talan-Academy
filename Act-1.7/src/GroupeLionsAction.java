import java.util.ArrayList;

public interface GroupeLionsAction {
    public void creationCouple(ArrayList<Lion> lionGroup, Lion lion1, Lion lion2);
    public void reproduction(String sexe, String categorieAge, int force, boolean dominant, String rangDomination, boolean impétuosité, ArrayList<Lion> lionGroup);
    public void lionNonDominant(ArrayList<Lion> lionGroup);
}
