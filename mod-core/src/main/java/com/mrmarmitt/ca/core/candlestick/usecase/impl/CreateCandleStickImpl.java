package com.mrmarmitt.ca.core.candlestick.usecase.impl;

import com.mrmarmitt.ca.core.candlestick.CandleStick;
import com.mrmarmitt.ca.core.candlestick.port.CandleStickRepositoryService;
import com.mrmarmitt.ca.core.candlestick.usecase.CreateCandleStick;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class CreateCandleStickImpl implements CreateCandleStick {

    private final CandleStickRepositoryService candleStickRepositoryService;

    @Override
    public CandleStick create(final CandleStick candleStick) {
        candleStick.validateSelf();

        return candleStickRepositoryService.save(candleStick);
    }
}
