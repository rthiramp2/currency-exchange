package com.lvadm.currency.exchange.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class ConvertAmountDTO {

    private Double result;

}
