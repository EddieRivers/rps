package com.example.rps.model;

public enum Move {
    ROCK, PAPER, SCISSORS;

    public static Move getRandomMove() {
        return values()[(int) (Math.random() * values().length)];
    }
}
