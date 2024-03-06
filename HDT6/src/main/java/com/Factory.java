package com;

import java.util.HashMap;
import java.util.Map;

public class MapFactory {
    public static Map<String, String> createMap(String tipo) {
        switch (tipo.toLowerCase()) {
            case "hashmap":
                return new HashMap<>();
            case "treemap"
                return new TreeMap<>();
            case "linkedhashmap"
                return new LinkedHashMap<>();
            default:
                return null;
        }
    }
}
