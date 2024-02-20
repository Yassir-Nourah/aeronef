package com.aeronef.service;

import com.aeronef.data.domain.TemperatureDeviationEntity;
import com.aeronef.data.repository.TemperatureDeviationRepository;
import com.aeronef.dto.TempDevResult;
import com.aeronef.service.impl.CruiseTemperatureService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static com.aeronef.tools.TestUtil.mockTemperatureDeviationEntityListMaxF;
import static com.aeronef.tools.TestUtil.mockTemperatureDeviationEntityListMinF;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class CruiseTemperatureServiceUTest {
    @InjectMocks
    private CruiseTemperatureService cruiseTemperatureService;
    @Mock
    private TemperatureDeviationRepository temperatureDeviationRepository;

    @Test
    void getTemperatureDeviationTest(){
        TempDevResult resultMock = TempDevResult.builder ().tMinK (Float.valueOf ("-29.75")).tMaxK (Float.valueOf ("34"))
                .build ();
        List<TemperatureDeviationEntity> deviationEntityListMaxF = mockTemperatureDeviationEntityListMaxF();
        List<TemperatureDeviationEntity> deviationEntityListMinF = mockTemperatureDeviationEntityListMinF();

        when(temperatureDeviationRepository.findByAircraftIdAndAirCraftType ("B772LRR", "TMAX_F"))
                .thenReturn (deviationEntityListMaxF);

        when(temperatureDeviationRepository.findByAircraftIdAndAirCraftType ("B772LRR", "TMIN_F"))
                .thenReturn (deviationEntityListMinF);

        TempDevResult result = cruiseTemperatureService.getTemperatureDeviation ("B772LRR", "30000", "CRUISE");

        assertEquals(result.getTMaxK (), resultMock.getTMaxK ());
    }
}
