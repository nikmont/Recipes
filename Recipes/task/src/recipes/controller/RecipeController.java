package recipes.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import recipes.Exception.RecipeNotFoundException;
import recipes.model.Recipe;
import recipes.service.RecipeService;

import java.util.Map;

@RestController
public class RecipeController {

    RecipeService service;

    @Autowired
    public RecipeController(RecipeService service) {
        this.service = service;
    }

    @PostMapping("/api/recipe/new")
    public ResponseEntity addRecipe(@RequestBody Recipe recipe) {

        return ResponseEntity
                .status(HttpStatus.OK)
                .body(Map.of("id", service.add(recipe)));
    }

    @GetMapping("/api/recipe/{id}")
    public ResponseEntity getRecipe(@PathVariable int id) {

        Recipe recipe = service.get(id);

        System.out.println("получили - " + recipe);

        return ResponseEntity
                .status(HttpStatus.OK)
                .body(recipe);
    }

}
