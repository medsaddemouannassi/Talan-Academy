import java.util.*;

public class LivreRecette extends Livre {
    ArrayList<Recette> recettes = new ArrayList<>();
    public LivreRecette(String titre, String auteur, float prix, int pages) {
        super(titre, auteur, prix, pages);
    }

    public void addRecette(Recette recette) {
        recettes.add(recette);
    }
}
