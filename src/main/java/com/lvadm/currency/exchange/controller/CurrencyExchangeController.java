package com.lvadm.currency.exchange.controller;

import com.lvadm.currency.exchange.dto.ConvertAmountDTO;
import com.lvadm.currency.exchange.dto.ExchangeRatesDTO;
import com.lvadm.currency.exchange.service.CurrencyExchangeService;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CurrencyExchangeController {

    private final CurrencyExchangeService currencyExchangeService;

    public CurrencyExchangeController(CurrencyExchangeService currencyExchangeService) {
        this.currencyExchangeService = currencyExchangeService;
    }

    @GetMapping(value = "/public/currency/exchange/rates", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ExchangeRatesDTO> getExchangeRates(@RequestParam String base) {
        return ResponseEntity.ok(currencyExchangeService.getExchangeRates(base));
    }

    @GetMapping(value = "/protected/currency/exchange/convert", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ConvertAmountDTO> getConvertedAmount(@RequestParam String from, @RequestParam String to,
                                                             @RequestParam Double amount) {
        return ResponseEntity.ok(currencyExchangeService.getConvertedAmount(from, to, amount));
    }

}
