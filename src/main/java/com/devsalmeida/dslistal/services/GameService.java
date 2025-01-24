package com.devsalmeida.dslistal.services;

import com.devsalmeida.dslistal.dto.GameDTO;
import com.devsalmeida.dslistal.dto.GameMinDTO;
import com.devsalmeida.dslistal.entities.Game;
import com.devsalmeida.dslistal.repositories.GameRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class GameService {

    @Autowired
    private GameRepository gameRepository;

    @Transactional(readOnly = true)
    public List<GameMinDTO> findAll(){
        List<Game> result = gameRepository.findAll();
        List<GameMinDTO> dtos = result.stream().map(x -> new GameMinDTO(x)).toList();
        return dtos;
    }

    @Transactional(readOnly = true)
    public GameDTO findById(Long id){
        Game result = gameRepository.findById(id).get();
        GameDTO dto = new GameDTO(result);
        return dto;
    }
}
