package com.lvadm.currency.exchange.service;

import com.lvadm.currency.exchange.constant.CEConstants;
import com.lvadm.currency.exchange.dto.ConvertAmountDTO;
import com.lvadm.currency.exchange.dto.ExchangeRatesDTO;
import com.lvadm.currency.exchange.repository.UserRepository;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class CurrencyExchangeService {

    private final String exUrl;
    private final String apiKey;
    private final ApiService apiService;
    private final UserRepository userRepository;

    public CurrencyExchangeService(@Value("${application.currency.exchange.url}") String exUrl,
                                   @Value("${application.currency.exchange.api.key}") String apiKey,
                                   ApiService apiService,
                                   UserRepository userRepository) {
        this.exUrl = exUrl;
        this.apiKey = apiKey;
        this.apiService = apiService;
        this.userRepository = userRepository;
    }


    public ExchangeRatesDTO getExchangeRates(String base) {
        String endPoint = this.getExchangeRatesURL(base);

        ResponseEntity<ExchangeRatesDTO> response = apiService.callApiEndpoint(endPoint, HttpMethod.GET, HttpHeaders.EMPTY,
                null, ExchangeRatesDTO.class);
        if (null != response && response.hasBody()) {
            return response.getBody();
        }
        return null;
    }

    public ConvertAmountDTO getConvertedAmount(String from, String to, Double amount) {
        String endPoint = this.getConvertAmountURL(from, to, amount);

        ResponseEntity<ConvertAmountDTO> response = apiService.callApiEndpoint(endPoint, HttpMethod.GET, HttpHeaders.EMPTY,
                null, ConvertAmountDTO.class);
        //System.out.println(userRepository.findAll());
        if (null != response && response.hasBody()) {
            return response.getBody();
        }
        return null;
    }

    private String getExchangeRatesURL(String base) {
        return new StringBuilder(exUrl)
                .append(CEConstants.EXCHANGE_RATES_DATA)
                .append(CEConstants.SLASH)
                .append(CEConstants.LATEST)
                .append(CEConstants.QUESTION_MARK)
                .append(CEConstants.API_KEY)
                .append(CEConstants.EQUALS)
                .append(apiKey)
                .append(CEConstants.AMPERSAND)
                .append(CEConstants.BASE)
                .append(CEConstants.EQUALS)
                .append(base)
                .append(CEConstants.AMPERSAND)
                .append(CEConstants.SYMBOLS)
                .append(CEConstants.EQUALS)
                .append(CEConstants.TOP_THREE_CURRENCIES).toString();
    }

    private String getConvertAmountURL(String from, String to, Double amount) {
        return new StringBuilder(exUrl)
                .append(CEConstants.EXCHANGE_RATES_DATA)
                .append(CEConstants.SLASH)
                .append(CEConstants.CONVERT)
                .append(CEConstants.QUESTION_MARK)
                .append(CEConstants.API_KEY)
                .append(CEConstants.EQUALS)
                .append(apiKey)
                .append(CEConstants.AMPERSAND)
                .append(CEConstants.FROM)
                .append(CEConstants.EQUALS)
                .append(from)
                .append(CEConstants.AMPERSAND)
                .append(CEConstants.TO)
                .append(CEConstants.EQUALS)
                .append(to)
                .append(CEConstants.AMPERSAND)
                .append(CEConstants.AMOUNT)
                .append(CEConstants.EQUALS)
                .append(amount).toString();
    }

}
