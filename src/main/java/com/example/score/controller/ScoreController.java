package com.example.score.controller;

import com.example.score.dto.ScoreView;
import com.example.score.model.Score;
import com.example.score.service.ScoreService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/scores")
public class ScoreController {
    private final ScoreService scoreService;

    public ScoreController(ScoreService scoreService) {
        this.scoreService = scoreService;
    }

    @GetMapping
    public List<ScoreView> list() {
        return scoreService.findAllView();
    }

    @PostMapping
    public Score create(@Valid @RequestBody Score score) {
        return scoreService.create(score);
    }

    @PutMapping("/{id}")
    public void update(@PathVariable Long id, @Valid @RequestBody Score score) {
        scoreService.update(id, score);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        scoreService.delete(id);
    }
}
