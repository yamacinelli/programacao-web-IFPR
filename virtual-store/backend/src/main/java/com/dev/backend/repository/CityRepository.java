package com.dev.backend.repository;

import com.dev.backend.model.City;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CityRepository extends JpaRepository<City, Integer> {

    @Query("select c from City c where c.name = :name and c.state.abbreviation = :stateAbbreviation")
    Optional<City> findByNameAndStateAbbreviation(@Param("name") String name, @Param("stateAbbreviation") String stateAbbreviation);
}
