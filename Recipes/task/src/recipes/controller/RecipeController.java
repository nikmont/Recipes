package recipes.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import recipes.model.Recipe;
import recipes.service.RecipeService;

@RestController
public class RecipeController {

    RecipeService service;

    @Autowired
    public RecipeController(RecipeService service) {
        this.service = service;
    }

    @PostMapping("/api/recipe")
    public void addRecipe(@RequestBody Recipe recipe) {
        service.add(recipe);
    }

    @GetMapping("/api/recipe")
    public Recipe getRecipe() {
        return service.get();
    }

}
