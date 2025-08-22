package br.com.api.gamelist.services;

import br.com.api.gamelist.dto.GameMinDTO;
import br.com.api.gamelist.entities.Game;
import br.com.api.gamelist.repositories.GameRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GameService {
    @Autowired
    private GameRepository gameRepository;

    public List<GameMinDTO> findAll() {
        List<Game> result = gameRepository.findAll();
        List<GameMinDTO> dto = result.stream().map(GameMinDTO::new).toList();
       // List<GameMinDTO> dto2 = result.stream().map(x -> new GameMinDTO(x)).toList();
        return dto;
    }
}
