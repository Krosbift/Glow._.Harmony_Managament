package imc.api.routes.example;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import imc.api.routes.example.models.ExampleModel;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@RequestMapping("/example")
@Tag(name = "Example", description = "Example routes")
public class ExampleController {

  @Autowired
  private ExampleService exampleService;

  @GetMapping
  @Operation(summary = "Find example", description = "Find an example by its ID")
  public List<ExampleModel> findExample(@RequestParam Long idExample) {
    return exampleService.findExample(idExample);
  }

  @PostMapping
  @Operation(summary = "Create example", description = "Create a new example")
  public ExampleModel createExample(@RequestBody ExampleModel user) {
    return exampleService.createExample(user);
  }

  @PatchMapping("/{id}")
  @Operation(summary = "Update example", description = "Update an example by its ID")
  public ExampleModel updateExample(@RequestBody ExampleModel user, @PathVariable Long id) {
    return exampleService.updateExample(user, id);
  }

  @DeleteMapping("/{id}")
  @Operation(summary = "Delete example", description = "Delete an example by its ID")
  public Long deleteExample(@PathVariable Long id) {
    return exampleService.deleteExample(id);
  }
  
}