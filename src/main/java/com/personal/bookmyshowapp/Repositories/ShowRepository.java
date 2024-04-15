package com.personal.bookmyshowapp.Repositories;

import com.personal.bookmyshowapp.Models.Show;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ShowRepository extends JpaRepository<Show, Long> {
}