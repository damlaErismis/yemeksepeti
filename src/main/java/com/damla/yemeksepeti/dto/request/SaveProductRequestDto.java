package com.damla.yemeksepeti.dto.request;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class SaveProductRequestDto {
    Long restaurantid;
    @NotEmpty(message = "İsim boş geçilemez")
    String name;
    String category;
    @NotNull(message = "Fiyat boş geçilemez")
    Double cost;
}
