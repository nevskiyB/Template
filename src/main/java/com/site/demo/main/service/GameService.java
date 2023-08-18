package com.site.demo.main.service;

import com.site.demo.main.data.GameRepository;
import com.site.demo.main.model.Game;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class GameService {
    private final GameRepository repository;

    public Game getById(Long id) {
        return repository.findById(id).orElseThrow(() -> new EntityNotFoundException("Game with id:" + id + " not found"));
    }
}
