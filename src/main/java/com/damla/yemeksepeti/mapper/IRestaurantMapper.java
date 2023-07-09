package com.damla.yemeksepeti.mapper;


import com.damla.yemeksepeti.dto.request.SaveRestaurantRequestDto;
import com.damla.yemeksepeti.repository.entity.Restaurant;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface IRestaurantMapper {

    IRestaurantMapper INSTANCE = Mappers.getMapper(IRestaurantMapper.class);

    Restaurant fromSaveDto(SaveRestaurantRequestDto dto);

}