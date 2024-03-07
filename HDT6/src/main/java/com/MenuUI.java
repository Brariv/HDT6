package com;

import java.util.Map;
import java.util.Scanner;

public class MenuUI {
    
    public void Run(){
    
        String tipoMapa = "";
        Scanner scanner = new Scanner(System.in);

        System.out.println("Bienvenido al programa de traduccion");
        System.out.println("Seleccione la implementacion que desea utilizar");
        System.out.println("1. HashMap");
        System.out.println("2. TreeMap");
        System.out.println("3. LinkedHashMap");
        
        int option = scanner.nextInt();

        String path = "C:\\Users\\JaviC\\OneDrive\\Documents\\Datos\\HDT6\\HDT6\\cards_desc.txt";
        Map<String, String> map = null; 

        switch(option){
            case 1:
                tipoMapa = "HashMap";
                map = Map(path, tipoMapa); 
                print(map);
                break;
            case 2:
                tipoMapa = "TreeMap";
                map = Map(path, tipoMapa); 
                print(map);
                break;
            case 3:
                tipoMapa = "LinkedHashMap";
                map = Map(path, tipoMapa); 
                print(map);
                break;
            default:
                System.out.println("Opcion no valida");
                break;
        }
        scanner.close();

    }

    private Map<String, String> Map(String path, String tipoMapa){
        
        TxtReader txtReader = new TxtReader();
        
        Map<String, String> map;

        map = txtReader.readTxt(path, tipoMapa);
        return map; 
    }

    private void print(Map<String, String> map) {
       
        for (Map.Entry<String, String> entry : map.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
    }
}
