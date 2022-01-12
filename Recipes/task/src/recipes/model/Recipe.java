package recipes.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.time.LocalDateTime;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "Recipe")
public class Recipe {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @JsonIgnore
    private Long id;

    @NotBlank(message = "Category is mandatory")
    private String category;

    @UpdateTimestamp
    private LocalDateTime date;

    @NotBlank(message = "Name is mandatory")
    private String name;

    @NotBlank(message = "Description is mandatory")
    private String description;

    @ElementCollection
    @NotEmpty(message = "Recipes without ingredients are frustrating")
    @Size(min = 1, message = "Minimal ingredients number is 1")
    private List <String> ingredients;

    @ElementCollection
    @NotEmpty(message = "Recipes without directions are frustrating")
    @Size(min = 1, message = "Minimal directions number is 1")
    private List <String> directions;
}
