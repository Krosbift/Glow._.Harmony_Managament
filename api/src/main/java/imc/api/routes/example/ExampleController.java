package imc.api.routes.example;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import imc.api.routes.example.models.ExampleModel;

@RestController
@RequestMapping("/example")
public class ExampleController {

  @Autowired
  private ExampleService exampleService;

  @GetMapping
  public List<ExampleModel> findExample(@RequestParam Long idExample) {
    return exampleService.findExample(idExample);
  }

  @PostMapping
  public ExampleModel createExample(@RequestBody ExampleModel user) {
    return exampleService.createExample(user);
  }

  @PatchMapping("/{id}")
  public ExampleModel updateExample(@RequestBody ExampleModel user, @PathVariable Long id) {
    return exampleService.updateExample(user, id);
  }

  @DeleteMapping("/{id}")
  public Long deleteExample(@PathVariable Long id) {
    return exampleService.deleteExample(id);
  }
  
}