package br.com.api.gamelist.services;

import br.com.api.gamelist.dto.GameDTO;
import br.com.api.gamelist.dto.GameMinDTO;
import br.com.api.gamelist.entities.Game;
import br.com.api.gamelist.repositories.GameRepository;
import br.com.api.gamelist.repositories.projections.GameMinProjection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class GameService {
    @Autowired
    private GameRepository gameRepository;

    @Transactional(readOnly = true)
    public GameDTO findGameById(Long id) {
        var result = gameRepository.findById(id).get();
        return new GameDTO(result);

    }

    @Transactional(readOnly = true)
    public List<GameMinDTO> findAll() {
        List<Game> result = gameRepository.findAll();
        List<GameMinDTO> dto = result.stream().map(GameMinDTO::new).toList();
       // List<GameMinDTO> dto2 = result.stream().map(x -> new GameMinDTO(x)).toList();
        return dto;
    }

    @Transactional(readOnly = true)
    public List<GameMinDTO> findByList(Long listId) {
        List<GameMinProjection> result = gameRepository.searchByList(listId);
        return result.stream().map(GameMinDTO::new).toList();
    }
}
