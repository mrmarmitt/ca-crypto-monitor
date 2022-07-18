package com.mrmarmitt.ca.core.candlestick;

import com.mrmarmitt.ca.core.candlestick.utils.BDValue;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class CandleStickTests {

    @Test
    public void should_not_create_null_params_candle(){
        Assertions.assertThrows(AssertionError.class, () -> new CandleStick(null, BDValue.FIVE, BDValue.ELEVEN, BDValue.THREE));
        Assertions.assertThrows(AssertionError.class, () -> new CandleStick(BDValue.TEN, null, BDValue.ELEVEN, BDValue.THREE));
        Assertions.assertThrows(AssertionError.class, () -> new CandleStick(BDValue.TEN, BDValue.FIVE, null, BDValue.THREE));
        Assertions.assertThrows(AssertionError.class, () -> new CandleStick(BDValue.TEN, BDValue.FIVE, BDValue.ELEVEN, null));
    }

    @Test
    public void should_create_candle_with_realBody_and_shadows(){
        Assertions.assertDoesNotThrow(() -> new CandleStick(BDValue.TEN, BDValue.FIVE, BDValue.ELEVEN, BDValue.THREE));
    }

    @Test
    public void should_create_candle_with_realBody_and_no_shadows(){
        Assertions.assertDoesNotThrow(() -> new CandleStick(BDValue.TEN, BDValue.FIVE, BDValue.TEN, BDValue.FIVE));
    }

    @Test
    public void should_create_candle_with_realBody_and_high_shadow(){
        Assertions.assertDoesNotThrow(() -> new CandleStick(BDValue.TEN, BDValue.FIVE, BDValue.ELEVEN, BDValue.FIVE));
    }

    @Test
    public void should_create_candle_with_realBody_and_low_shadow(){
        Assertions.assertDoesNotThrow(() -> new CandleStick(BDValue.TEN, BDValue.FIVE, BDValue.TEN, BDValue.THREE));
    }

    @Test
    public void should_not_create_candle_with_realBody_and_internal_high_shadows(){
        Assertions.assertThrows(AssertionError.class, () -> new CandleStick(BDValue.TEN, BDValue.FIVE, BDValue.NINE, BDValue.THREE));
    }

    @Test
    public void should_not_create_candle_with_realBody_and_internal_low_shadows(){
        Assertions.assertThrows(AssertionError.class, () -> new CandleStick(BDValue.TEN, BDValue.FIVE, BDValue.ELEVEN, BDValue.SIX));
    }
}
