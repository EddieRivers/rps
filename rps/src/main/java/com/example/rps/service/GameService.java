package com.example.rps.service;

import com.example.rps.model.GlobalStats;
import com.example.rps.model.Move;
import com.example.rps.model.RoundResult;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GameService {

    @Autowired
    private GlobalStats globalStats;

    public RoundResult playRound() {
        Move player1Move = Move.getRandomMove();
        Move player2Move = Move.ROCK;

        String result = determineWinner(player1Move, player2Move);

        // Update Global Statistics
        globalStats.incrementTotalRoundsPlayed();
        switch (result) {
            case "Draw":
                globalStats.incrementTotalDraws();
                break;
            case "Player 1 Wins":
                globalStats.incrementTotalWinsPlayer1();
                break;
            case "Player 2 Wins":
                globalStats.incrementTotalWinsPlayer2();
                break;
        }

        return new RoundResult(player1Move, player2Move, result);
    }

    public void setGlobalStats(GlobalStats globalStats) {
        this.globalStats = globalStats;
    }

    public String determineWinner(Move player1Move, Move player2Move) {
        if (player1Move == player2Move) {
            return "Draw";
        } else if ((player1Move == Move.ROCK && player2Move == Move.SCISSORS) ||
                (player1Move == Move.PAPER && player2Move == Move.ROCK) ||
                (player1Move == Move.SCISSORS && player2Move == Move.PAPER)) {
            return "Player 1 Wins";
        } else {
            return "Player 2 Wins";
        }
    }
}
