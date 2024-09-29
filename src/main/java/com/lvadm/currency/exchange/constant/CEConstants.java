package com.lvadm.currency.exchange.constant;

public enum CEConstants {

    EXCHANGE_RATES_DATA("exchangerates_data"),
    LATEST("latest"),
    CONVERT("convert"),
    SLASH("/"),
    QUESTION_MARK("?"),
    AMPERSAND("&"),
    API_KEY("apikey"),
    EQUALS("="),
    BASE("base"),
    SYMBOLS("symbols"),
    TOP_THREE_CURRENCIES("GBP,USD,CHF"),
    FROM("from"),
    TO("to"),
    AMOUNT("amount");
    private final String value;

    CEConstants(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    @Override
    public String toString() {
        return value;
    }

}
