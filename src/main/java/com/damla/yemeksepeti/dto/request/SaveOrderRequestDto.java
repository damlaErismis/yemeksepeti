package com.damla.yemeksepeti.dto.request;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class SaveOrderRequestDto {
    Long customerid;
    List<Long> productId;
}
