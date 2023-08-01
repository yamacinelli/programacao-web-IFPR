package com.dev.backend.repository;

import com.dev.backend.model.Address;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AddressRepository extends JpaRepository<Address, Integer> {

    @Query("select a from Address a where a.street = :street and a.district = :district and a.cep = :cep and a.city.name = :cityName")
    Optional<Address> findByStreetAndDistrictAndCepAndCityName(@Param("street") String street, @Param("district") String district, @Param("cep") String cep, @Param("cityName") String cityName);
}
