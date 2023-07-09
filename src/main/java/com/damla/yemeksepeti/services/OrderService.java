package com.damla.yemeksepeti.services;


import com.damla.yemeksepeti.dto.request.SaveOrderRequestDto;
import com.damla.yemeksepeti.mapper.IOrderMapper;
import com.damla.yemeksepeti.repository.IOrderRepository;
import com.damla.yemeksepeti.repository.entity.Order;
import com.damla.yemeksepeti.repository.entity.Product;
import com.damla.yemeksepeti.utility.ServiceManager;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OrderService extends ServiceManager<Order,Long> {
    private final IOrderRepository repository;

    public OrderService(IOrderRepository repository) {
        super(repository);
        this.repository = repository;
    }

    public Order createOrder(SaveOrderRequestDto dto, Product product){
        Order order = IOrderMapper.INSTANCE.fromSaveDto(dto);
        order.setRestaurantid(product.getRestaurantid());
        return (repository.save(order));
    }

    public List<Order> findByCustomerid(Long id) {
        return repository.findByCustomerid(id);
    }

}
