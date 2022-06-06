package com.mrmarmitt.ca.core.candlestick.usecase.impl;

import com.mrmarmitt.ca.core.candlestick.CandleStick;
import com.mrmarmitt.ca.core.candlestick.port.CandleStickRepositoryService;
import com.mrmarmitt.ca.core.candlestick.usecase.ListCandleStick;
import lombok.RequiredArgsConstructor;

import java.time.Instant;
import java.util.List;

@RequiredArgsConstructor
public class ListCandleStickImpl implements ListCandleStick {

    private final CandleStickRepositoryService candleStickRepositoryService;

    @Override
    public List<CandleStick> listBy(Instant startTime, Instant finalTime) {
        //lançar exceção quando a lista estiver vazia
        return candleStickRepositoryService.getCandleStickByMoment(startTime, finalTime).orElse(List.of());
    }

    @Override
    public List<CandleStick> listAll() {
        return candleStickRepositoryService.getAllCandleStick();
    }
}
