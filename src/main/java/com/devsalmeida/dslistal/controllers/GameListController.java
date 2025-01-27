package com.devsalmeida.dslistal.controllers;


import com.devsalmeida.dslistal.dto.GameListDTO;
import com.devsalmeida.dslistal.dto.GameMinDTO;
import com.devsalmeida.dslistal.dto.ReplacementDTO;
import com.devsalmeida.dslistal.services.GameListService;
import com.devsalmeida.dslistal.services.GameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/lists")
public class GameListController {

    @Autowired
    private GameListService gameListService;

    @Autowired
    private GameService gameService;

    @GetMapping
    public List<GameListDTO> findAll(){
        return gameListService.findAll();
    }

    @GetMapping(value = "/{listId}/games")
    public List<GameMinDTO> findByList(@PathVariable Long listId){
        return gameService.findByList(listId);
    }

    @PostMapping(value = "/{listId}/replacement")
    public void move(@PathVariable Long listId, @RequestBody ReplacementDTO body){
        gameListService.move(listId, body.getSourceIndex(), body.getDestinationIndex());
    }

}
