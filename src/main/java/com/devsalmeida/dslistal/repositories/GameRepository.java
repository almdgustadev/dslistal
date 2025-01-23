package com.devsalmeida.dslistal.repositories;

import com.devsalmeida.dslistal.entities.Game;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GameRepository extends JpaRepository<Game, Long> {

}
