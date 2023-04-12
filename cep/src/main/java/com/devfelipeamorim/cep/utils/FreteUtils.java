package com.devfelipeamorim.cep.utils;

import com.devfelipeamorim.cep.enums.Region;

import java.util.HashMap;
import java.util.Map;

import static com.devfelipeamorim.cep.enums.Region.*;
import static com.devfelipeamorim.cep.utils.Constants.*;

public class FreteUtils {

    public static final Map<Region, Double> freteMap = new HashMap<>();

    static {
        freteMap.put(SP, SUDESTE);
        freteMap.put(RJ, SUDESTE);
        freteMap.put(MG, SUDESTE);
        freteMap.put(ES, SUDESTE);
        freteMap.put(MT, CENTRO_OESTE);
        freteMap.put(MS, CENTRO_OESTE);
        freteMap.put(GO, CENTRO_OESTE);
        freteMap.put(DF, CENTRO_OESTE);
        freteMap.put(AL, NORDESTE);
        freteMap.put(BA, NORDESTE);
        freteMap.put(CE, NORDESTE);
        freteMap.put(MA, NORDESTE);
        freteMap.put(PB, NORDESTE);
        freteMap.put(PE, NORDESTE);
        freteMap.put(PI, NORDESTE);
        freteMap.put(RN, NORDESTE);
        freteMap.put(SE, NORDESTE);
        freteMap.put(PR, SUL);
        freteMap.put(SC, SUL);
        freteMap.put(RS, SUL);
        freteMap.put(AC, NORTE);
        freteMap.put(AM, NORTE);
        freteMap.put(AP, NORTE);
        freteMap.put(PA, NORTE);
        freteMap.put(RO, NORTE);
        freteMap.put(RR, NORTE);
        freteMap.put(TO, NORTE);
    }

}
