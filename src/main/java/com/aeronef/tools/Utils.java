package com.aeronef.tools;

import com.aeronef.data.domain.TemperatureDeviationEntity;

import java.util.List;

public final class Utils {

    public static Float calculTemperature(List<TemperatureDeviationEntity> temperatureDeviationEntities, String altitude){

        TemperatureDeviationEntity temperature = temperatureDeviationEntities.stream( )
                .filter (temp -> Float.parseFloat (temp.getAltitude ()) == Float.parseFloat (altitude))
                .findFirst ()
                .orElse (null);
        /**
         * if altitude is on data return temperature drom data else calculate temperature
         */
        if(temperature !=null)
            return Float.parseFloat (temperature.getTemperature ());
        else{
            TemperatureDeviationEntity p1 = getP1 (temperatureDeviationEntities, Float.parseFloat (altitude));
            TemperatureDeviationEntity p2 = getP2 (temperatureDeviationEntities, Float.parseFloat (altitude));
            if(p1 != null && p2 != null){
                return Float.parseFloat (p1.getTemperature ()) + (Float.parseFloat (altitude) - Float.parseFloat (p1.getAltitude ()))
                        * (Float.parseFloat (p2.getTemperature ()) - Float.parseFloat (p1.getTemperature ()))
                        /(Float.parseFloat (p2.getAltitude ())-Float.parseFloat (p1.getAltitude ()));
            }else {
                return null;
            }

        }

    }

    /**
     * return p1 the point having p1.altitude < altitude
     */
    private static TemperatureDeviationEntity getP1(List<TemperatureDeviationEntity> temperatureDeviationEntities, float altitude){
        TemperatureDeviationEntity entityP1 = temperatureDeviationEntities.get (0);
        boolean isAltitudeStriclyLowest = true;
        for (TemperatureDeviationEntity entity : temperatureDeviationEntities) {
            if(altitude > Float.parseFloat (entity.getAltitude ())){
                entityP1 = entity;
                isAltitudeStriclyLowest = false;
            }
        }
        if(isAltitudeStriclyLowest){
            return null;
        }
        return entityP1;
    }

    /**
     * return p2 the point having p2.altitude > altitude
     */
    private static TemperatureDeviationEntity getP2(List<TemperatureDeviationEntity> temperatureDeviationEntities, float altitude){
        TemperatureDeviationEntity entityP2 = temperatureDeviationEntities.get (0);
        boolean isAltitudeStriclyHigher = true;
        for (TemperatureDeviationEntity entity : temperatureDeviationEntities) {
            if(altitude < Float.parseFloat (entity.getAltitude ())){
                entityP2 = entity;
                isAltitudeStriclyHigher = false;
                break;
            }
        }
        if(isAltitudeStriclyHigher){
            return null;
        }
        return entityP2;
    }
}
