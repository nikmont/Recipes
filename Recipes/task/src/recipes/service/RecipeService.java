package recipes.service;

import org.springframework.stereotype.Service;
import recipes.model.Recipe;

@Service
public class RecipeService {
    private Recipe recipe;

    public void add(Recipe recipe) {
        this.recipe = recipe;
    }

    public Recipe get() {
        return this.recipe;
    }

}
