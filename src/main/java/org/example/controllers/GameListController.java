package org.example.controllers;

import org.example.dto.GameListDTO;
import org.example.dto.GameMinDTO;
import org.example.servicies.GameListService;
import org.example.servicies.GameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/lists")
public class GameListController {

    @Autowired
    private GameListService gameListService;
    @Autowired
    private GameService gameService;

    @GetMapping
    public ResponseEntity<List<GameListDTO>> findAll() {
        List<GameListDTO> list = gameListService.findAll();
        return ResponseEntity.ok().body(list);
    }

    @GetMapping(value = "/{id}/games")
    public ResponseEntity<List<GameMinDTO>> findByList(@PathVariable Long id) {
        List<GameMinDTO> list = gameService.findByList(id);
        return ResponseEntity.ok().body(list);
    }

}
