package com;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.LinkedHashMap;


public class TxtReaderLinked {
    private LinkedHashMap<String, String> map = new LinkedHashMap<String, String>();

    public LinkedHashMap<String, String>  readTxt(String path) {

        
        try {
            BufferedReader br = new BufferedReader(new FileReader(path));
            String line = br.readLine();
            while (line != null) {
                String[] parts = line.split("|");
                map.put(parts[0], parts[1]);
                line = br.readLine();
            }
            br.close();
        return map;
        
        
        }
        catch (Exception e) {
            System.out.println("Error: " + e);
            return null;
        }
}
}
