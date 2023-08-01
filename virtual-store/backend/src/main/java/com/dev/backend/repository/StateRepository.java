package com.dev.backend.repository;

import com.dev.backend.model.State;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface StateRepository extends JpaRepository<State, Integer> {

    @Query("select s from State s where s.name = :name and s.abbreviation = :abbreviation")
    Optional<State> findByNameAndAbbreviation(@Param("name") String name, @Param("abbreviation") String abbreviation);
}
