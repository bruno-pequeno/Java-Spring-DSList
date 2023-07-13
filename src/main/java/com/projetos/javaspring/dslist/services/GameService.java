package com.projetos.javaspring.dslist.services;

import com.projetos.javaspring.dslist.dto.GameDTO;
import com.projetos.javaspring.dslist.dto.GameMinDTO;
import com.projetos.javaspring.dslist.entities.Game;
import com.projetos.javaspring.dslist.projections.GameMinProjection;
import com.projetos.javaspring.dslist.repositories.GameRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;

@Service
public class GameService {
    @Autowired
    public GameRepository gameRepository;

    @Transactional(readOnly = true)
    public GameDTO findById(Long id){
        Game result = gameRepository.findById(id).get();
        return new GameDTO(result);
    }
    @Transactional(readOnly = true)
    public List<GameMinDTO> findAll(){
        List<Game> result = gameRepository.findAll();
        return result.stream().map(GameMinDTO::new).toList();
    }
    @Transactional(readOnly = true)
    public List<GameMinDTO> findByLisyt(Long listId){
        List<GameMinProjection> result = gameRepository.searchByList(listId);
        return result.stream().map(GameMinDTO::new).toList();
    }
}
