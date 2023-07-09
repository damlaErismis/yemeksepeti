package com.damla.yemeksepeti.controller;

import com.damla.yemeksepeti.dto.request.SaveProductRequestDto;
import com.damla.yemeksepeti.repository.entity.Product;
import com.damla.yemeksepeti.services.ProductService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import static com.damla.yemeksepeti.constants.RestApiList.*;

@RestController
@RequestMapping(PRODUCT)
@RequiredArgsConstructor
public class ProductController {
    private final ProductService productService;

    @PostMapping(SAVE)
    public ResponseEntity<Product> save (@RequestBody @Valid SaveProductRequestDto dto){
        return ResponseEntity.ok(productService.save(dto));
    }
}
