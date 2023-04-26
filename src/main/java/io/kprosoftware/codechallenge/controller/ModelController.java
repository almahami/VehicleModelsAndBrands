package io.kprosoftware.codechallenge.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import io.kprosoftware.codechallenge.entity.Model;
import io.kprosoftware.codechallenge.service.ModelService;

@RestController
public class ModelController {
  @Autowired
  private ModelService modelService;

  @GetMapping("/Models")
  public ResponseEntity<List<Model>> getModels() {
    return modelService.getModels();
  }

  @GetMapping("/Model{id}")
  public ResponseEntity<Model> getModelById(@PathVariable Long id) {
    return modelService.getModelById(id);
  }

  @GetMapping("vehicleBrands/{vehicleBrandId}/model")
  public ResponseEntity<List<Model>> getAllModelsByvehicleBrandId(
      @PathVariable(value = "vehicleBrandId") Long vehicleBrandId) {

    return modelService.getAllModelsByvehicleBrandId(vehicleBrandId);
  }

  @PostMapping("vehicleBrands/{vehicleBrandId}/model")
  public ResponseEntity<Model> addModel(@PathVariable Long vehicleBrandId, @RequestBody Model model) {
    return modelService.addModel(vehicleBrandId, model);
  }

  @PutMapping("/Model/{id}")
  public ResponseEntity<Model> UpdateModel(@PathVariable Long id, @RequestBody Model model) {
    return modelService.UpdateModel(model, id);
  }

  @DeleteMapping("/Model/{id}")
  public ResponseEntity<HttpStatus> deleteModelById(@PathVariable Long id) {
    return modelService.deleteModelById(id);
  }

  @DeleteMapping("/Models")
  public ResponseEntity<HttpStatus> deleteModels() {
    return modelService.deleteALLModels();
  }
}
