package guru.springframework.entities;

import javax.persistence.*;
import java.util.Set;

@Entity
public class Recipe {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String description;
    private Integer cookTime;
    private Integer prepTime;
    private Integer serving;
    @Lob
    private byte image[];

    @OneToOne(cascade = CascadeType.ALL)
    private Notes notes;

    @Enumerated(value = EnumType.STRING)
    private Dificulty dificulty;
    @OneToMany(mappedBy = "recipe", cascade = CascadeType.ALL)
    private Set<Ingrediant> ingrediants;
    @ManyToMany
    @JoinTable(name="RECIPE_CATEGORIES",
            joinColumns=@JoinColumn(name="RECIPE_ID"),
            inverseJoinColumns = @JoinColumn(name="CATEGORY_ID"))
    private Set<Category> categories;

    public Set<Ingrediant> getIngrediants() {
        return ingrediants;
    }

    public void setIngrediants(Set<Ingrediant> ingrediants) {
        this.ingrediants = ingrediants;
    }

    public Set<Category> getCategories() {
        return categories;
    }

    public void setCategories(Set<Category> categories) {
        this.categories = categories;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getCookTime() {
        return cookTime;
    }

    public void setCookTime(Integer cookTime) {
        this.cookTime = cookTime;
    }

    public Integer getPrepTime() {
        return prepTime;
    }

    public void setPrepTime(Integer prepTime) {
        this.prepTime = prepTime;
    }

    public Integer getServing() {
        return serving;
    }

    public void setServing(Integer serving) {
        this.serving = serving;
    }

    public byte[] getImage() {
        return image;
    }

    public void setImage(byte[] image) {
        this.image = image;
    }

    public Dificulty getDificulty() {
        return dificulty;
    }

    public void setDificulty(Dificulty dificulty) {
        this.dificulty = dificulty;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Notes getNotes() {
        return notes;
    }

    public void setNotes(Notes notes) {
        this.notes = notes;
    }
}
