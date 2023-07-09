package com.damla.yemeksepeti.controller;

import com.damla.yemeksepeti.dto.request.ActivateRequestDto;
import com.damla.yemeksepeti.dto.request.LoginRequestDto;
import com.damla.yemeksepeti.dto.request.RegisterRequestDto;
import com.damla.yemeksepeti.repository.entity.Customer;
import com.damla.yemeksepeti.services.CustomerService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static com.damla.yemeksepeti.constants.RestApiList.*;

@RestController
@RequestMapping(CUSTOMER)
@RequiredArgsConstructor
public class CustomerController {
    private final CustomerService customerService;

    @PostMapping(SAVE)
    public Customer register(@RequestBody @Valid RegisterRequestDto dto){
        return customerService.register(dto);
    }

    @PostMapping(LOGIN)
    public ResponseEntity<Boolean> login(@RequestBody LoginRequestDto dto){
        return ResponseEntity.ok(customerService.login(dto));
    }

    @PostMapping(ACTIVATESTATUS)
    public ResponseEntity<Boolean> activateStatus(@RequestBody ActivateRequestDto dto){
        return ResponseEntity.ok(customerService.activateStatus(dto));
    }

    @GetMapping(FINDALL)
    public List<Customer> findAll(){
        return customerService.findAll();
    }
}
