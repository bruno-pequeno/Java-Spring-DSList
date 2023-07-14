package com.projetos.javaspring.dslist.services;

import com.projetos.javaspring.dslist.dto.GameDTO;
import com.projetos.javaspring.dslist.dto.GameListDTO;
import com.projetos.javaspring.dslist.dto.GameMinDTO;
import com.projetos.javaspring.dslist.entities.Game;
import com.projetos.javaspring.dslist.entities.GameList;
import com.projetos.javaspring.dslist.projections.GameMinProjection;
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

    @Autowired
    public GameRepository gameRepository;

    @Transactional(readOnly = true)
    public List<GameListDTO> findAll(){
        List<GameList> result = gameListRepository.findAll();
        return result.stream().map(GameListDTO::new).toList();
    }

    @Transactional
    public void move(Long listId, int sourceIndex, int destinationIndex){
        List<GameMinProjection> list = gameRepository.searchByList(listId);
        GameMinProjection obj = list.remove(sourceIndex);
        list.add(obj);

        int min = sourceIndex < destinationIndex ? sourceIndex : destinationIndex;
        int max = sourceIndex < destinationIndex ? destinationIndex : sourceIndex;

        for (int i = min; i <= max; i++){
            gameListRepository.updateBelongingPosition(listId, list.get(i).getId(), i);
        }
    }
}
