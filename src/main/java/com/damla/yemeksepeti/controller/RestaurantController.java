package com.damla.yemeksepeti.controller;

import com.damla.yemeksepeti.dto.request.SaveRestaurantRequestDto;
import com.damla.yemeksepeti.repository.entity.Product;
import com.damla.yemeksepeti.repository.entity.Restaurant;
import com.damla.yemeksepeti.services.RestaurantService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static com.damla.yemeksepeti.constants.RestApiList.*;

@RestController
@RequestMapping(RESTAURANT)
@RequiredArgsConstructor
public class RestaurantController {

    private final RestaurantService restaurantService;

    @PostMapping(SAVE)
    public Restaurant save(@RequestBody @Valid SaveRestaurantRequestDto dto){
        return restaurantService.save(dto);
    }

    @GetMapping(FINDALLPRODUCT)
    public ResponseEntity<List<Product>> findAllProduct(Long restaurantId) {
        return ResponseEntity.ok(restaurantService.findAllProduct(restaurantId));
    }

}

