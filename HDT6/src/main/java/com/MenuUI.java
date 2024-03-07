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

        String path = "C:\\Users\\Brandon\\Documents\\GitHub\\HDT6\\HDT6\\cards_desc.txt";
        //"C:\Users\Brandon\Documents\GitHub\HDT6\HDT6\cards_desc.txt"
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
        while (option != 7){
            
            System.out.println("Seleccione la opcion que desea realizar");
            System.out.println("1. Buscar una carta");
            System.out.println("2. Agregar una carta a la coleccion");
            System.out.println("3. Mostrar la coleccion");
            System.out.println("4. Mostrar la colección ordenada por tipo de carta");
            System.out.println("5. Mostrar todas las cartas disponibles");
            System.out.println("6. Mostrar todas las cartas disponibles ordenadas por tipo de carta");
            System.out.println("7. Salir");

            option = scanner.nextInt();
            Collection collection = new Collection();
            switch(option){
                case 1:
                    System.out.println("Ingrese el nombre de la carta que desea buscar");
            
                    String key = scanner.nextLine();
                    key = scanner.nextLine();
                    String value = Buscar(map, key);
                    System.out.println("El tipo de carta es: " + value);
                    break;
                case 2:
                    
                    System.out.println("Ingrese el nombre de la carta que desea agregar");
                    String cardName = scanner.nextLine();
                    cardName = scanner.nextLine();
                    // verify that the card exists
                    if (map.containsKey(cardName)) {
                        System.out.println("La carta existe");
                        String tipo = Buscar(map, cardName);
                        collection.addCard(cardName, tipo);
                    } else {
                        System.out.println("La carta no existe");
                    }
                    break;
                case 3:
                    collection.printCollection();
                    break;
                case 4:
                    collection.PrintSorted();
                    break;
                case 5:
                    print(map);
                    break;
                case 6:
                    Sortmap(map);
                    break;
                case 7:
                    break;
                default:
                    System.out.println("Opcion no valida");
                    break;
            }
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

    private String Buscar(Map<String, String> map, String key){
        return map.get(key);
    }

    private void Sortmap(Map<String, String> map){
        map.entrySet().stream().sorted(Map.Entry.comparingByValue()).forEach(System.out::println);
        

        


        

    }

}
