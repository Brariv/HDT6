package com;
import java.util.Map;
import java.io.BufferedReader;
import java.io.FileReader;


public class TxtReader {

    public Map<String, String>  readTxt(String path, String tipoMapa) {

        Map<String, String> map = Factory.createMap(tipoMapa);
        
        try {
            BufferedReader br = new BufferedReader(new FileReader(path));
            String line = br.readLine();
            while (line != null) {
                String[] parts = line.split("\\|");
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
