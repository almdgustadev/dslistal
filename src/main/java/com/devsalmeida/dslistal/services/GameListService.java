package com.devsalmeida.dslistal.services;

import com.devsalmeida.dslistal.dto.GameDTO;
import com.devsalmeida.dslistal.dto.GameListDTO;
import com.devsalmeida.dslistal.dto.GameMinDTO;
import com.devsalmeida.dslistal.entities.Game;
import com.devsalmeida.dslistal.entities.GameList;
import com.devsalmeida.dslistal.repositories.GameListRepository;
import com.devsalmeida.dslistal.repositories.GameRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class GameListService {

    @Autowired
    private GameListRepository gameListRepository;

    @Transactional(readOnly = true)
    public List<GameListDTO> findAll(){
        List<GameList> result = gameListRepository.findAll();
        return result.stream().map(x -> new GameListDTO(x)).toList();
    }

}
