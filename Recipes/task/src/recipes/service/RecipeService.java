package recipes.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import recipes.exception.RecipeNotFoundException;
import recipes.exception.WrongParamException;
import recipes.model.Recipe;
import recipes.repository.RecipeRepository;

import java.util.List;
import java.util.Map;

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

    public Recipe update(long id, Recipe recipe) {

    Recipe toUpdate = repository.findById(id).orElseThrow(() -> new RecipeNotFoundException(""));

    toUpdate.setName(recipe.getName());
    toUpdate.setCategory(recipe.getCategory());
    toUpdate.setDescription(recipe.getDescription());
    toUpdate.setIngredients(recipe.getIngredients());
    toUpdate.setDirections(recipe.getDirections());

        return repository.save(toUpdate);
    }

    public List<Recipe> search(Map<String, String> params) {

        List<Recipe> list;

        if (params.size() != 1) {
            throw new WrongParamException("");
        }

        if (!params.containsKey("name")) {
            if (!params.containsKey("category")) {
                throw new WrongParamException("");
            } else {
                list = repository.findByCategoryIgnoreCaseOrderByDateDesc(params.get("category"));
            }
        } else {
            list = repository.findByNameContainingIgnoreCaseOrderByDateDesc(params.get("name"));
        }

        return list;
    }
}
