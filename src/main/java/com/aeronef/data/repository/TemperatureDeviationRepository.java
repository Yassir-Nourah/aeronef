package com.aeronef.data.repository;

import com.aeronef.data.domain.TemperatureDeviationEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TemperatureDeviationRepository extends JpaRepository<TemperatureDeviationEntity, Long> {
    List<TemperatureDeviationEntity> findByAircraftId(String aircraftId);
    List<TemperatureDeviationEntity> findByAircraftIdAndAirCraftType(String acModel, String airCraftType);
}
