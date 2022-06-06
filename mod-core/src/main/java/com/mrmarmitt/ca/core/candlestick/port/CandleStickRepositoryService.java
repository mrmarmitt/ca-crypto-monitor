package com.mrmarmitt.ca.core.candlestick.port;


import com.mrmarmitt.ca.core.candlestick.CandleStick;

import java.time.Instant;
import java.util.List;
import java.util.Optional;

public interface CandleStickRepositoryService {
    CandleStick save(final CandleStick candleStick);
    Optional<List<CandleStick>> getCandleStickByMoment(final Instant startTime, final Instant finalTime);
    List<CandleStick> getAllCandleStick();
}
