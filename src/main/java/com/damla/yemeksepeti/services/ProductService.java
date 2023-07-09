package com.damla.yemeksepeti.services;

import com.damla.yemeksepeti.dto.request.SaveProductRequestDto;
import com.damla.yemeksepeti.dto.request.SaveRestaurantRequestDto;
import com.damla.yemeksepeti.mapper.IProductMapper;
import com.damla.yemeksepeti.repository.IProductRepository;
import com.damla.yemeksepeti.repository.entity.Product;
import com.damla.yemeksepeti.utility.ServiceManager;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService extends ServiceManager<Product, Long> {
    private final IProductRepository repository;

    public ProductService(IProductRepository repository) {
        super(repository);
        this.repository = repository;
    }

    public Product save(SaveProductRequestDto dto){
        Optional<Product> product= repository.findByNameIgnoreCase(dto.getName());
        if (product.isPresent()){
            throw new RuntimeException("Böyle bir ürün zaten bulunmaktadır!");
        }
        return save(IProductMapper.INSTANCE.fromSaveDto(dto));
    }

    public List<Product> findAllByRestaurantid(Long restaurantid) {
        return repository.findAllByRestaurantid(restaurantid);
    }
}
