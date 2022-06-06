package com.mrmarmitt.ca.core.candlestick.usecase;

import com.mrmarmitt.ca.core.candlestick.CandleStick;

import java.time.Instant;
import java.util.List;

public interface ListCandleStick {
    List<CandleStick> listBy(final Instant startTime, final Instant finalTime);
    List<CandleStick> listAll();

}
