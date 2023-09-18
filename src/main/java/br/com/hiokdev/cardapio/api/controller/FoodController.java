package br.com.hiokdev.cardapio.api.controller;

import br.com.hiokdev.cardapio.api.dto.FoodRequestDTO;
import br.com.hiokdev.cardapio.api.dto.FoodResponseDTO;
import br.com.hiokdev.cardapio.domain.model.Food;
import br.com.hiokdev.cardapio.domain.repository.FoodRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("foods")
public class FoodController {

  private final FoodRepository foodRepository;

  @Autowired
  public FoodController(FoodRepository foodRepository) {
    this.foodRepository = foodRepository;
  }

  @CrossOrigin(origins = "*", allowedHeaders = "*")
  @GetMapping
  public List<FoodResponseDTO> list() {
    return foodRepository.findAll()
      .stream()
      .map(FoodResponseDTO::new)
      .toList();
  }

  @CrossOrigin(origins = "*", allowedHeaders = "*")
  @PostMapping
  public void create(@RequestBody FoodRequestDTO body) {
    Food newFood = FoodRequestDTO.toEntity(body);
    foodRepository.save(newFood);
  }

}
