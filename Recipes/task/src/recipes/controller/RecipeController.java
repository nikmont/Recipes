package recipes.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import recipes.model.Recipe;
import recipes.service.RecipeService;

import javax.validation.Valid;
import java.util.List;
import java.util.Map;

@RestController
public class RecipeController {

    RecipeService service;

    @Autowired
    public RecipeController(RecipeService service) {
        this.service = service;
    }

    @PostMapping("/api/recipe/new")
    public ResponseEntity addRecipe(@Valid @RequestBody Recipe recipe) {

        long newID = service.add(recipe).getId();

        return ResponseEntity
                .status(HttpStatus.OK)
                .body(Map.of("id", newID));
    }

    @ResponseStatus(code = HttpStatus.OK)
    @GetMapping("/api/recipe/{id}")
    public Recipe getRecipe(@PathVariable long id) {

        Recipe recipe = service.get(id);

        return recipe;
    }

    @ResponseStatus(code = HttpStatus.NO_CONTENT)
    @DeleteMapping("/api/recipe/{id}")
    public void deleteRecipe(@PathVariable long id) {
        service.delete(id);
    }

    @ResponseStatus(code = HttpStatus.OK)
    @GetMapping("/api/recipe/search")
    public List<Recipe> searchRecipes(@RequestParam Map<String,String> allParams) {

        List<Recipe> founded = service.search(allParams);

        return founded;
    }

    @ResponseStatus(code = HttpStatus.NO_CONTENT)
    @PutMapping("/api/recipe/{id}")
    public Recipe updateRecipe(@PathVariable long id, @Valid @RequestBody Recipe recipe) {

        Recipe updated = service.update(id, recipe);

        return updated;
    }
}
