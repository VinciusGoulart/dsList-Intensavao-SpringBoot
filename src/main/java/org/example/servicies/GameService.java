package org.example.servicies;

import org.example.dto.GameMinDTO;
import org.example.repositories.GameRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class GameService {

    @Autowired
    private GameRepository gameRepository;

    public List<GameMinDTO> findAll() {
       return gameRepository.findAll().stream().map(x -> new GameMinDTO(x)).collect(Collectors.toList());
    }

}
