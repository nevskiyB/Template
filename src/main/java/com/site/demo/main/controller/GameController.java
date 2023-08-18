package com.site.demo.main.controller;

import com.site.demo.main.model.Game;
import com.site.demo.main.service.GameService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@RequiredArgsConstructor
@Controller()
@RequestMapping("/game")
public class GameController {
    private final GameService service;

    @GetMapping("/view/{id}")
    public String getGameView(@PathVariable Long id, Model model) {
        Game game = service.getById(id);
        model.addAttribute("name", game.getName());
        model.addAttribute("description", game.getDescription());
        //model.addAttribute("titleImagePath", game.getTitleImagePath());
        return "game";
    }
}
