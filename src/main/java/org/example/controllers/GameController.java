package org.example.controllers;

import jakarta.transaction.Transactional;
import org.example.dto.GameMinDTO;
import org.example.servicies.GameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/games")
public class GameController {

    @Autowired
    private GameService gameService;

    @GetMapping
    @Transactional
    public ResponseEntity<List<GameMinDTO>> findAll() {
        List<GameMinDTO> list = gameService.findAll();

        return ResponseEntity.ok().body(list);
    }
}
