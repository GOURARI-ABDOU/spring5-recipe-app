package guru.springframework.services;

import guru.springframework.entities.*;
import guru.springframework.repositories.CategoryRepository;
import guru.springframework.repositories.RecipeRepository;
import guru.springframework.repositories.UnitOfMesureRepository;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

@Component
public class RecipeBootstrap implements ApplicationListener<ContextRefreshedEvent>{
    private RecipeRepository recipeRepository;
    private CategoryRepository categoryRepository;
    private UnitOfMesureRepository unitOfMesureRepository;

    public RecipeBootstrap(RecipeRepository recipeRepository, CategoryRepository categoryRepository, UnitOfMesureRepository unitOfMesureRepository) {
        this.recipeRepository = recipeRepository;
        this.categoryRepository = categoryRepository;
        this.unitOfMesureRepository = unitOfMesureRepository;
    }

    private Set<Recipe> getRecipes(){

        // Unitéss de mesures
        Optional<UnitOfMesure> unitGramme = this.unitOfMesureRepository.findByDescription("Gramme");
        Optional<UnitOfMesure> unitCuillière = this.unitOfMesureRepository.findByDescription("cuillière");

        // categories
        Optional<Category> categoryItalien = this.categoryRepository.findByCategoryName("Italien Food");
        Optional<Category> marroccanCategory = this.categoryRepository.findByCategoryName("Morrcan Food");

        // Ingrédients
        Ingrediant ingrediant1 = new Ingrediant("Touma", "4");
        Ingrediant ingrediant2 = new Ingrediant("tfaya", "50");
        Ingrediant ingrediant3 = new Ingrediant("Lham", "2");

        // Notes
        Notes notes = new Notes();
        notes.setDescription("Had la note rah rir pour le test a akhoya :P");

        Recipe recipeCouscouss = new Recipe();
        recipeCouscouss.setCookTime(22);
        recipeCouscouss.setDescription("Khassek bzf, men lftil hta ltfwar! à mon avis je ne sais plus, dakchi dyal malaih" +
                "ma3zizch 3lia couscouss bzaf :P ");
        recipeCouscouss.setDificulty(Dificulty.HIGHT);
        recipeCouscouss.setPrepTime(44);
        Set<Category> categories = new HashSet<>();
        Set<Recipe> recipes = new HashSet<>();
        Set<Ingrediant> ingrediantsCoussCouss = new HashSet<>();


        ingrediantsCoussCouss.add(ingrediant1);
        ingrediant1.setRecipe(recipeCouscouss);
        ingrediantsCoussCouss.add(ingrediant2);
        ingrediant2.setRecipe(recipeCouscouss);
        ingrediantsCoussCouss.add(ingrediant3);
        ingrediant3.setRecipe(recipeCouscouss);
        recipeCouscouss.setIngrediants(ingrediantsCoussCouss);


        recipeCouscouss.setNotes(notes);

        recipes.add(recipeCouscouss);
        categories.add(marroccanCategory.get());
        notes.setRecipe(recipeCouscouss);
        recipeCouscouss.setCategories(categories);

        marroccanCategory.get().setRecipes(recipes);


        return recipes;
    }

    @Override
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
        recipeRepository.saveAll(getRecipes());
    }
}
