package com.devsalmeida.dslistal.repositories;

import com.devsalmeida.dslistal.entities.GameList;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GameListRepository extends JpaRepository<GameList, Long> {

}
