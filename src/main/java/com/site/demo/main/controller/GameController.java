package com.site.demo.main.controller;

import com.site.demo.main.model.Game;
import com.site.demo.main.service.GameService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

@RequiredArgsConstructor
@Controller
@RequestMapping("/game")
public class GameController {
    private final GameService service;

    @GetMapping("/{id}")
    public String getGameView(@PathVariable Long id, Model model) {
        Game game = service.getById(id);
        model.addAttribute("game", game);
        //model.addAttribute("titleImagePath", game.getTitleImagePath());
        return "game";
    }

    @GetMapping("/{id}/play")
    public String getPlayGame(@PathVariable Long id, Model model) {
        return "play-game.html";
    }

    @GetMapping("/all")
    public String getAllGames(Model model) {
        List<Game> game = service.getAll();
        model.addAttribute("games", game);
        return "list-games";
    }

    @GetMapping("/create")
    public String showCreateForm() {
        return "create-game";
    }

    @PostMapping("/create")
    public String createGame(@RequestParam String name,
                             @RequestParam String description,
                             @RequestParam("image") MultipartFile file,
                             Model model) throws IOException {
        Game game = new Game();
        game.setName(name);
        game.setDescription(description);

        StringBuilder fileNames = new StringBuilder();
        Path fileNameAndPath = Paths.get("", file.getOriginalFilename());
        fileNames.append(file.getOriginalFilename());
        Files.write(fileNameAndPath, file.getBytes());
        model.addAttribute("msg", "Uploaded images: " + fileNames.toString());
        //return "imageupload/index";

        service.create(game);
        return "redirect:/game/all";
    }
}
