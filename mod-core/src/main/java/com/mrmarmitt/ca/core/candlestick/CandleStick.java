package com.mrmarmitt.ca.core.candlestick;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Objects;

public class CandleStick implements Serializable {

    private static final long serialVersionUID = 1799338984424231806L;

    private BigDecimal open;
    private BigDecimal close;
    private BigDecimal high;
    private BigDecimal low;

    public CandleStick(final BigDecimal open, final BigDecimal close, final BigDecimal high, final BigDecimal low) {
        selfValidation(open, close, high, low);

        this.open = open;
        this.close = close;
        this.high = high;
        this.low = low;
    }

    private void selfValidation(final BigDecimal open, final BigDecimal close, final BigDecimal high, final BigDecimal low){
        validateParameters(open, close, high, low);
        validateIntegrity(open, close, high, low);
    }

    private void validateParameters(final BigDecimal open, final BigDecimal close, final BigDecimal high, final BigDecimal low) {
        assert Objects.nonNull(open) : "Open values can not be null.";
        assert Objects.nonNull(close) : "Close values can not be null.";
        assert Objects.nonNull(high) : "High values can not be null.";
        assert Objects.nonNull(low) : "Low values can not be null.";
    }

    private void validateIntegrity(final BigDecimal open, final BigDecimal close, final BigDecimal high, final BigDecimal low) {
        assert high.doubleValue() >= Math.max(open.doubleValue(), close.doubleValue()) : "High value should be greater or equals then the max value between Open and Close value.";
        assert low.doubleValue() <= Math.min(open.doubleValue(), close.doubleValue()) : "Low value should be greater or equals then the min value between Open and Close value.";
    }
}
