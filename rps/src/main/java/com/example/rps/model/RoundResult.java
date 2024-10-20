package com.example.rps.model;

public class RoundResult {
    private Move player1Move;
    private Move player2Move;
    private String result;

    public RoundResult(Move player1Move, Move player2Move, String result) {
        this.player1Move = player1Move;
        this.player2Move = player2Move;
        this.result = result;
    }

    public Move getPlayer1Move() {
        return player1Move;
    }

    public void setPlayer1Move(Move player1Move) {
        this.player1Move = player1Move;
    }

    public Move getPlayer2Move() {
        return player2Move;
    }

    public void setPlayer2Move(Move player2Move) {
        this.player2Move = player2Move;
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }
}
