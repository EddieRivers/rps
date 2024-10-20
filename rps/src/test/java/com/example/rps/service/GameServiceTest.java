package com.example.rps.service;

import com.example.rps.model.GlobalStats;
import com.example.rps.model.Move;
import com.example.rps.model.RoundResult;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class GameServiceTest {

    private GameService gameService;
    private GlobalStats globalStats;

    @BeforeEach
    public void setUp() {
        globalStats = new GlobalStats();
        gameService = new GameService();
        gameService.setGlobalStats(globalStats);
    }

    @Test
    public void testDetermineWinner_Draw() {
        for (Move move : Move.values()) {
            String result = gameService.determineWinner(move, move);
            assertEquals("Draw", result, "When both players choose " + move + ", it must be a draw.");
        }
    }

    @Test
    public void testDetermineWinner_Player1Wins() {
        assertEquals("Player 1 Wins", gameService.determineWinner(Move.ROCK, Move.SCISSORS));
        assertEquals("Player 1 Wins", gameService.determineWinner(Move.PAPER, Move.ROCK));
        assertEquals("Player 1 Wins", gameService.determineWinner(Move.SCISSORS, Move.PAPER));
    }

    @Test
    public void testDetermineWinner_Player2Wins() {
        assertEquals("Player 2 Wins", gameService.determineWinner(Move.ROCK, Move.PAPER));
        assertEquals("Player 2 Wins", gameService.determineWinner(Move.PAPER, Move.SCISSORS));
        assertEquals("Player 2 Wins", gameService.determineWinner(Move.SCISSORS, Move.ROCK));
    }

    @Test
    public void testPlayRound_NotNull() {
        RoundResult result = gameService.playRound();
        assertNotNull(result);
    }

    @Test
    public void testPlayRound_ValidMoves() {
        RoundResult result = gameService.playRound();
        assertNotNull(result.getPlayer1Move());
        assertNotNull(result.getPlayer2Move());
    }

    @Test
    public void testPlayRound_ResultConsistent() {
        RoundResult result = gameService.playRound();
        String expectedResult = gameService.determineWinner(result.getPlayer1Move(), result.getPlayer2Move());
        assertEquals(expectedResult, result.getResult());
    }

    @Test
    public void testRandomMoveGeneration() {
        boolean rockFound = false;
        boolean paperFound = false;
        boolean scissorsFound = false;

        for (int i = 0; i < 100; i++) {
            Move move = Move.getRandomMove();
            if (move == Move.ROCK) rockFound = true;
            if (move == Move.PAPER) paperFound = true;
            if (move == Move.SCISSORS) scissorsFound = true;
            if (rockFound && paperFound && scissorsFound) break;
        }

        assertTrue(rockFound, "Move.getRandomMove() did not generate ROCK in 100 attempts.");
        assertTrue(paperFound, "Move.getRandomMove() did not generate PAPER in 100 attempts.");
        assertTrue(scissorsFound, "Move.getRandomMove() did not generate SCISSORS in 100 attempts.");
    }
}
