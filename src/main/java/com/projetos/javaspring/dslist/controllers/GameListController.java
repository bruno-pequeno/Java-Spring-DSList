package com.projetos.javaspring.dslist.controllers;

import com.projetos.javaspring.dslist.dto.GameDTO;
import com.projetos.javaspring.dslist.dto.GameListDTO;
import com.projetos.javaspring.dslist.dto.GameMinDTO;
import com.projetos.javaspring.dslist.dto.ReplacementDTO;
import com.projetos.javaspring.dslist.entities.GameList;
import com.projetos.javaspring.dslist.services.GameListService;
import com.projetos.javaspring.dslist.services.GameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/lists")
public class GameListController {

    @Autowired
    public GameListService gameListService;
    @Autowired
    public GameService gameService;

    @GetMapping
    public List<GameListDTO> findAll(){
        List<GameListDTO> result = gameListService.findAll();
        return result;
    }
    @GetMapping(value = "/{listId}/games")
    public List<GameMinDTO> findByList(@PathVariable Long listId){
        List<GameMinDTO> result = gameService.findByLisyt(listId);
        return result;
    }
    @PostMapping(value = "/{listId}/replacement")
    public void move(@PathVariable Long listId, @RequestBody ReplacementDTO body){
       gameListService.move(listId, body.getSourceIndex(), body.getDestinationIndex());

    }
}
