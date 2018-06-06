package guru.springframework.entities;

import javax.persistence.*;

@Entity
public class Ingrediant {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private String quantite;
    @ManyToOne
    private Recipe recipe;

    public Ingrediant(String name, String quantite) {
        this.name = name;
        this.quantite = quantite;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getQuantite() {
        return quantite;
    }

    public void setQuantite(String quantite) {
        this.quantite = quantite;
    }

    public Recipe getRecipe() {
        return recipe;
    }

    public void setRecipe(Recipe recipe) {
        this.recipe = recipe;
    }
}
