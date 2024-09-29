package com.lvadm.currency.exchange.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import java.util.Map;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class ExchangeRatesDTO {

   private String base;
   private Map<String, Double> rates;

}
