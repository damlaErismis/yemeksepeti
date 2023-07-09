package com.damla.yemeksepeti.dto.request;

import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class SaveRestaurantRequestDto {
    String name;
    @NotEmpty(message = "Adres boş geçilemez")
    String address;
}
