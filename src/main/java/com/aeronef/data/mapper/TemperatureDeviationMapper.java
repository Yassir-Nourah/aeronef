package com.aeronef.data.mapper;

import com.aeronef.data.domain.TemperatureDeviationEntity;
import com.aeronef.dto.TemperatureDeviation;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface TemperatureDeviationMapper {
    List<TemperatureDeviation> mapToTemperatureDeviation(List<TemperatureDeviationEntity> temperatureDeviationEntity);
}
