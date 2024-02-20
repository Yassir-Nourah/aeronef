package com.aeronef.tools;

import com.aeronef.data.domain.TemperatureDeviationEntity;
import com.aeronef.enums.AirCraftDataType;

import java.util.ArrayList;
import java.util.List;

public class TestUtil {
    public static TemperatureDeviationEntity mockTemperatureDeviationEntity(long id, String aircraftId, String altitude,String temperature
    , String airCraftType){
        TemperatureDeviationEntity entity = TemperatureDeviationEntity.builder ().temperature (temperature)
                .aircraftId (aircraftId)
                .altitude (altitude)
                .id (id)
                .airCraftType (AirCraftDataType.valueOf (airCraftType).getValue ()).build ();
        return entity;
    }

    public static List<TemperatureDeviationEntity> mockTemperatureDeviationEntityListMaxF (){
        List<TemperatureDeviationEntity> deviationEntityListMaxF = new ArrayList<> (  );
        TemperatureDeviationEntity entityMaxF1 = mockTemperatureDeviationEntity(1,"B772LR","-2000.0","35.04", "TMAX_F");
        TemperatureDeviationEntity entityMaxF2 = mockTemperatureDeviationEntity(2,"B772LR","0.0","39.4", "TMAX_F");
        TemperatureDeviationEntity entityMaxF3 = mockTemperatureDeviationEntity(3,"B772LR","10000.0","39.4", "TMAX_F");
        TemperatureDeviationEntity entityMaxF4 = mockTemperatureDeviationEntity(4,"B772LR","10001.0","34.0", "TMAX_F");
        TemperatureDeviationEntity entityMaxF5 = mockTemperatureDeviationEntity(5,"B772LR","36089.0","34.0", "TMAX_F");
        TemperatureDeviationEntity entityMaxF6 = mockTemperatureDeviationEntity(6,"B772LR","43100.0","20.0", "TMAX_F");
        deviationEntityListMaxF.add (entityMaxF1);
        deviationEntityListMaxF.add (entityMaxF2);
        deviationEntityListMaxF.add (entityMaxF3);
        deviationEntityListMaxF.add (entityMaxF4);
        deviationEntityListMaxF.add (entityMaxF5);
        deviationEntityListMaxF.add (entityMaxF6);
        return deviationEntityListMaxF;
    }

    public static List<TemperatureDeviationEntity> mockTemperatureDeviationEntityListMinF (){
        List<TemperatureDeviationEntity> deviationEntityListMinF = new ArrayList<> (  );
        TemperatureDeviationEntity entityMinF1 = mockTemperatureDeviationEntity(7,"B772LR","-2000.0","-81.0", "TMIN_F");
        TemperatureDeviationEntity entityMinF2 = mockTemperatureDeviationEntity(8,"B772LR","0.0","-77.0", "TMIN_F");
        TemperatureDeviationEntity entityMinF3 = mockTemperatureDeviationEntity(9,"B772LR","32000.0","-26.6", "TMIN_F");
        TemperatureDeviationEntity entityMinF4 = mockTemperatureDeviationEntity(10,"B772LR","36089.0","-18.5", "TMIN_F");
        TemperatureDeviationEntity entityMinF5 = mockTemperatureDeviationEntity(11,"B772LR","43100.0","-18.5", "TMIN_F");
        deviationEntityListMinF.add (entityMinF1);
        deviationEntityListMinF.add (entityMinF2);
        deviationEntityListMinF.add (entityMinF3);
        deviationEntityListMinF.add (entityMinF4);
        deviationEntityListMinF.add (entityMinF5);
        return deviationEntityListMinF;
    }

    public static List<TemperatureDeviationEntity> mockTemperatureDeviationEntityListMaxG (){
        List<TemperatureDeviationEntity> deviationEntityListMaxG = new ArrayList<> (  );
        TemperatureDeviationEntity entityMaxG1 = mockTemperatureDeviationEntity(12,"B772LR","-2000.0","35.04", "TMAX_G");
        TemperatureDeviationEntity entityMaxG2 = mockTemperatureDeviationEntity(13,"B772LR","0.0","39.4", "TMAX_G");
        TemperatureDeviationEntity entityMaxG3 = mockTemperatureDeviationEntity(14,"B772LR","8500.0","39.4", "TMAX_G");
        deviationEntityListMaxG.add (entityMaxG1);
        deviationEntityListMaxG.add (entityMaxG2);
        deviationEntityListMaxG.add (entityMaxG3);
        return deviationEntityListMaxG;
    }

    public static List<TemperatureDeviationEntity> mockTemperatureDeviationEntityListMinG (){
        List<TemperatureDeviationEntity> deviationEntityListMinG = new ArrayList<> (  );
        TemperatureDeviationEntity entityMinG1 = mockTemperatureDeviationEntity(15,"B772LR","-2000.0","-73.0", "TMIN_G");
        TemperatureDeviationEntity entityMinG2 = mockTemperatureDeviationEntity(16,"B772LR","6500.0","-56.0", "TMIN_G");
        TemperatureDeviationEntity entityMinG3 = mockTemperatureDeviationEntity(17,"B772LR","8500.0","-43.0", "TMIN_G");
        deviationEntityListMinG.add (entityMinG1);
        deviationEntityListMinG.add (entityMinG2);
        deviationEntityListMinG.add (entityMinG3);
        return deviationEntityListMinG;
    }
}
