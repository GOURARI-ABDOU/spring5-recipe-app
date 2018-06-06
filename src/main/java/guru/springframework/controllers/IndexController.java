package guru.springframework.controllers;

import guru.springframework.entities.Category;
import guru.springframework.entities.UnitOfMesure;
import guru.springframework.repositories.CategoryRepository;
import guru.springframework.repositories.RecipeRepository;
import guru.springframework.repositories.UnitOfMesureRepository;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Optional;

@Controller
public class IndexController {
    private CategoryRepository categoryRepository;
    private UnitOfMesureRepository unitOfMesureRepository;

    public IndexController(CategoryRepository categoryRepository, UnitOfMesureRepository unitOfMesureRepository) {
        this.categoryRepository = categoryRepository;
        this.unitOfMesureRepository = unitOfMesureRepository;
    }

    @RequestMapping({"", "/", "/index"})
    public String getIndexPage(){
        Optional<UnitOfMesure> unit = this.unitOfMesureRepository.findByDescription("Gramme");
        Optional<Category> category = this.categoryRepository.findByCategoryName("Italien Food");
        System.out.println("Hi, this is the Categorie  "+ category.get());
        System.out.println("Hi, this is the Unit   "+ unit.get());
        return "index";
    }
}
