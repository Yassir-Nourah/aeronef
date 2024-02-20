package com.aeronef.controller;

import com.aeronef.dto.TempDevResult;
import com.aeronef.service.impl.CruiseTemperatureService;
import com.aeronef.service.impl.TakeOffTemperatureService;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class AeronefControllerUTest {

    @MockBean
    private CruiseTemperatureService temperatureService;

    @MockBean
    private TakeOffTemperatureService takeOffTemperatureService;


    @Autowired
    private MockMvc mockMvc;

    @InjectMocks
    private AeronefController aeronefController;

    @Test
    public void testGetTemperature() throws Exception {
        final String acModel = "B772LRR";
        final String altitude = "32000";
        final String aeroPhase = "CRUISE";
        TempDevResult result = TempDevResult.builder ().tMinK (Float.valueOf (-10)).tMaxK (Float.valueOf (50))
                .build ();

        when(temperatureService.getTemperatureDeviation (anyString (), anyString (), anyString ()))
                .thenReturn (result);

        // act and assert
        mockMvc.perform(get("/temperature?acModel=B772LRR&altitude=32000&aeroPhase=CRUISE", acModel, altitude, aeroPhase))
                .andExpect(status().isOk());

        // verify
        verify(temperatureService).getTemperatureDeviation ("B772LRR", "32000", "CRUISE");


    }

    @Test
    public void testGetTemperatureWhenTakeOFF() throws Exception {
        final String acModel = "B772LRR";
        final String altitude = "32000";
        final String aeroPhase = "TAKEOFF";
        TempDevResult result = TempDevResult.builder ().tMinK (Float.valueOf (-10)).tMaxK (Float.valueOf (50))
                .build ();

        when(takeOffTemperatureService.getTemperatureDeviation (anyString (), anyString (), anyString ()))
                .thenReturn (result);

        // act and assert
        mockMvc.perform(get("/temperature?acModel=B772LRR&altitude=32000&aeroPhase=TAKEOFF", acModel, altitude, aeroPhase))
                .andExpect(status().isOk());

        // verify
        verify(takeOffTemperatureService).getTemperatureDeviation ("B772LRR", "32000", "TAKEOFF");


    }

    @Test
    public void testGetTemperatureWhenAeroPhaseIsNull() throws Exception {
        final String acModel = "B772LRR";
        final String altitude = "32000";
        final String aeroPhase = null;
        TempDevResult result = TempDevResult.builder ().tMinK (Float.valueOf (-10)).tMaxK (Float.valueOf (50))
                .build ();

        when(takeOffTemperatureService.getTemperatureDeviation (anyString (), anyString (), anyString ()))
                .thenReturn (result);

        // act and assert
        mockMvc.perform(get("/temperature?acModel=B772LRR&altitude=32000&aeroPhase=null", acModel, altitude, aeroPhase))
                .andExpect(status().is4xxClientError ());



    }
}
