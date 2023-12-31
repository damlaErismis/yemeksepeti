package com.damla.yemeksepeti.repository;

import com.damla.yemeksepeti.repository.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface IProductRepository extends JpaRepository<Product,Long> {

    Optional<Product> findByNameIgnoreCase(String name);

    List<Product> findAllByRestaurantid(Long restaurantid);

}
