package com.projetos.javaspring.dslist.dto;

import com.projetos.javaspring.dslist.entities.GameList;

public class GameListDTO {
    private long id;
    private String name;

    public GameListDTO(){

    }
    public GameListDTO(GameList entity) {
        id = entity.getId();
        name = entity.getName();
    }

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }
}
