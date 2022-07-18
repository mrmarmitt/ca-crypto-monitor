package com.mrmarmitt.ca.core.candlestick.usecase.impl;

import com.mrmarmitt.ca.core.candlestick.CandleStick;
import com.mrmarmitt.ca.core.candlestick.port.CandleStickRepositoryService;
import com.mrmarmitt.ca.core.candlestick.usecase.CreateCandleStick;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class CreateCandleStickImpl implements CreateCandleStick {

    private final CandleStickRepositoryService candleStickRepositoryService;

    @Override
    public CandleStick create(@NonNull final CandleStick candleStick) {
        return candleStickRepositoryService.save(candleStick);
    }
}
