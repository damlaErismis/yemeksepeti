package com.damla.yemeksepeti.controller;


import com.damla.yemeksepeti.repository.entity.Order;
import com.damla.yemeksepeti.services.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static com.damla.yemeksepeti.constants.RestApiList.*;

@RestController
@RequestMapping(ORDER)
@RequiredArgsConstructor
public class OrderController {
    private final OrderService orderService;

    @PostMapping(SAVE)
    public ResponseEntity<Order> createOrder(@RequestBody Order order) {
        return ResponseEntity.ok(orderService.save(order));
    }

    @GetMapping(FINDBYID)
    public ResponseEntity<List<Order>> findByCustomerid(Long id){
        return ResponseEntity.ok(orderService.findByCustomerid(id));
    }
}
