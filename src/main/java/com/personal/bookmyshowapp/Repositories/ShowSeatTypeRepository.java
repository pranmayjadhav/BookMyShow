package com.personal.bookmyshowapp.Repositories;

import com.personal.bookmyshowapp.Models.Show;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ShowSeatTypeRepository extends JpaRepository<ShowSeatTypeRepository, Long> {
    List<ShowSeatTypeRepository> findAllByShow(Show show);
}
