package br.com.api.gamelist.services;

import br.com.api.gamelist.dto.GameListDTO;
import br.com.api.gamelist.repositories.GameListRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class GameListService {

    @Autowired
    private GameListRepository gameListRepository;

    @Transactional(readOnly = true)
    public List<GameListDTO> getGameLists() {
        var gameLists = gameListRepository.findAll();
        return gameLists.stream().map(GameListDTO::new).toList();

    }
}
