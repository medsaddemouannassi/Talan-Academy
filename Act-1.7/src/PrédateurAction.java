import java.util.ArrayList;

public interface PrédateurAction {
    public void seNourrir();
    public void chasser(ArrayList groupe);
    public void courir();
    public void seReproduire();
    public String son(int type);
}
