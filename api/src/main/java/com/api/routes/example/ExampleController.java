package com.api.routes.example;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.api.routes.example.models.ExampleModel;

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
  public List<ExampleModel> findExample(@RequestParam int idExample) {
    return exampleService.findExample(idExample);
  }

  @PostMapping
  @Operation(summary = "Create example", description = "Create a new example")
  public ExampleModel createExample(@RequestBody ExampleModel user) {
    return exampleService.createExample(user);
  }

  @PatchMapping("/{id}")
  @Operation(summary = "Update example", description = "Update an example by its ID")
  public ExampleModel updateExample(@RequestBody ExampleModel user, @PathVariable int id) {
    return exampleService.updateExample(user, id);
  }

  @DeleteMapping("/{id}")
  @Operation(summary = "Delete example", description = "Delete an example by its ID")
  public int deleteExample(@PathVariable int id) {
    return exampleService.deleteExample(id);
  }
  
}