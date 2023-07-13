package com.projetos.javaspring.dslist.services;

import com.projetos.javaspring.dslist.dto.GameDTO;
import com.projetos.javaspring.dslist.dto.GameListDTO;
import com.projetos.javaspring.dslist.dto.GameMinDTO;
import com.projetos.javaspring.dslist.entities.Game;
import com.projetos.javaspring.dslist.entities.GameList;
import com.projetos.javaspring.dslist.repositories.GameListRepository;
import com.projetos.javaspring.dslist.repositories.GameRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class GameListService {
    @Autowired
    public GameListRepository gameListRepository;

    @Transactional(readOnly = true)
    public List<GameListDTO> findAll(){
        List<GameList> result = gameListRepository.findAll();
        return result.stream().map(GameListDTO::new).toList();
    }
}
