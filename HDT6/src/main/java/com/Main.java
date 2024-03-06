package com;

import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Pedir al usuario que elija el tipo de mapa
        System.out.println("¿Qué tipo de mapa desea crear? (HashMap, TreeMap, LinkedHashMap)");
        String tipoMapa = scanner.nextLine();

        // Crear instancia del lector de archivos
        TxtReaderHash txtReader = new TxtReaderHash();

        // Crear el mapa usando la fábrica
        Map<String, String> map = MapFactory.createMap(tipoMapa);

        // Leer el archivo y llenar el mapa
        if (map != null) {
            map = txtReader.readTxt("ruta/al/archivo.txt");
            if (map != null) {
                // Imprimir el contenido del mapa
                for (Map.Entry<String, String> entry : map.entrySet()) {
                    System.out.println("Key: " + entry.getKey() + ", Value: " + entry.getValue());
                }
            } else {
                System.out.println("Error al leer el archivo.");
            }
        } else {
            System.out.println("Tipo de mapa no válido.");
        }

        scanner.close();
    }
}
