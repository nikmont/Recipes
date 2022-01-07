package recipes.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import recipes.Exception.RecipeNotFoundException;
import recipes.model.Recipe;

import java.util.ArrayList;
import java.util.List;

@Service
public class RecipeService {

    private List<Recipe> recipes;

    {
        recipes = new ArrayList<>();
    }

    public int add(Recipe recipe) {
        recipes.add(recipe);

        System.out.println(recipe.toString());

        return recipes.size();
    }

    public Recipe get(int id) {

        if (id > recipes.size() | id <= 0 ) {
            throw new RecipeNotFoundException("");
        }

        return recipes.get(id - 1);
    }

}
