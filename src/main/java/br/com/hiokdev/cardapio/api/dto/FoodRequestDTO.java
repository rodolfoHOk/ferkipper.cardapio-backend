package br.com.hiokdev.cardapio.api.dto;

import br.com.hiokdev.cardapio.domain.model.Food;

public record FoodRequestDTO(
  String title,
  String image,
  Integer price
) {

  public static Food toEntity(FoodRequestDTO dto) {
    return new Food(null, dto.title(), dto.image(), dto.price());
  }

}
