package com.devsalmeida.dslistal.services;


import com.devsalmeida.dslistal.dto.GameListDTO;
import com.devsalmeida.dslistal.entities.GameList;
import com.devsalmeida.dslistal.projections.GameMinProjection;
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

    @Autowired
    private GameRepository gameRepository;

    @Transactional(readOnly = true)
    public List<GameListDTO> findAll(){
        List<GameList> result = gameListRepository.findAll();
        return result.stream().map(x -> new GameListDTO(x)).toList();
    }

    @Transactional
    public void move(Long listId, int sourceIndex, int destinationIndex){
        List<GameMinProjection> list = gameRepository.searchByList(listId);
        GameMinProjection object = list.remove(sourceIndex);
        list.add(destinationIndex,object);

        int min = sourceIndex < destinationIndex ? sourceIndex : destinationIndex;
        int max = sourceIndex < destinationIndex ? destinationIndex : sourceIndex;

        for( int i = min ; i <= max ; i++){
            gameListRepository.updateBelongingPosition(listId,list.get(i).getId(),i);
        }
    }

}
