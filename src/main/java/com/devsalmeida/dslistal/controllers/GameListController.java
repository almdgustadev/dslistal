package com.devsalmeida.dslistal.controllers;


import com.devsalmeida.dslistal.dto.GameListDTO;
import com.devsalmeida.dslistal.services.GameListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/lists")
public class GameListController {

    @Autowired
    private GameListService GameListService;

    @GetMapping
    public List<GameListDTO> findAll(){
        return GameListService.findAll();
    }


}
