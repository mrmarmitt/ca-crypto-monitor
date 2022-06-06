package com.mrmarmitt.ca.core.candlestick;

import lombok.Builder;
import lombok.Getter;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Objects;

@Getter
@Builder
public class CandleStick implements Serializable {

    private static final long serialVersionUID = 1799338984424231806L;

    private BigDecimal open;
    private BigDecimal close;
    private BigDecimal high;
    private BigDecimal low;

    public void validateSelf(){
        validateParameters();
        validateIntegrity();
    }

    private void validateParameters() {
        assert Objects.nonNull(open) : "Open values can not be null.";
        assert Objects.nonNull(close) : "Close values can not be null.";
        assert Objects.nonNull(high) : "High values can not be null.";
        assert Objects.nonNull(low) : "Low values can not be null.";
    }

    private void validateIntegrity() {
        assert high.doubleValue() >= Math.max(open.doubleValue(), close.doubleValue()) : "High value should be greater or equals then the max value between Open and Close value.";
        assert low.doubleValue() <= Math.min(open.doubleValue(), close.doubleValue()) : "Low value should be greater or equals then the min value between Open and Close value.";
    }
}
