package com.damla.yemeksepeti.mapper;

import com.damla.yemeksepeti.dto.request.RegisterRequestDto;
import com.damla.yemeksepeti.repository.entity.Customer;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface ICustomerMapper {

    ICustomerMapper INSTANCE = Mappers.getMapper(ICustomerMapper.class);

    Customer fromSaveDto(RegisterRequestDto dto);
}
