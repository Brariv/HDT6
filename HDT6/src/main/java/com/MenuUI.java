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

        String path = "cards_desc.txt";
        switch(option){
            case 1:
                tipoMapa = "HashMap";
                Map(path, tipoMapa);
                break;
            case 2:
                tipoMapa = "TreeMap";
                Map(path, tipoMapa);
                break;
            case 3:
                tipoMapa = "LinkedHashMap";
                Map(path, tipoMapa);
                break;
            default:
                System.out.println("Opcion no valida");
                break;
        }
        scanner.close();

    }

    private void Map(String path, String tipoMapa){
        // Crear instancia del lector de archivos
        TxtReader txtReader = new TxtReader();

        
        Map<String, String> map;

        map = txtReader.readTxt(path, tipoMapa);
    }


    
}
