package com.example.rps.controller;

import com.example.rps.model.GlobalStats;
import com.example.rps.model.RoundResult;
import com.example.rps.service.GameService;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
public class GameController {

    @Autowired
    private GameService gameService;

    @Autowired
    private GlobalStats globalStats;

    @GetMapping("/")
    public String game(Model model, HttpSession session) {
        @SuppressWarnings("unchecked")
        List<RoundResult> rounds = (List<RoundResult>) session.getAttribute("rounds");
        if (rounds == null) {
            rounds = new ArrayList<>();
            session.setAttribute("rounds", rounds);
        }
        model.addAttribute("rounds", rounds);
        model.addAttribute("roundCount", rounds.size());
        return "game";
    }

    @GetMapping("/play")
    public String playRound(HttpSession session) {
        @SuppressWarnings("unchecked")
        List<RoundResult> rounds = (List<RoundResult>) session.getAttribute("rounds");
        if (rounds == null) {
            rounds = new ArrayList<>();
            session.setAttribute("rounds", rounds);
        }

        RoundResult roundResult = gameService.playRound();
        rounds.add(roundResult);
        session.setAttribute("rounds", rounds);

        return "redirect:/";
    }

    @GetMapping("/restart")
    public String restartGame(HttpSession session) {
        session.removeAttribute("rounds");
        return "redirect:/";
    }

    @GetMapping("/stats")
    public String stats(Model model) {
        model.addAttribute("totalRoundsPlayed", globalStats.getTotalRoundsPlayed());
        model.addAttribute("totalWinsPlayer1", globalStats.getTotalWinsPlayer1());
        model.addAttribute("totalWinsPlayer2", globalStats.getTotalWinsPlayer2());
        model.addAttribute("totalDraws", globalStats.getTotalDraws());
        return "stats";
    }
}
