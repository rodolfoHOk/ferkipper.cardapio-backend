package br.com.hiokdev.cardapio.api.dto;

import br.com.hiokdev.cardapio.domain.model.Food;

public record FoodResponseDTO(
  Long id,
  String title,
  String image,
  Integer price
) {

  public FoodResponseDTO(Food food) {
    this(food.getId(), food.getTitle(), food.getImage(), food.getPrice());
  }

}
