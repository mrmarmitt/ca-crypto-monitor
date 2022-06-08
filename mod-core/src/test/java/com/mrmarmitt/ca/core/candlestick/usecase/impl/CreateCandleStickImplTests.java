package com.mrmarmitt.ca.core.candlestick.usecase.impl;

import com.mrmarmitt.ca.core.candlestick.CandleStick;
import com.mrmarmitt.ca.core.candlestick.port.CandleStickRepositoryService;
import com.mrmarmitt.ca.core.candlestick.utils.BDValue;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.internal.verification.Times;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.Instant;
import java.util.List;
import java.util.Optional;

import static org.mockito.ArgumentMatchers.any;

@ExtendWith(MockitoExtension.class)
public class CreateCandleStickImplTests {

    @Mock
    private CandleStickRepositoryService candleStickRepositoryService;

    @InjectMocks
    private CreateCandleStickImpl createCandleStick;

    @Test
    public void should_save_candle() {
        CandleStick candleStick = new CandleStick(BDValue.TEN, BDValue.FIVE, BDValue.TEN, BDValue.THREE);

        Mockito.when(candleStickRepositoryService.save(any())).thenReturn(candleStick);

        Assertions.assertDoesNotThrow(() -> createCandleStick.create(candleStick));
        Mockito.verify(candleStickRepositoryService, Mockito.times(1)).save(any());
    }

    @Test
    public void should_not_save_null_candle() {
        Assertions.assertThrows(NullPointerException.class, () -> createCandleStick.create(null));
    }
}
