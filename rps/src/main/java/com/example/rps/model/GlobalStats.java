package com.example.rps.model;

import org.springframework.stereotype.Component;

import java.util.concurrent.atomic.AtomicInteger;

@Component
public class GlobalStats {

    private final AtomicInteger totalRoundsPlayed = new AtomicInteger();
    private final AtomicInteger totalWinsPlayer1 = new AtomicInteger();
    private final AtomicInteger totalWinsPlayer2 = new AtomicInteger();
    private final AtomicInteger totalDraws = new AtomicInteger();

    public void incrementTotalRoundsPlayed() {
        totalRoundsPlayed.incrementAndGet();
    }

    public void incrementTotalWinsPlayer1() {
        totalWinsPlayer1.incrementAndGet();
    }

    public void incrementTotalWinsPlayer2() {
        totalWinsPlayer2.incrementAndGet();
    }

    public void incrementTotalDraws() {
        totalDraws.incrementAndGet();
    }

    public int getTotalRoundsPlayed() {
        return totalRoundsPlayed.get();
    }

    public int getTotalWinsPlayer1() {
        return totalWinsPlayer1.get();
    }

    public int getTotalWinsPlayer2() {
        return totalWinsPlayer2.get();
    }

    public int getTotalDraws() {
        return totalDraws.get();
    }
}
