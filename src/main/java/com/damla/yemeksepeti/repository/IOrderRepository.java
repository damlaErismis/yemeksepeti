package com.damla.yemeksepeti.repository;

import com.damla.yemeksepeti.repository.entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IOrderRepository extends JpaRepository<Order,Long> {

    List<Order> findByCustomerid(Long id);
}
