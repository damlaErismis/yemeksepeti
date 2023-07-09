package com.damla.yemeksepeti.services;

import com.damla.yemeksepeti.dto.request.SaveRestaurantRequestDto;
import com.damla.yemeksepeti.mapper.IRestaurantMapper;
import com.damla.yemeksepeti.repository.IRestaurantRepository;
import com.damla.yemeksepeti.repository.entity.Product;
import com.damla.yemeksepeti.repository.entity.Restaurant;
import com.damla.yemeksepeti.utility.ServiceManager;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class RestaurantService extends ServiceManager<Restaurant,Long> {
    private final IRestaurantRepository repository;
    private final ProductService productService;

    public RestaurantService(IRestaurantRepository repository, ProductService productService) {
        super(repository);
        this.repository = repository;
        this.productService = productService;
    }

    public Restaurant save(SaveRestaurantRequestDto dto){
        Restaurant restaurant = IRestaurantMapper.INSTANCE.fromSaveDto(dto);
        return repository.save(restaurant);
    }

    public List<Product> findAllProduct(Long restaurantid) {
        return productService.findAllByRestaurantid(restaurantid);
    }

}
