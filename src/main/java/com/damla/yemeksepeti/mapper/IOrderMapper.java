package com.damla.yemeksepeti.mapper;


import com.damla.yemeksepeti.dto.request.SaveOrderRequestDto;
import com.damla.yemeksepeti.repository.entity.Order;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface IOrderMapper {

    IOrderMapper INSTANCE = Mappers.getMapper(IOrderMapper.class);

    Order fromSaveDto(SaveOrderRequestDto dto);

}
