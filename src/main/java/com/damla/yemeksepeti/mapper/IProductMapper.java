package com.damla.yemeksepeti.mapper;

import com.damla.yemeksepeti.dto.request.SaveProductRequestDto;
import com.damla.yemeksepeti.dto.request.SaveRestaurantRequestDto;
import com.damla.yemeksepeti.repository.entity.Product;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface IProductMapper {

    IProductMapper INSTANCE = Mappers.getMapper(IProductMapper.class);

    Product fromSaveDto(SaveProductRequestDto dto);

}
