package org.example.servicies;


import org.example.dto.GameDTO;
import org.example.dto.GameMinDTO;
import org.example.repositories.GameRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class GameService {

    @Autowired
    private GameRepository gameRepository;

    @Transactional(readOnly = true)
    public List<GameMinDTO> findAll() {
        return gameRepository.findAll().stream().map(x -> new GameMinDTO(x)).collect(Collectors.toList());
    }

    @Transactional(readOnly = true)
    public GameDTO findByID(Long id) {

        return new GameDTO(gameRepository.findById(id).get());
    }

    @Transactional(readOnly = true)
    public List<GameMinDTO> findByList(Long id) {
        return gameRepository.searchByList(id).stream().map(x -> new GameMinDTO(x)).collect(Collectors.toList());
    }

}
