package br.com.api.gamelist.controllers;
import br.com.api.gamelist.dto.GameListDTO;
import br.com.api.gamelist.dto.GameMinDTO;
import br.com.api.gamelist.services.GameListService;
import br.com.api.gamelist.services.GameService;
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

        return ResponseEntity.ok(gameListService.getGameLists());
    }

    @GetMapping(value = "/{listId}/games")
    public ResponseEntity<List<GameMinDTO>> findByList(@PathVariable Long listId) {
        return ResponseEntity.ok(gameService.findByList(listId));
    }
}
