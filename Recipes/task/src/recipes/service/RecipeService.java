package recipes.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import recipes.exception.RecipeNotFoundException;
import recipes.model.Recipe;
import recipes.repository.RecipeRepository;

@Service
public class RecipeService {

    private final RecipeRepository repository;

    @Autowired
    public RecipeService(RecipeRepository repository) {
        this.repository = repository;
    }

    public Recipe add(Recipe recipe) {
        return repository.save(recipe);
    }

    public Recipe get(Long id) {
        return repository.findById(id).orElseThrow(() -> new RecipeNotFoundException(""));
    }
    
    public void delete(Long id) {
        if (!repository.existsById(id)) {
            throw new RecipeNotFoundException("");
        }

        repository.deleteById(id);
    }

}
